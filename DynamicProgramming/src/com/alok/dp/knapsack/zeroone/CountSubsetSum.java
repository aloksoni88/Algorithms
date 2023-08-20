package com.alok.dp.knapsack.zeroone;

/**
 * @author Alok Soni
 *
 */
public class CountSubsetSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 6, 3};
		int sum = 6;
		int n = arr.length;
		//int count = countSubsetSumRecursive(arr, sum, n);
		int count = countSubsetSumTabulation(arr, sum, n);
		System.out.println(count);
	}
	
	private static int countSubsetSumRecursive(int[] arr, int sum, int n) {
		if(sum == 0) {
			return 1;
		}else if(n == 0 && sum != 0) {
			return 0;
		}
		if(arr[n-1] <= sum) {
			return countSubsetSumRecursive(arr, sum-arr[n-1], n-1) + countSubsetSumRecursive(arr, sum, n-1);
		}else {
			return countSubsetSumRecursive(arr, sum, n-1);
		}
	}
	
	private static int countSubsetSumTabulation(int[] arr, int sum, int n) {
		int[][] t = new int[n+1][sum+1];
		for(int i=0; i<sum+1; i++) {
			t[0][i] = 0;
		}
		for(int i=0; i<n+1; i++) {
			t[i][0] = 1;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}
}
