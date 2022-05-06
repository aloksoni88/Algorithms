/**
 * 
 */
package com.alok.algoexpert.io.hard;

/**
 * @author Alok Soni
 *
 */
public class ShiftedBinarySearch {
	public static void main(String[] args) {
		int[] arr = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
		int target = 1;
		int result = shiftedBinarySearch(arr, target);
		System.out.println(result);
	}

	//Time - O(log(n))
	//Space - O(1)
	public static int shiftedBinarySearch(int[] array, int target) {
		if(array == null) {
			return -1;
		}else if(array.length == 1) {
			if(target == array[0]) {
				return 0;
			}else {
				return -1;
			}
		}
		int left =  0;
		int right = array.length-1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(target == array[mid]) {
				return mid;
			}
			else if(array[left] <= array[mid]) {
				if(target < array[mid] && target >= array[left]) {
					right = mid-1;
				}else {
					left = mid + 1;
				}
			}else {
				if(target > array[mid] && target <= array[right]) {
					left = mid +1;
				}else {
					right = mid-1;
				}
			}
		}
		return -1;
	}
}
