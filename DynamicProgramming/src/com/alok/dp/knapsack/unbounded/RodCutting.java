/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 *
 */

/**
 * 
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size
 *  smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 *   For example, if length of the rod is 8 and the values of different pieces are given as following, 
 *   then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *   
	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 1   5   8   9  10  17  17  20
	And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
	
	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 3   5   8   9  10  17  17  20
 * 
 *
 */
public class RodCutting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
		//int[] price =  {1, 5, 8, 9, 10,17,17,20};
		int[] price = {3, 5, 8, 9, 10 , 17 , 17 , 20};
		int totalLength = 8;
		//int maxValue = rodCuttingRecursive(length, price, totalLength, length.length);
		int maxValue = rodCuttingTabulation(length, price, totalLength, length.length);
		System.out.println(maxValue);
	}
	
	private static int rodCuttingRecursive(int[] length, int[] price, int totalLength, int n) {
		if(n == 0 || totalLength == 0) {
			return 0;
		}
		if(length[n-1] <= totalLength) {
			return Integer.max(price[n-1] + rodCuttingRecursive(length, price, (totalLength - length[n-1]), n), 
					rodCuttingRecursive(length, price, totalLength, n-1));	
		}else {
			return rodCuttingRecursive(length, price, totalLength, n-1);
		}
	}
	
	private static int rodCuttingTabulation(int[] length, int[] price, int totalLength, int n) {
		int[][] t = new int[n+1][totalLength+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<totalLength+1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}else if(length[i-1] <= j) {
					t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]); 
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][totalLength];
	}

}
