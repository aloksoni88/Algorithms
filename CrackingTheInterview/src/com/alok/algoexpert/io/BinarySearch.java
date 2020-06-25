/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
		int result = binarySearch(arr, 45);
		System.out.println(result);
		
	}
	public static int binarySearch(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int low = 0;
		int high = array.length-1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				return mid;
			}
			if (target > array[mid]) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return -1;
	}
}
