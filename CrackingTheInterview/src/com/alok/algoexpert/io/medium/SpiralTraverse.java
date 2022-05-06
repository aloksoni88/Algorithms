/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class SpiralTraverse {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		int[][] arr2 = { { 4, 2, 3, 6, 7, 8, 1, 9, 5, 10 }, { 12, 19, 15, 16, 20, 18, 13, 17, 11, 14 } };
//		List<Integer> result = spiralTraverse(arr2);
//		System.out.println(result);
		
		int[][] array = { {1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}};
		int[] result = sprialArray(array);
		System.out.println(Arrays.toString(result));

	}

	public static List<Integer> spiralTraverse(int[][] array) {
		if (array == null || array.length == 0) {
			return new ArrayList<Integer>();
		}

		int startRow = 0, startCol = 0;
		int endRow = array.length - 1, endCol = array[0].length - 1;
		List<Integer> resultList = new ArrayList();
		while (startRow <= endRow && startCol <= endCol) {
			for (int i = startCol; i <= endCol; i++) {
				resultList.add(array[startRow][i]);
			}
			for (int i = startRow + 1; i <= endRow; i++) {
				resultList.add(array[i][endCol]);
			}

			// if column has more than the row count
			if (startRow != endRow) {
				for (int i = endCol - 1; i >= startCol; i--) {
					resultList.add(array[endRow][i]);
				}
			}

			// if row has more than the column count
			if (startCol != endCol) {
				for (int i = endRow - 1; i > startRow; i--) {
					resultList.add(array[i][startCol]);
				}
			}

			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
		return resultList;
	}
	
	private static int[] sprialArray(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;

		int[] result = new int[n*m];
		int startRow = 0, startCol = 0, endRow = n-1, endCol = m-1;
		int index = 0;
		while(startRow <= endRow && startCol <= endCol){
			for(int i=startCol; i<=endCol; i++){
				result[index++] = arr[startRow][i];
			}

			for(int i = startRow+1; i<= endRow; i++){
				result[index++] = arr[i][endCol];
			}

			if(startRow != endRow){
				for(int i=endCol-1; i>= startCol; i--){
					result[index++] = arr[endRow][i];
				}
			}
			


			if(startCol != endCol){
				for(int i=endRow-1; i>startRow; i--){
					result[index++] = arr[i][startCol];
				}
			}
			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
		return result;
	}

}
