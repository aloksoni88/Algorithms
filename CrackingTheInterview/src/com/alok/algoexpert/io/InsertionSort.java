/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class InsertionSort {
	public static void main(String[] args) {
		//int[] arr = { 8, 5, 2, 9, 5, 6, 3 };
		int[] arr = {7,23,0,8,1,8,3,45,9,4,10};
		int[] sortedArr = insertionSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}
	
	public static int[] insertionSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		for (int i = 1; i < array.length; i++) {
			int element = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (element < array[j]) {
					array[j + 1] = array[j];
				}else {
					break;
				}
			}
			array[j + 1] = element;
		}

		return array;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
