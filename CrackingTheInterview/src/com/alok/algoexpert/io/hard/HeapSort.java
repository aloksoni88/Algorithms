/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		//int[] arr = {-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8};
		int[] arr = {-7, 2, 3, 8, -10, 4};
		int[] sortedArr = heapSort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}

	//in all cases - best, average and worst case
	//Time - O(nlog(n))
	//Space - O(1)
	public static int[] heapSort(int[] array) {
		int n = array.length;
		for(int i= n/2-1; i>=0; i--) {
			heapify(array, i, n);
		}
		System.out.println(Arrays.toString(array));
		System.out.println();
		for(int i= n-1; i>=0; i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			
			heapify(array, 0, i);
			System.out.println(Arrays.toString(array));
		}
		return array;
	}
	
	private static void heapify(int[] array, int i, int size) {
		int largest = i;
		int leftChild  = 2*i + 1;
		int rightChild = 2*i + 2;
		
		if(leftChild < size && array[leftChild] > array[largest]) {
			largest = leftChild;
		}
		if(rightChild < size && array[rightChild] > array[largest]) {
			largest = rightChild;
		}
		if(largest != i) {
			int tmp = array[i];
			array[i] = array[largest];
			array[largest] = tmp;
			
			heapify(array, largest, size);
		}
	}
}
