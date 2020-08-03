/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class MinNumberOfJumps {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 6, 2, 1, 1, 1, 1 };
		//int noOfJumps = minNumberOfJumps(arr);
		int noOfJumps = minNumberOfJumpsOptimize(arr);
		System.out.println("Min no of jumps : " + noOfJumps);
	}

	// Time - O(n)
	// Space - O(1)
	public static int minNumberOfJumpsOptimize(int[] array) {
		if (array == null) {
			return -1;
		} else if (array.length == 1) {
			return 0;
		} else if (array.length == 2) {
			return 1;
		}

		int noOfJumps = 0;
		int steps = array[0];
		int maxReach = array[0];
		for (int i = 1; i < array.length-1; i++) {
			maxReach = Math.max(maxReach, array[i]+i);
			steps--;
			if(steps == 0) {
				noOfJumps++;
				steps = maxReach - i;
			}
		}
		return noOfJumps+1;
	}

	// Time - O(n^2)
	// Space - O(n)
	public static int minNumberOfJumps(int[] array) {
		if (array == null) {
			return -1;
		} else if (array.length == 1) {
			return 0;
		} else if (array.length == 2) {
			return 1;
		}

		int[] jumpArr = new int[array.length];
		Arrays.fill(jumpArr, Integer.MAX_VALUE);
		jumpArr[0] = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((j + array[j]) >= i) {
					jumpArr[i] = Math.min(jumpArr[i], jumpArr[j] + 1);
				}
			}
		}
		return jumpArr[jumpArr.length - 1];
	}

}
