/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Alok Soni
 *
 */
public class NumberSum {

	public static void main(String[] args) {
		int[] arr = {3,5,-4,8,11,1,-1,6};
		int sum = 10;
		int[] result = twoNumberSum(arr, sum);
		System.out.println(Arrays.toString(result));
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
}
