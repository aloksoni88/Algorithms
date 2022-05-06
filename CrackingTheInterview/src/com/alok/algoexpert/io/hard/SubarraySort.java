/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class SubarraySort {
	public static void main(String[] args) {
//		int[] arr = {-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7};
		int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
//		int[] result = subarraySort(arr);
		int[] result = subarraySortOptimize(arr);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] subarraySortOptimize(int[] array) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0; i<array.length-1; i++) {
			if(array[i] > array[i+1]) {
				if(min > array[i+1]) {
					min = array[i+1];
				}
				if(max < array[i]) {
					max = array[i];
				}
			}
		}
		System.out.println("Min:" + min + " & Max:" + max);
		if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
			return new int[] {-1,-1};
		}
		int minIndex = -1, maxIndex = -1;
		for(int i=0; i<array.length; i++) {
			if(minIndex == -1 && array[i] > min) {
				minIndex = i;
			}
			if(maxIndex == -1 && array[array.length-1-i] < max) {
				maxIndex = array.length-1-i;
			}
		}
		
		return new int[] {minIndex,maxIndex};
	}

	public static int[] subarraySort(int[] array) {
		int[] tmp = array.clone();
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(tmp));
		int minIndex = -1, maxIndex = -1;
		for(int i=0; i<array.length; i++) {
			if(minIndex == -1 && tmp[i] != array[i]) {
				minIndex = i;
			}
			if(maxIndex == -1 && tmp[array.length-1-i] != array[array.length-1-i]) {
				maxIndex = array.length-1-i;
			}
			if(minIndex != -1 && maxIndex != -1) {
				break;
			}
		}
		return new int[] {minIndex,maxIndex};
	}
}
