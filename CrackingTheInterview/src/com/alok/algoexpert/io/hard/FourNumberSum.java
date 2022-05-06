/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Alok Soni
 *
 */
public class FourNumberSum {
	public static void main(String[] args) {
		int[] arr = {7, 6, 4, -1, 1, 2};
//		List<Integer[]> result = fourNumberSum(arr, 16);
		List<Integer[]> result = fourNumberSumOptimize(arr, 16);
		if(!result.isEmpty()) {
			for(Integer[] a : result) {
				System.out.println(Arrays.toString(a));
			}
		}
	}
	
	private static List<Integer[]> fourNumberSumOptimize(int[] arr, int targetSum){
		List<Integer[]> result = new ArrayList<>();
		Map<Integer, Integer[]> map = new HashMap<>();
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int sum = arr[i] + arr[j];
				map.put(sum, new Integer[]{i,j});
			}
		}
		for(Map.Entry<Integer, Integer[]> entry: map.entrySet()) {
			System.out.print(entry.getKey() + ": " + Arrays.toString(entry.getValue()) + ", ");
		}
		System.out.println();
//	    map.keySet().forEach(key -> System.out.print(key+", "));
//	    System.out.println();
//		map.values().forEach( val -> System.out.print(Arrays.toString(val)));
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int sum = arr[i] + arr[j];
				if(map.containsKey(targetSum - sum)) {
					Integer[] value = map.get(targetSum - sum);
					if(value[0] != i && value[0] != j && value[1] != i && value[1] != j) {
						int currentSum = arr[i] * arr[j] * arr[value[0]] * arr[value[1]];
						boolean isExist = false;
						for(Integer[] resArr : result) {
							int resultSum = resArr[0] * resArr[1] * resArr[2] * resArr[3];
							if(currentSum == resultSum) {
								isExist = true;
								break;
							}
						}
						if(!isExist) {
							result.add(new Integer[] {arr[i],arr[j],arr[value[0]],arr[value[1]]});
						}
					}
				}
			}
		}
		return result;
	}
	
	//Time - O(n^2 * n) - n^3, Space- O(n)
	private static List<Integer[]> fourNumberSum(int[] arr, int targetSum){
		Arrays.sort(arr);
		List<Integer[]> result = new ArrayList<>();
		for(int i=0; i<arr.length-3; i++) {
			for(int j=i+1; j<arr.length-2; j++) {
				int left = j+1 ;
				int right = arr.length-1;
				
				while(left < right) {
					int sum = arr[i] + arr[j] + arr[left] + arr[right];
					if(sum == targetSum) {
						Integer[] a = new Integer[] {arr[right],arr[left],arr[j],arr[i]};
						result.add(a);
						left++;
						right--;
					}else if(sum < targetSum) {
						left++;
					}else {
						right--;
					}
				}
			}
		}
		return result;
	}
}
