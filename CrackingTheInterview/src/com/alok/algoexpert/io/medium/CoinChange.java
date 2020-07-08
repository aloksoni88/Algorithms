/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of 
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins 
 * doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 *  So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 *  there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 *  So the output should be 5.
 * 
 *
 */
public class CoinChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {2, 5, 3, 6};
		int total = 10;
		//int noOfWays = numberOfWaysRecursive(coins, total, coins.length);
		int noOfWays = numberOfWaysTabulation(coins,total,coins.length);
		System.out.println(noOfWays);
	}
	
	private static int numberOfWaysRecursive(int[] coins, int total, int n) {
		if(total == 0) {
			return 1;
		}else if(n == 0 && total != 0) {
			return 0;
		}
		if(coins[n-1] <= total) {
			return numberOfWaysRecursive(coins, total-coins[n-1], n) 
					+ numberOfWaysRecursive(coins, total, n-1);
		}else {
			return numberOfWaysRecursive(coins, total, n-1);
		}
	}
	
	private static int numberOfWaysTabulation(int[] coins, int total, int n) {
		int[][] t = new int[n+1][total+1];
		for(int i=0; i<total+1; i++) {
			t[0][i] = 0;
		}
		for(int i=0; i<n+1; i++) {
			t[i][0] = 1;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<total+1; j++) {
				if(coins[i-1] <= j) {
					t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][total];
	}

}
