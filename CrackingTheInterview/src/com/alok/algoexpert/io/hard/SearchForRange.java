/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class SearchForRange {
	public static void main(String[] args) {
		int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 45, 45, 45};
		int target = 45;
		int[] range = searchForRange(array, target);
		System.out.println(Arrays.toString(range));
	}

	//Time - O(log(n)) , n is the number of elements in array
	//Space - O(1)
	public static int[] searchForRange(int[] array, int target) {
		if(array == null) {
			return new int[] { -1, -1 };	
		}else if(array.length == 1) {
			if(array[0] == target) {
				return new int[] { 0, 0 };		
			}
		}
		int leftRange = getRange(array, target, true);
		int rightRange = getRange(array, target, false);
		return new int[] { leftRange, rightRange };
	}
	
	private static int getRange(int[] array, int target, boolean isLeft ) {
		int left = 0;
		int right = array.length-1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(target == array[mid]) {
				if(isLeft) {
					if(mid == 0) {
						return 0;
					}else if(array[mid-1] != target) {
						return mid;
					}else {
						right = mid-1;
					}
				}else {
					if(mid == array.length-1) {
						return array.length-1;
					}else if(array[mid+1] != target) {
						return mid;
					}else {
						left = mid+1;
					}
				}
			}else if(target < array[mid]){
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return -1;
	}
}
