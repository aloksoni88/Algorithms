/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


/**
 * @author Alok Soni
 *
 */
public class MaxSumIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = {8, 12, 2, 3, 15, 5, 7};
		List<List<Integer>> result = maxSumIncreasingSubsequence(arr);
		System.out.println(result);
	}
	

	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		if(array.length == 1) {
			return new ArrayList<List<Integer>>() {
				{
					add(List.of(array[0])); // Example max sum
					add(List.of(array[0])); // Example max sequence
				}
			};
		}
		List<List<Integer>> result = new ArrayList<>();
		int[] sumArr = new int[array.length];
		Integer[] indexArr = new Integer[array.length];
		//sumArr = array;
		
		indexArr[0] =  null;
		sumArr[0] = array[0];
		int max = array[0];
		int maxIndex = 0;
		
		for(int i=1; i<array.length; i++) {
			for(int j=0; j<i; j++) {
				if(array[i] > array[j] && (array[i] + sumArr[j]) > sumArr[i]) {
					sumArr[i] =  sumArr[j] + array[i];					
					if(sumArr[i] > max) {
						max = sumArr[i];
						maxIndex = i;
					}
					indexArr[i] = j;
				}
			}
			if(sumArr[i] == 0) {
				sumArr[i] = array[i];
				if(sumArr[i] > max) {
					max = sumArr[i];
					maxIndex = i;
				}
				indexArr[i] = null;
			}
		}
		ArrayList<Integer> maxItem = new ArrayList<>();
		maxItem.add(max);
		result.add(maxItem);
		
		List<Integer> itemList = new ArrayList<>();
		while(indexArr[maxIndex] != null) {
			itemList.add(0,array[maxIndex]);
			maxIndex = indexArr[maxIndex];
		}
		itemList.add(0,array[maxIndex]);
		
//		System.out.println(itemList);
//		System.out.println(max);
//		System.out.println(Arrays.toString(sumArr));
//		System.out.println(Arrays.toString(indexArr));
		
		result.add(1,itemList);
		return result;
	}
}
