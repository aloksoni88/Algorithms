/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class KadanesAlgorithm {
	public static int kadanesAlgorithm(int[] array) {
		int sum = findMaxSum(array);
		return sum;
	}

//Reducing the space complexity to constant space
	private static int findMaxSum(int[] arr) {
		int prevSum = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int val = Math.max((prevSum + arr[i]), arr[i]);
			prevSum = val;
			if (val > max) {
				max = val;
			}
		}
		return max;
	}

	/*
	 * private static int findMaxSum(int[] arr) { int[] tmpArr = new
	 * int[arr.length]; tmpArr[0] = arr[0]; int max = tmpArr[0]; for(int i=1;
	 * i<arr.length; i++) { int val = Math.max((tmpArr[i-1] + arr[i]), arr[i]);
	 * tmpArr[i] = val; if(val > max) { max = val; } } return max; }
	 */
}
