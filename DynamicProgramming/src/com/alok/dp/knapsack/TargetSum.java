/**
 * 
 */
package com.alok.dp.knapsack;

/**
 * @author Alok Soni
 *
 */

/**
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 */
public class TargetSum {
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1};
		int sum = 3;
		int n = arr.length;
		//this problem is same as CountSubsetSumOfGiveDiff
		//s1 = subset 1
		//s2 = subset 2
		
		//as per given condition 
		//s1 - s2 = sum
		
		//as per above condition, below condition should satisfy
		//s1 + s2 = sum of array
		
		//we can get formula
		//2s1 = (sum + sum of array) i.e 
		
		//s1 = (sum + item_total)/2 //final formaul
		int itemTotal = 0;
		for(int i=0; i<n; i++) {
			itemTotal = itemTotal + arr[i];
		}
		int subsetSum = (sum + itemTotal)/2;
		//int count = targetSumRecursive(arr, n, subsetSum);
		int count = targetSumTabulation(arr, n, subsetSum);
		System.out.println(count);
	}
	
	private static int targetSumRecursive(int[] arr, int n, int sum) {
		if(sum == 0) {
			return 1;
		}else if(n==0 && sum != 0) {
			return 0;
		}
		if(arr[n-1] <= sum) {
			return targetSumRecursive(arr, n-1, sum-arr[n-1]) + targetSumRecursive(arr, n-1, sum);
		}else {
			return targetSumRecursive(arr, n-1, sum);
		}
	}
	
	private static int targetSumTabulation(int[] arr, int n, int subsetSum) {
		int[][] t = new int[n+1][subsetSum+1];
		for(int i=0; i<subsetSum+1; i++) {
			t[0][i] = 0;
		}
		for(int i=0; i<n+1; i++) {
			t[i][0] = 1;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<subsetSum+1;j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][subsetSum];
	}
}

