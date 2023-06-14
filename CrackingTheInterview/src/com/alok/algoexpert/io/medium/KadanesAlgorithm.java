/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class KadanesAlgorithm {
	
	public static void main(String[] args) {
		int[] arr = {3, 5, -9, 1, 3, -2, -3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
		System.out.println(maxSum(arr));
	}
	
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
	
	private static int maxSum(int[] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i=0; i< arr.length; i++) {
			sum = sum + arr[i];
			if (max < sum) {
				max = sum;
			}
			if (sum < arr[i]) {
				sum = arr[i];
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
