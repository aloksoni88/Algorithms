/**
 * 
 */
package com.alok.algoexpert.io.hard;

/**
 * @author Alok Soni
 *
 */
public class QuickSelect {
	public static void main(String[] args) {
		int[] arr = { 102, 41, 58, 81, 2, -5, 1000, 10021, 181, -14515, 25, 15 };
		int k = 5;

		int kthSmallestElement = quickselect(arr, k);
		System.out.println("kth smallest element is : " + kthSmallestElement);
	}

	// Best case - Time - O(n), Space - O(1)
	// Average case - Time - O(n), Space - O(1)
	// Worst case - Time - O(n^2), Space - O(1)
	public static int quickselect(int[] array, int k) {
		if (array == null || array.length == 0) {
			return -1;
		} else if (k > array.length) {
			return -1;
		}
		return quickselect(array, k, 0, array.length - 1);
	}

	public static int quickselect(int[] array, int k, int startIdx, int endIdx) {
		int pivot = startIdx, left = startIdx;
		int right = endIdx;
		while (true) {

			while (array[pivot] <= array[right] && pivot != right) {
				right--;
			}

			if (pivot == right) {
				if (pivot == k - 1) {
					return array[pivot];
				} else if (pivot > k - 1) {
					endIdx = pivot - 1;
				} else {
					startIdx = pivot + 1;
				}

				if (startIdx == endIdx) {
					return array[startIdx];
				}

				pivot = left = startIdx;
				right = endIdx;
			}

			if (array[pivot] > array[right]) {
				array = swap(pivot, right, array);
				pivot = right;
			}

			while (array[pivot] >= array[left] && pivot != left) {
				left++;
			}

			if (pivot == left) {
				if (pivot == k - 1) {
					return array[pivot];
				} else if (pivot > k - 1) {
					endIdx = pivot - 1;
				} else {
					startIdx = pivot + 1;
				}

				if (startIdx == endIdx) {
					return array[startIdx];
				}

				pivot = left = startIdx;
				right = endIdx;
			}

			if (array[pivot] < array[left]) {
				array = swap(pivot, left, array);
				pivot = left;
			}
		}
	}

	private static int[] swap(int a, int b, int[] arr) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return arr;
	}
}
