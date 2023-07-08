package com.cn.easy;

import java.util.Arrays;

public class SetZeros {
	public static void main(String[] args) {
//		int[][] arr = { { 1, 2, 3 }, 
//						{ 4, 0, 6 }, 
//						{ 7, 8, 9 }, 
//					};
		int[][] arr = { 
					{ 1, 0 }, 
					{ 2, 7 }, 
					{ 3, 0 },
					{ 4, 8 },
				};
		
		setZeros(arr);
		for (int[] a: arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	

	public static void setZeros(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] refArr = new boolean[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (!refArr[i][j] && matrix[i][j] == 0) {
					makeCellZero(i, j, matrix, refArr);
				}
			}
		}
	}

	private static void makeCellZero(int row, int column, int[][] arr, boolean[][] refArr) {
		int i = row, j = column;
		while (j - 1 >= 0 && arr[i][j-1] != 0) {
			j = j-1;
			arr[i][j] = 0;
			refArr[i][j] = true;
		}
		i = row;
		j = column;
		while (i - 1 >= 0 && arr[i-1][j] != 0) {
			i = i-1;
			arr[i][j] = 0;
			refArr[i][j] = true;
		}
		i = row;
		j = column;
		while (j + 1 < arr[0].length && arr[i][j+1] != 0) {
			j = j+1;
			arr[i][j] = 0;
			refArr[i][j] = true;
		}
		i = row;
		j = column;
		while (i + 1 < arr.length && arr[i+1][j] != 0) {
			i = i+1;
			arr[i][j] = 0;
			refArr[i][j] = true;
		}
	}
}
