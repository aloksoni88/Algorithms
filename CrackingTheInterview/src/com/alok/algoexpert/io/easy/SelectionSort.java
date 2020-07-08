/**
 * 
 */
package com.alok.algoexpert.io.easy;

/**
 * @author Alok Soni
 *
 */
public class SelectionSort {
	public static int[] selectionSort(int[] array) {
	    if(array == null || array.length == 0){
					return array;
			}
	    
			for(int i=0; i<array.length-1; i++){
					int smallest = i;
					for(int j= i+1; j< array.length; j++){
							if(array[smallest] > array[j]){
									smallest = j;
							}
					}
					if(smallest != i){
							swap(array, smallest, i);
					}
			}
			return array;
	  }
		
		private static void swap(int[] arr, int i, int j){
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
		}
}
