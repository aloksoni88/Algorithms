/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alok Soni
 *
 */
public class ApartmentHunting {
	public static void main(String[] args) {
		List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();

	    blocks.add(0, new HashMap<String, Boolean>());
	    blocks.get(0).put("gym", true);
	    blocks.get(0).put("office", false);
	    blocks.get(0).put("pool", false);
	    blocks.get(0).put("school", true);
	    blocks.get(0).put("store", false);

	    blocks.add(1, new HashMap<String, Boolean>());
	    blocks.get(1).put("gym", false);
	    blocks.get(1).put("office", false);
	    blocks.get(1).put("pool", false);
	    blocks.get(1).put("school", false);
	    blocks.get(1).put("store", false);

	    blocks.add(2, new HashMap<String, Boolean>());
	    blocks.get(2).put("gym", false);
	    blocks.get(2).put("office", true);
	    blocks.get(2).put("pool", false);
	    blocks.get(2).put("school", true);
	    blocks.get(2).put("store", false);

	    blocks.add(3, new HashMap<String, Boolean>());
	    blocks.get(3).put("gym", false);
	    blocks.get(3).put("office", true);
	    blocks.get(3).put("pool", false);
	    blocks.get(3).put("school", false);
	    blocks.get(3).put("store", false);

	    blocks.add(4, new HashMap<String, Boolean>());
	    blocks.get(4).put("gym", false);
	    blocks.get(4).put("office", false);
	    blocks.get(4).put("pool", false);
	    blocks.get(4).put("school", false);
	    blocks.get(4).put("store", true);
	    
	    blocks.add(5, new HashMap<String, Boolean>());
	    blocks.get(5).put("gym", true);
	    blocks.get(5).put("office", true);
	    blocks.get(5).put("pool", false);
	    blocks.get(5).put("school", false);
	    blocks.get(5).put("store", false);
	    
	    blocks.add(6, new HashMap<String, Boolean>());
	    blocks.get(6).put("gym", false);
	    blocks.get(6).put("office", false);
	    blocks.get(6).put("pool", true);
	    blocks.get(6).put("school", false);
	    blocks.get(6).put("store", false);
	    
	    blocks.add(7, new HashMap<String, Boolean>());
	    blocks.get(7).put("gym", false);
	    blocks.get(7).put("office", false);
	    blocks.get(7).put("pool", false);
	    blocks.get(7).put("school", false);
	    blocks.get(7).put("store", false);
	    
	    blocks.add(8, new HashMap<String, Boolean>());
	    blocks.get(8).put("gym", false);
	    blocks.get(8).put("office", false);
	    blocks.get(8).put("pool", false);
	    blocks.get(8).put("school", false);
	    blocks.get(8).put("store", false);
	    
	    blocks.add(9, new HashMap<String, Boolean>());
	    blocks.get(9).put("gym", false);
	    blocks.get(9).put("office", false);
	    blocks.get(9).put("pool", false);
	    blocks.get(9).put("school", true);
	    blocks.get(9).put("store", false);
	    
	    blocks.add(10, new HashMap<String, Boolean>());
	    blocks.get(10).put("gym", false);
	    blocks.get(10).put("office", false);
	    blocks.get(10).put("pool", true);
	    blocks.get(10).put("school", false);
	    blocks.get(10).put("store", false);

	    String[] reqs = new String[] {"gym", "pool", "school", "store"};
	    int bestApartmentBlock = apartmentHunting(blocks, reqs);
	    System.out.println(bestApartmentBlock);
	}
	
	//Time - O(B*R) 
	//Space - O(B* R)
	//where B is the length of block and R is the length of requirements
	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
		int row = -1;
		int resultIndex = -1;
		int[][] locationArr = new int[reqs.length][blocks.size()];

		for(String req : reqs) {
			int closest = Integer.MAX_VALUE;
			row++;
			//System.out.println("row=" + row + ", req=" + req);
			for(int i=0; i<blocks.size(); i++) {
				if(blocks.get(i).get(req)) {
					locationArr[row][i] = 0;
					closest = i;
				}else {
					int existingValue = locationArr[row][i] != 0 ? locationArr[row][i] : Integer.MAX_VALUE;
					locationArr[row][i] = Math.min(existingValue, Math.abs(i-closest));
				}
			}
			
			for(int i=blocks.size()-1; i>=0; i--) {
				if(blocks.get(i).get(req)) {
					locationArr[row][i] = 0;
					closest = i;
				}else {
					int existingValue = locationArr[row][i] != 0 ? locationArr[row][i] : Integer.MAX_VALUE;
					locationArr[row][i] = Math.min(existingValue, Math.abs(i-closest));
				}
			}
		}

		for(int[] arr : locationArr) {
			System.out.println(Arrays.toString(arr));
		}
		int minDistance = Integer.MAX_VALUE;
		for(int i=0; i<blocks.size(); i++) {
			int max = Integer.MIN_VALUE;
			for(int j=0; j< locationArr.length; j++) {
				if(max < locationArr[j][i]) {
					max= locationArr[j][i];
				}
			}
			if(minDistance > max) {
				minDistance = max;
				resultIndex = i;
			}
		}
		return resultIndex;
	}

	//Time - O(b^2*r) where b is the number of blocks and r is the number of requirement
	//Space - O(1)
	public static int apartmentHunting2(List<Map<String, Boolean>> blocks, String[] reqs) {
		int minMovement = Integer.MAX_VALUE;
		int resultIndex = -1;
		for(int i=0; i< blocks.size(); i++) {	
			int max = Integer.MIN_VALUE;
			
			for(String req: reqs) {
				int min = Integer.MAX_VALUE;
				
				for(int k=0; k< blocks.size(); k++) {
					Map<String, Boolean> block = blocks.get(k);
					if(block.get(req)) {
						min = Math.min(min, Math.abs(i-k));
					}
				}
				if(min > max) {
					max = min;
				}
			}	
			
			if(minMovement > max) {
				minMovement = max;
				resultIndex = i;
			}
		}
		return resultIndex;
	}
}
