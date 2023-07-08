/**
 * 
 */
package com.alok.algoexpert.io.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class TwoNumberSum {

	public static void main(String[] args) {
		int[] arr = { -4, 7, -3, 4, -8, 4, 4, 0, -6, -7, 6, 9, 3, 5, 4, -1, -1, -6, -9, 0, 9, -3, 8 ,
				5, 2, 6, 2, 0, 9, -4, -3, 0 ,0 ,8 ,4 };
		int sum = -7;
//		int[] arr = { 2, -3, 3, 3, -2 };
//		int sum = 0;
//		int[] result = twoNumberSum(arr, sum);
		//Arrays.sort(arr);
		List<int[]> result = pairSum(arr, sum);
		
//		List<int[]> result = findPairsWithSum(arr, sum);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(Arrays.toString(result.get(i)));
		}
	}

	public static int[] twoNumberSum(int[] array, int targetSum) {
		if (array == null || array.length == 0) {
			return new int[0];
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			int value = targetSum - array[i];
			if (set.contains(value)) {
				return new int[] { value, array[i] };
			}
			set.add(array[i]);
		}
		return new int[0];
	}

	public static List<int[]> pairSum(int[] arr, int s) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int value = s - arr[i];
			if (map.containsKey(value)) {
				int count = map.get(value);
				for (int k = 0; k < count; k++) {
					list.add(value < arr[i] ? new int[] { value, arr[i] } : new int[] {arr[i], value});
				}
			}
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		list.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return Integer.compare(a[0], b[0]);
				} else {
					return Integer.compare(a[1], a[1]);
				}
			}
		});
		return list;
	}

	public static List<int[]> findPairsWithSum(int[] arr, int targetSum) {
		List<int[]> result = new ArrayList<>();
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int currentSum = arr[left] + arr[right];

			if (currentSum == targetSum) {
				result.add(arr[left] < arr[right] 
						? new int[] { arr[left], arr[right] }
						: new int[] {arr[right], arr[left]});
				left++;
				right--;
			} else if (currentSum < targetSum) {
				left++;
			} else {
				right--;
			}
		}

//		result.sort((a, b) -> {
//			if (a[0] != b[0]) {
//				return Integer.compare(a[0], b[0]);
//			} else {
//				return Integer.compare(a[1], b[1]);
//			}
//		});

		return result;
	}

}
