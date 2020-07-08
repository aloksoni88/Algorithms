/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class MinNumberCoinChange {

	public static void main(String[] args) {
		int[] coins = {2,4};
		int total = 7;
		//int noOfWays = minNumCoinRecursive(coins, total, coins.length);
		int noOfWays = minNumCoinTabulation(coins,total,coins.length);
		if(noOfWays == Integer.MAX_VALUE-1) {
			System.out.println(-1);
		}else {
			System.out.println(noOfWays);
		}
	}
	
	private static int minNumCoinRecursive(int[] coins, int total, int n) {
		if(total == 0) {
			return 0;
		}else if(n == 0 && total != 0) {
			return Integer.MAX_VALUE-1;
		}
		if(coins[n-1] <= total) {
			return Math.min(minNumCoinRecursive(coins, total-coins[n-1], n)+1,minNumCoinRecursive(coins, total, n-1));
		}else {
			return minNumCoinRecursive(coins, total, n-1);
		}
	}
	
	private static int minNumCoinTabulation(int[] coins, int total, int n) {
		int[][] t = new int[n+1][total+1];
		for(int i=0; i<total+1; i++) {
			t[0][i] = Integer.MAX_VALUE-1;
		}
		for(int i=0; i<n+1; i++) {
			t[i][0] = 0;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<total+1; j++) {
				if(coins[i-1] <= j) {
					t[i][j] = Math.min(t[i][j-coins[i-1]]+1, t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][total];
	}

}
