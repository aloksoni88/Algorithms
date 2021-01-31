/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class LongestIncreasingSubsequenceCount {
	public static void main(String[] args) {
		int[] array = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
		//int[] array = {1, 5, -1, 10};
		List<Integer>  result= longestIncreasingSubsequence(array);
		System.out.println(result);
	}
	
	//Time - O(nlog(n)), Space - O(n) where n is the no of element in an array
	public static List<Integer> longestIncreasingSubsequence(int[] array) {
		if (array == null || array.length == 0) {
			return new ArrayList<>();
		}
		int[] indices = new int[array.length+1];
		int[] sequences = new int[array.length];
		
		Arrays.fill(indices, -1);
		
		int length = 0;
		for(int i=0; i<array.length; i++) {
			int num = array[i];
			int newLength = binarySearch(1, length, array, indices, num);
			sequences[i] = indices[newLength-1];
			indices[newLength] = i;
			length = Math.max(newLength, length);
		}		
		
		ArrayList<Integer> result = new ArrayList<>();
		int currentIndex = indices[length];
		while(currentIndex != -1) {
			result.add(0,array[currentIndex]);
			currentIndex = sequences[currentIndex];
		}
		return result;
	}
	
	private static int binarySearch(int startIdx, int endIdx, int[] array, int[] indices, int num) {
		if(startIdx > endIdx) {
			return startIdx;
		}
		int mid = (startIdx + endIdx)/2;
		if(num > array[indices[mid]]) {
			startIdx = mid+1;
		}else {
			endIdx = mid-1;
		}
		return binarySearch(startIdx, endIdx, array, indices, num);
	}

	//Time - O(n^2), Space - O(n) where n is the length of an array
	public static List<Integer> longestIncreasingSubsequence2(int[] array) {
		if (array == null || array.length == 0) {
			return new ArrayList<>();
		}
		int[] length = new int[array.length];
		int[] index = new int[array.length];
		Arrays.fill(length, 1);
		Arrays.fill(index, -1);
		
		int maxLengthIdx = 0;
		for(int i=1; i< array.length; i++) {
			for(int j=0; j<i; j++) {
				if(array[i] > array[j] && (1+length[j]) >= length[i]) {
					length[i] = 1+length[j];									
					index[i] = j;
				}
			}
			if(length[i] >= length[maxLengthIdx]) {
				maxLengthIdx = i;
			}
		}
		System.out.println(Arrays.toString(length));
		System.out.println(Arrays.toString(index));
		System.out.println(maxLengthIdx);
		
		List<Integer> result = new ArrayList<>();
		int currentIndex = maxLengthIdx;
		while(currentIndex != -1) {
			result.add(0,array[currentIndex]);
			currentIndex = index[currentIndex];
		}
		return result;
	}
	
}
