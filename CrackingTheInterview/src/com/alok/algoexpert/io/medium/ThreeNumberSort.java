/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class ThreeNumberSort {
	public static void main(String[] args) {
		int[] arr1 = { 0, 10, 10, 10, 10, 10, 25, 25, 25, 25, 25 };
		int[] arr2 = { 25, 10, 0 };
		System.out.println(Arrays.toString(arr1));
		int[] result = threeNumberSort3(arr1, arr2);
		System.out.println(Arrays.toString(result));
	}

	// Time - O(n), Space - O(1) where n is the length of array
	public static int[] threeNumberSort(int[] array, int[] order) {
		if (array == null || array.length == 0) {
			return new int[] {};
		} else if (array.length == 1) {
			return array;
		}
		int swapIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == order[0]) {
				swapItem(array, swapIndex, i);
				swapIndex++;
			}
		}
		System.out.println(swapIndex);
		System.out.println(Arrays.toString(array));
		swapIndex = array.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == order[2]) {
				swapItem(array, swapIndex, i);
				swapIndex--;
			}
		}
		return array;
	}

	private static void swapItem(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// Time - O(n), Space - O(1) where n is the length of array
	public static int[] threeNumberSort2(int[] array, int[] order) {
		if (array == null || array.length == 0) {
			return new int[] {};
		} else if (array.length == 1) {
			return array;
		}
		int firstItemCount = 0, secondItemCount = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == order[0]) {
				firstItemCount++;
			} else if (array[i] == order[1]) {
				secondItemCount++;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (i <= firstItemCount - 1) {
				array[i] = order[0];
			} else if (i >= firstItemCount && i < (firstItemCount + secondItemCount)) {
				array[i] = order[1];
			} else {
				array[i] = order[2];
			}
		}
		return array;
	}

	// Time - O(n), Space - O(1) where n is the length of array
	public static int[] threeNumberSort3(int[] array, int[] order) {
		if (array == null || array.length == 0) {
			return new int[] {};
		} else if (array.length == 1) {
			return array;
		}
		int firstIndex = 0,secondIndex = 0, lastIndex = array.length-1;
		for (int i = 0; i < array.length; i++) {			
			if(array[secondIndex] == order[0] ) {
				swapItem(array,firstIndex,secondIndex);
				firstIndex++;
				secondIndex++;
			}else if(array[secondIndex] == order[1] ) {													
				secondIndex++;
			}else if(array[secondIndex] == order[2] ) {
				swapItem(array, lastIndex, secondIndex);										
				lastIndex--;
			}
			if(secondIndex > lastIndex) {
				break;
			}
			
		}

		return array;
	}
}
