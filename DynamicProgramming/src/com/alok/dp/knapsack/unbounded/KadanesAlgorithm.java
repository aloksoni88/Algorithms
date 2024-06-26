/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class KadanesAlgorithm {
	public static void main(String[] args) {
		int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
		//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		int[] arr = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
		int sum = findMaxSum(arr);
//		int sum = findMaxSumOptimized(arr);
//		int sum = getDistance(arr);
		System.out.println("Maximum sum of sub array is " + sum);
	}
	
	//Reducing the space complexity to constant space
	private static int findMaxSumOptimized(int[] arr) {
		int prevSum = arr[0];
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			int val = Math.max((prevSum + arr[i]), arr[i]);
			prevSum = val;
			if(val > max) {
				max = val;
			}
		}
		return max;
	}
	
	private static int findMaxSum(int[] arr) {
		int[] tmpArr = new int[arr.length];
		tmpArr[0] = arr[0];
		int max = tmpArr[0];
		for(int i=1; i<arr.length; i++) {
			int val = Math.max((tmpArr[i-1] + arr[i]), arr[i]);
			tmpArr[i] = val;
			if(val > max) {
				max = val;
			}
		}
		System.out.println(Arrays.toString(tmpArr));
		return max;
	}

}
