/**
 * 
 */
package com.alok.algoexpert.io.easy;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class ThreeLargestNumbers {
	public static void main(String[] args) {
		int[] arr = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
//		int[] result = findThreeLargestNumbers(arr);
		int[] result = threeLargestNumber(arr);
		System.out.println(Arrays.toString(result));
	}
	public static int[] findThreeLargestNumbers(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > first) {
				third = second;
				second = first;
				first = array[i];
			} else if (array[i] > second) {
				third = second;
				second = array[i];
			} else if (array[i] > third) {
				third = array[i];
			}
		}
		return new int[] { third, second, first };
	}
	
	public static int[] threeLargestNumber(int[] arr) {
		if (arr == null || arr.length == 0) {
			return new int[] { -1, -1, -1 };
		}
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int thirdLargest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstLargest) {
				thirdLargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = arr[i];
			} else if (arr[i] > secondLargest) {
				thirdLargest = secondLargest;
				secondLargest = arr[i];
			} else if (arr[i] > thirdLargest) {
				thirdLargest = arr[i];
			}
		}
		return new int[] { thirdLargest, secondLargest, firstLargest };
	}
}
