package com.alok.dp.knapsack.zeroone;

/**
 * @author Alok Soni
 *
 */
public class SubsetSumProblem {
	public static void main(String[] args) {
		int[] arr = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
//		int[] arr = {3, 34, 4, 12, 5, 2};
//		int sum = 30;
		int n = arr.length;
		// boolean result = subsetSumRecursive(arr, sum, n);
		boolean result = subsetSumTabulation(arr, sum, n);
		System.out.println(result);
	}

	private static boolean subsetSumRecursive(int[] arr, int sum, int n) {
		if (sum == 0) {
			return true;
		}
		if (n == 0 && sum != 0) {
			return false;
		}
		if (arr[n - 1] <= sum) {
			return subsetSumRecursive(arr, sum - arr[n - 1], n - 1) || subsetSumRecursive(arr, sum, n - 1);
		} else {
			return subsetSumRecursive(arr, sum, n - 1);
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
