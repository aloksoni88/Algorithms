/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8};
		int[] sortedArr = quickSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}
	
	public static int[] quickSort(int[] array) {
		if(array == null || array.length ==0) {
			return new int[] {};
		}else if(array.length == 1) {
			return new int[] {array[0]};
		}
		return quickSort(array,0, array.length-1);
	}

	public static int[] quickSort(int[] array, int low, int high) {
		int left = low;
		int right = high;
		int piv = left;
		if(left >= right) {
			return array;
		}
		
		while(true) {
			while(array[piv] <= array[right] && piv != right) {
				right--;
			}
			
			if(piv == right) {
				break;
			}
			
			if(array[piv] > array[right]) {
				array = swap(piv, right, array);
				piv = right;
			}
			
			
			while(array[piv] >= array[left] && piv != left) {
				left++;
			}
			
			if(piv == left) {
				break;
			}
			
			if(array[piv] < array[left]) {
				array = swap(piv, left, array);
				piv = left;
			}
		}
		
		//System.out.println(Arrays.toString(array));
		quickSort(array,low, piv-1);
		quickSort(array,piv+1, high);
		return array;
	}
	
	private static int[] swap(int a, int b, int[] arr) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return arr;
	}
}
