/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class SearchInSortedMatrix {
	public static void main(String[] args) {
		int[][] arr = { 
						{ 1, 4, 7, 12, 15, 1000 }, 
						{ 2, 5, 19, 31, 32, 1001 }, 
						{ 3, 8, 24, 33, 35, 1002 },
						{ 40, 41, 42, 44, 45, 1003 },
						{ 99, 100, 103, 106, 128, 1004 } 
					 };
		int[] result = searchInSortedMatrix(arr, 1088);
		System.out.println(Arrays.toString(result));
	}

	

	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		// Write your code here.
		if (matrix == null || matrix.length == 0) {
			return new int[]{-1,-1};
		}
		return search(matrix,target);
		// for (int i = 0; i < matrix.length; i++) {
		// 	int index = binarySearch(matrix[i],0,matrix[i].length-1, target);
		// 	if(index != -1) {
		// 		return new int[] {i,index};
		// 	}
		// }
		// return new int[]{-1,-1};
	}

	//optimzed way to solve
	//Time - O(n)
	//Space - O(1)
	private static int[] search(int[][] matrix, int target){
			int row = 0;
			int column = matrix[0].length-1;
			while(row < matrix.length && column >= 0){
					if(matrix[row][column] == target ){
							return new int[]{row,column};
					}else if(matrix[row][column] > target){
							column--;
					}else{
							row++;
					}
			}
			return new int[]{-1,-1};
	}

	//Time - O(n*logm)
	//Space - O(1)
	private static int binarySearch(int[] arr, int low, int high,int target) {
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == target) {
				return mid;
			}
			if(low == high) {
				return -1;
			}
			if(target > arr[mid]) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return -1;
	}
}
