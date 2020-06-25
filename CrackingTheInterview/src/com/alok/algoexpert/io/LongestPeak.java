/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class LongestPeak {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 };
		int result = longestPeak(arr);
		System.out.println(result);
	}

	public static int longestPeak(int[] array) {
		if (array == null || array.length <= 2) {
			return 0;
		}
		int peakCount = 0;
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
				int currentPeakCount = getPeakCount(array, i - 1, i + 1);
				if (peakCount < currentPeakCount) {
					peakCount = currentPeakCount;
				}
				// i++;
			}
		}
		return peakCount;
	}

	private static int getPeakCount(int[] arr, int left, int right) {
		int peakCount = 3;
		while (left >= 0 && right <= arr.length) {
			if (left != 0 && arr[left] > arr[left - 1]) {
				peakCount++;
				left--;
			} else if (right != arr.length - 1 && arr[right] > arr[right + 1]) {
				peakCount++;
				right++;
			} else {
				return peakCount;
			}
		}
		return peakCount;
	}
}
