/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] array = { 8, 5, 2, 9, 5, 6, 3 };
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	/******************* Iterative method *************************/
	public static int[] mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}	
		sort(array);
		return array;
	}
	
	// Best case : Time - O(nlog(n)) Space- O(n)
	// Avg case : Time - O(nlog(n)) Space- O(n)
	// Worst case : Time - O(nlog(n)) Space- O(n)
	private static void sort(int[] array) {
		int len = array.length;
		int[] tmp = new int[len];
		for(int size=1; size< len; size= size*2) {
			int l1 = 0;
			int k = 0;
			while(l1+ size < len) {
				int h1 = l1 + size-1;
				int l2 = h1 +1;
				int h2 = l2 + size -1;
				
				if(h2 >= len) {
					h2 = len-1;
				}
				int i=l1;
				int j=l2;
				
				while(i <= h1 && j <= h2) {
					if(array[i] < array[j]) {
						tmp[k++] = array[i++];
					}else {
						tmp[k++] = array[j++];
					}
				}	
				while(i <= h1) {
					tmp[k++] = array[i++];
				}
				while(j <= h2) {
					tmp[k++] = array[j++];
				}
				l1 = h2+1;
			}
			for(int i=l1; k< len; i++) {
				tmp[k++] = array[i];
			}
			for(int i=0; i<tmp.length; i++){
				array[i] = tmp[i];
			}			
		}
	}
	
	/******************* with auxilury array *************************/
	// Best case : Time - O(nlog(n)) Space- O(n)
	// Avg case : Time - O(nlog(n)) Space- O(n)
	// Worst case : Time - O(nlog(n)) Space- O(n)
	public static int[] mergeSort3(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		sort(array, 0, array.length - 1, array.clone());
		return array;
	}

	private static void sort(int[] array, int low, int high, int[] auxArray) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(auxArray, low, mid, array);
			sort(auxArray, mid + 1, high, array);
			merge(array, low, mid, high, auxArray);
		}
	}

	private static void merge(int[] array, int low, int mid, int high, int[] auxArray) {
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (auxArray[i] < auxArray[j]) {
				array[k++] = auxArray[i++];
			} else {
				array[k++] = auxArray[j++];
			}
		}
		while (i <= mid) {
			array[k++] = auxArray[i++];
		}
		while (j <= high) {
			array[k++] = auxArray[j++];
		}
	}

	/******************* without auxilury array *************************/
	// Best case : Time - O(nlog(n)) Space- O(nlog(n))
	// Avg case : Time - O(nlog(n)) Space- O(nlog(n))
	// Worst case : Time - O(nlog(n)) Space- O(nlog(n))
	public static void mergeSort2(int[] array) {
		if (array != null && array.length > 1) {
			sort(0, array.length - 1, array);
		}
	}

	private static void sort(int low, int end, int[] arr) {
		if (low < end) {
			int mid = (low + end) / 2;
			sort(low, mid, arr);
			sort(mid + 1, end, arr);
			merge(low, mid, end, arr);
		}
	}

	private static void merge(int low, int mid, int end, int[] arr) {
		int i = low;
		int j = mid + 1;
		int k = low;
		int[] sortedArr = new int[arr.length];
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				sortedArr[k++] = arr[i++];
			} else {
				sortedArr[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			sortedArr[k++] = arr[i++];
		}
		while (j <= end) {
			sortedArr[k++] = arr[j++];
		}

		for (i = low; i <= end; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
