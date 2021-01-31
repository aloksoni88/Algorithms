/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Alok Soni
 *
 */
public class FirstDuplicateValue {
	public static void main(String[] args) {
		int[] array = {3, 1, 3, 1, 1, 4, 4};		
		int result = firstDuplicateValue3(array);
		System.out.println(result);
	}

	//Time - O(n), Space - O(n) where n is the length of an array
	public static int firstDuplicateValue(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<array.length; i++) {
			if(list.contains(array[i])) {
				return array[i];
			}
			list.add(array[i]);
		}
		return -1;
	}
	
	//Time - O(n^2), Space - O(1) where n is the length of an array
	public static int firstDuplicateValue2(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int minIndex = Integer.MAX_VALUE;
		for(int i=0; i<array.length-1; i++) {
			int currentValue = array[i];
			for(int j=i+1; j< array.length; j++) {
				if(currentValue == array[j]) {
						minIndex = Math.min(minIndex, j);
				}
			}
		}
		return minIndex == Integer.MAX_VALUE ? -1 : array[minIndex];
	}
	
	// Time - O(n), Space - O(1) where n is the length of an array
	public static int firstDuplicateValue3(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		for (int i = 0; i < array.length; i++) {
			int index = Math.abs(array[i]);
			if (array[index - 1] < 0) {
				return index;
			}
			array[index - 1] = (-1) * array[index - 1];
		}
		return -1;
	}
}
