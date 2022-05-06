/**
 * 
 */
package com.array;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class PrintMatrixDiagonal {
	public static void main(String[] args) {
		int[][] arr= { 	{1,3,6,10},
						{2,5,9,13},
						{4,8,12,15},
						{7,11,14,16}
					};
		int row = arr.length;
		int column = arr[0].length;
		int[] result = new int[row * column];
		int count = 0;
		for(int k=0; k<row; k++) {
			int i = k;
			int j = 0;
			while(i >= 0) {
				result[count++] = arr[i][j];
				i = i-1;
				j = j+1;
			}
		}
		
		for(int k=1; k<row; k++) {
			int i = row-1;
			int j = k;
			while(j < row) {
				result[count++] = arr[i][j];
				i = i-1;
				j = j+1;
			}
		}
		
		System.out.println(Arrays.toString(result));
	}
}
