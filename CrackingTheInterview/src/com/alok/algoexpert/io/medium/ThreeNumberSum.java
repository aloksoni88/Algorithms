/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.*;

/**
 * @author Alok Soni
 *
 */

class ThreeNumberSum {
	
//	[1, 2, 15]
//	[1, 8, 9]
//	[2, 7, 9]
//	[3, 6, 9]
//	[3, 7, 8]
//	[4, 5, 9]
//	[4, 6, 8]
//	[5, 6, 7]

	public static void main(String[] args) {
		//int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
		int[] array = {12,3,1,2,-6,5,-8,6};
		int targetSum = 0;
		List<Integer[]> list = threeNumberSumProblem(array, targetSum);
		for(Integer[] a : list) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	public static List<Integer[]> threeNumberSumOptimize(int[] array, int targetSum){
		List<Integer[]> list = new ArrayList<Integer[]>();
		Arrays.sort(array);
		for(int i=0; i<array.length; i++) {
			int left = i+1;
			int right = array.length-1;
			
			int sum = 0;
			while(left < right) {
				sum = array[i] + array[left] + array[right];
				if(sum == targetSum) {
					list.add(new Integer[] {array[i],array[left],array[right]});
					left++;
					right--;
				}else if(sum > targetSum) {
					right--;
				}else if(sum < targetSum) {
					left++;
				}
			}
		}
		
		return list;
	}
	
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			int value = targetSum - array[i];
			if (i == array.length - 1) {
				continue;
			}
			List<Integer[]> arr = findSum(array, value, i, array[i]);
			if (!arr.isEmpty()) {
				list.addAll(arr);
			}
			if (!list.isEmpty()) {
				Collections.sort(list, new Comparator<Integer[]>() {

					@Override
					public int compare(Integer[] o1, Integer[] o2) {
						if(Integer.compare(o1[0], o2[0]) == 0) {
							return Integer.compare(o1[1], o2[1]);
						}
						return Integer.compare(o1[0], o2[0]);
					}
				});
			}
		}
		return list;
	}

	private static List<Integer[]> findSum(int[] array, int sum, int ignoreIndex,int firstValue) {
		HashSet<Integer> set = new HashSet<>();
		List<Integer[]> list = new ArrayList<>();
		for (int i = ignoreIndex + 1; i < array.length; i++) {
			int value = sum - array[i];
			if (set.contains(value)) {
				Integer[] intArr = new Integer[3];
				intArr[0] = firstValue;
				intArr[1] = value;
				intArr[2] = array[i];
				list.add(intArr);
			}
			set.add(array[i]);
		}
		return list;

	}
	
	public static List<Integer[]> threeNumberSum2(int[] array, int targetSum) {
		List<Integer[]> result = new ArrayList<>();
		Arrays.sort(array);
		for(int i=0; i<array.length; i++) {
			int s = i+1;
			int e = array.length - 1;
			while(s < e) {
				int sum = array[i] + array[s] + array[e];
				if(sum == targetSum) {
					result.add(new Integer[]{array[i], array[s], array[e]});
					s++;
					e--;
				} else if(sum < targetSum) {
					s++;
				} else {
					e--;
				}
			}
		}
		return result;
  }
	
	private static List<Integer[]> threeNumberSumProblem(int[] arr, int target){
		Arrays.sort(arr);
		List<Integer[]> result = new ArrayList<Integer[]>();
		for(int i=0; i<arr.length; i++){
			int left = i+1;
			int right = arr.length -1;

			while(left < right){
				int sum = arr[i]  +arr[left] + arr[right];
				if(sum == target){
					result.add(new Integer[] { arr[i], arr[left], arr[right] });
					left++;
					right--;
				}else if(sum > target){
					right--;
				}else{
					left++;
				}
			}
		}	
		return result;
	}

}
