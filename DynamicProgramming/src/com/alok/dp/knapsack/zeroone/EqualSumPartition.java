package com.alok.dp.knapsack.zeroone;

/**
 * @author Alok Soni
 *
 */
public class EqualSumPartition {
	public static void main(String[] args) {
		int[] arr = {1,4,6,2,8,1};
		int n = arr.length;
		boolean result = equalSumPartitionRecursive(arr, n);
		System.out.println(result);
	}
	
	private static boolean equalSumPartitionRecursive(int[] arr, int n) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = sum + arr[i];
		}
		if(sum %2 != 0) {
			return false;
		}
		//return subsetSumProblemRecursive(arr, sum/2, n);
		return subsetSumTabulation(arr, sum/2, n);
	}
	
	private static boolean subsetSumProblemRecursive(int[] arr, int sum, int n) {
		if(sum == 0) {
			return true;
		}else if(n == 0 && sum != 0) {
			return false;
		}
		if(arr[n-1] <= sum) {
			return subsetSumProblemRecursive(arr, sum-arr[n-1], n-1) || subsetSumProblemRecursive(arr, sum, n-1);
		}else {
			return subsetSumProblemRecursive(arr, sum, n-1);
		}
	}
	
	private static boolean subsetSumTabulation(int[] arr, int sum, int n) {
		boolean[][] t = new boolean[n + 1][sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			t[0][i] = false;
		}
		for (int i = 0; i < n + 1; i++) {
			t[i][0] = true;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
//				if (i == j) {
//					if (i == 0 && j == 0) {
//						t[i][j] = true;
//					} else {
//						t[i][j] = false;
//					}
//				} 
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][sum];
	}
}
