/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class RiverSizesProblem {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
		                  {1, 0, 0, 1, 0},
		                  {1, 0, 1, 0, 0},
		                  {0, 0, 1, 0, 1},
		                  {1, 0, 1, 0, 1},
		                  {1, 0, 1, 1, 0}
						};
		List<Integer> riverSizes = riverSizes(matrix);
		System.out.println("River Sizes : "+ riverSizes);
	}
	
	public static List<Integer> riverSizes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		List<Integer> riverSizes = new ArrayList<Integer>();
		boolean[][] tmpArr = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(tmpArr[i][j]) {
					continue;
				}
				if(matrix[i][j] == 1) {
					riverSizes.add(traverse(matrix, tmpArr, i, j, 1));
					tmpArr[i][j] = true;
				}else {
					tmpArr[i][j] = true;
				}
			}
		}
		if(riverSizes.size() > 1) {
			Collections.sort(riverSizes);
		}
		return riverSizes;
	}
	
	private static int traverse(int[][] matrix, boolean[][] tmpArr, int i, int j,int count) {
		if(tmpArr[i][j] || matrix[i][j] == 0) {
			return 0;
		}
		if(i-1 >= 0 && !tmpArr[i-1][j] && matrix[i-1][j] == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i-1, j, ++count));
			tmpArr[i-1][j] = true;
		}
		if(j-1 >= 0 && !tmpArr[i][j-1] && matrix[i][j-1] == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i, j-1, ++count));
			tmpArr[i][j-1] = true;
		}
		if(j+1 <= matrix[0].length-1 && !tmpArr[i][j+1] && matrix[i][j+1] == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i, j+1, ++count));
			tmpArr[i][j+1]= true;
		}
		if(i+1 <= matrix.length-1 && !tmpArr[i+1][j] && matrix[i+1][j] == 1) {
			tmpArr[i][j] = true;
			count = Math.max(count,traverse(matrix, tmpArr, i+1, j, ++count));
			tmpArr[i+1][j]= true;
		}
		return count;
	}
}
