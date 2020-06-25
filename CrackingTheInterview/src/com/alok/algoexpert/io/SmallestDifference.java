/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class SmallestDifference {
	public static void main(String[] args) {
		int[] arrayOne = {-1, 5, 10, 20, 3};
		int[] arrayTwo = {26, 134, 135, 15, 17};
		//int[] result = smallestDifference(arrayOne, arrayTwo);
		int[] result = smallestDifferenceOptimized(arrayOne, arrayTwo);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] smallestDifferenceOptimized(int[] arrayOne, int[] arrayTwo) {

		int minDiff = Integer.MAX_VALUE;
		int arrayOneIndex = -1;
		int arrayTwoIndex = -1;
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);

		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo.length; j++) {
				int currentMinDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
				if (currentMinDiff == 0) {
					arrayOneIndex = i;
					arrayTwoIndex = j;
					return new int[] { arrayOne[arrayOneIndex], arrayTwo[arrayTwoIndex] };
				} else if (arrayOne[i] < arrayTwo[j]) {
					if(currentMinDiff < minDiff) {
						minDiff = currentMinDiff;
						arrayOneIndex = i;
						arrayTwoIndex = j;
					}else {
						break;
					}
				} else if(arrayOne[i] > arrayTwo[j] ) {
					if(currentMinDiff < minDiff) {
						minDiff = currentMinDiff;
						arrayOneIndex = i;
						arrayTwoIndex = j;
					}
					continue;
				}else {
					if(currentMinDiff < minDiff) {
						minDiff = currentMinDiff;
						arrayOneIndex = i;
						arrayTwoIndex = j;
					}
					break;
				}
			}
		}
		return new int[] { arrayOne[arrayOneIndex], arrayTwo[arrayTwoIndex] };
	}

	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

		int minDiff = Integer.MAX_VALUE;
		int arrayOneIndex = -1;
		int arrayTwoIndex = -1;

		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo.length; j++) {
				int currentMinDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
				if (currentMinDiff == 0) {
					arrayOneIndex = i;
					arrayTwoIndex = j;
					return new int[] { arrayOne[arrayOneIndex], arrayTwo[arrayTwoIndex] };
				} else if (currentMinDiff < minDiff) {
					minDiff = currentMinDiff;
					arrayOneIndex = i;
					arrayTwoIndex = j;
				}
			}
		}
		return new int[] { arrayOne[arrayOneIndex], arrayTwo[arrayTwoIndex] };
	}
}
