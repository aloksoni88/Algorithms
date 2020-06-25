package com.array;

import java.util.Arrays;

public class RotateMatrixBy90Degree {
	public static void main(String[] args) {
		int[][] arr = {	{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9},
					  };
		
		int[][] output = rotateMatrixBy90Degree(arr);
		System.out.println("Array rotation by 90 degree");
		for(int[] row : output) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println();
		int[][] output2 = rotateMatrixBy180Degree(arr);
		System.out.println("Array rotation by 180 degree");
		for(int[] row : output2) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	private static int[][] rotateMatrixBy90Degree(int[][] arr){
		int[][] output = new int[arr.length][arr.length];
//		for(int i=2; i>=0; i--) {
//			for(int j=0; j<arr.length; j++) {
//				output[2-i][j] = arr[j][i];
//			}
//		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				output[i][j] = arr[j][2-i];
			}
		}
		
		return output;
	}
	
	private static int[][] rotateMatrixBy180Degree(int[][] arr){
		int[][] output = new int[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				output[i][j] = arr[2-i][2-j];
			}
		}
		return output;
	}
}
