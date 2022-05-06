/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class SmallestDifference {
	public static void main(String[] args) {
		int[] arrayOne = {-1, -5, 10, 20, 288, 3};	//-1, 3, 5 10,20,28
		int[] arrayTwo = {26, -14, 135, 15, -9,210,39, 289};	//15,17,26,134,135
		//int[] result = smallestDifference(arrayOne, arrayTwo);
		int[] result = smallestDifferenceOptimized(arrayOne, arrayTwo);
//		int[] result = smallestDiff(arrayOne, arrayTwo);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] smallestDiff(int[] arrOne, int[] arrTwo) {
		int minDiff = Integer.MAX_VALUE;
		int arrOneIdx = -1;
		int arrTwoIdx = -1;
		Arrays.sort(arrOne);
		Arrays.sort(arrTwo);
		System.out.println(Arrays.toString(arrOne));
		System.out.println(Arrays.toString(arrTwo));
		int i=0, j=0;
		while(i < arrOne.length-1 && j < arrTwo.length-1) {
			int min = Math.abs(arrOne[i] - arrTwo[j]);
			if(min == 0) {
				return new int[] {arrOne[i], arrTwo[j]};
			}
			if(min < minDiff) {
				minDiff = min;
				arrOneIdx = i;
				arrTwoIdx = j;
			}
			if(arrOne[i] < arrTwo[j]) {
				i++;
			}else {
				j++;
			}
		}
		if(i < arrOne.length-1) {
			while(i < arrOne.length) {
				int min = Math.abs(arrOne[i] - arrTwo[arrTwo.length-1]);
				if(min < minDiff) {
					minDiff = min;
					arrOneIdx = i;
					arrTwoIdx = arrTwo.length-1;
				}
				i++;
			}
		}
		
		if(j < arrTwo.length-1) {
			while(j < arrTwo.length) {
				int min = Math.abs(arrOne[arrOne.length-1] - arrTwo[j]);
				if(min < minDiff) {
					minDiff = min;
					arrOneIdx = arrOne.length-1;
					arrTwoIdx = j;
				}
				j++;
			}
		}
		return new int[] {arrOne[arrOneIdx], arrTwo[arrTwoIdx]};
	}
	
	public static int[] smallestDifferenceOptimized(int[] arrayOne, int[] arrayTwo) {

		int minDiff = Integer.MAX_VALUE;
		int arrayOneIndex = -1;
		int arrayTwoIndex = -1;
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		System.out.println(Arrays.toString(arrayOne));
		System.out.println(Arrays.toString(arrayTwo));
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
