/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 8, 5, 2, 9, 5, 6, 3 };
		int[] sortedArr = bubbleSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] bubbleSort(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		boolean isSwapping = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					isSwapping = true;
					swap(array, j, j + 1);
				}
			}
			if(!isSwapping) {
				break;
			}
		}
		return array;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
