/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

/**
 * @author Alok Soni
 *
 */
public class IndexEqualsValue {
	public static void main(String[] args) {
		int[] arr = { -12, 1, 2, 3, 12 };
		int index = indexEqualsValueOptimized2(arr);
		System.out.println(index);
	}

	//iterative
	// Time- O(log(n)) , Space - O(1) where n is the length of an array
	public static int indexEqualsValueOptimized(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == mid && mid == 0) {
				return mid;
			} else if (array[mid] == mid && array[mid - 1] < (mid - 1)) {
				return mid;
			} else if (array[mid] < mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	//recursive
	// Time- O(log(n)) , Space - O(log(n)) where n is the length of an array
	public static int indexEqualsValueOptimized2(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		return indexEqualsValue(array, 0, array.length-1);
	}
	
	private static int indexEqualsValue(int[] array, int left, int right) {
		if(left > right) {
			return -1;
		}
		int mid = (left + right)/2;
		if (array[mid] == mid && mid == 0) {
			return mid;
		} else if (array[mid] == mid && array[mid - 1] < (mid - 1)) {
			return mid;
		} else if (array[mid] < mid) {
			return indexEqualsValue(array, mid+1, right);
		} else {
			return indexEqualsValue(array, left, mid-1);
		}
	}

	// Time- O(n) , Space - O(1) where n is the length of an array
	public static int indexEqualsValue(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				continue;
			}
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}
}
