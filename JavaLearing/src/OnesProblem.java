import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnesProblem {
	public static void main(String[] args) {

	}

	public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {
		int m = grid.size();
		int n = grid.get(0).size();
		List<Integer> riverSizes = new ArrayList<Integer>();
		boolean[][] tmpArr = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(tmpArr[i][j]) {
					continue;
				}
				if(grid.get(i).get(j) == 1) {
					riverSizes.add(traverse(grid, tmpArr, i, j, 1));
					tmpArr[i][j] = true;
				}else {
					tmpArr[i][j] = true;
				}
			}
		}
		if(riverSizes.size() > 1) {
			Collections.sort(riverSizes);
		}
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<riverSizes.size(); i++) {
			if(map.containsKey(riverSizes.get(i))) {
				int v = map.get(riverSizes.get(i));
				map.put(riverSizes.get(i), v+1);
			}else {
				map.put(riverSizes.get(i), 1);
			}
		}
		for(int i=0; i<queries.size(); i++) {
			if(map.containsKey(queries.get(i))){
				result.add(map.get(queries.get(i)));
			}else {
				result.add(0);
			}
		}
		return result;
	}
	
	private static int traverse(List<List<Integer>> matrix, boolean[][] tmpArr, int i, int j,int count) {
		if(tmpArr[i][j] || matrix.get(i).get(j) == 0) {
			return 0;
		}
		if(i-1 >= 0 && !tmpArr[i-1][j] && matrix.get(i-1).get(j) == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i-1, j, ++count));
			tmpArr[i-1][j] = true;
		}
		if(j-1 >= 0 && !tmpArr[i][j-1] && matrix.get(i).get(j-1) == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i, j-1, ++count));
			tmpArr[i][j-1] = true;
		}
		if(j+1 <= matrix.get(0).size()-1 && !tmpArr[i][j+1] && matrix.get(i).get(j+1) == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i, j+1, ++count));
			tmpArr[i][j+1]= true;
		}
		if(i+1 <= matrix.size()-1 && !tmpArr[i+1][j] && matrix.get(i+1).get(j) == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i+1, j, ++count));
			tmpArr[i+1][j]= true;
		}
		return count;
	}
}
