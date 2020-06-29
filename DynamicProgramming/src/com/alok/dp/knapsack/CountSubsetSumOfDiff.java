package com.alok.dp.knapsack;

/**
 * @author Alok Soni
 *
 */
public class CountSubsetSumOfDiff {
	public static void main(String[] args) {
		int[] arr = {2,4,1,8,4,2,8,9,4};
		int diff = 20;
		
		//s1 = subset 1
		//s2 = subset 2
		
		//as per given condition 
		//s1 - s2 = diff
		
		//as per above condition, below condition should satisfy
		//s1 + s2 = sum of array
		
		//we can get formula
		//2s1 = (diff + sum of array) i.e 
		
		//s1 = (diff + sum)/2 //final formaul
		
		int n = arr.length;
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = sum + arr[i];
		}
		
		int subsetSum = (diff + sum)/2;
		//int count = countRecursive(arr, n, subsetSum);
		int count = countTabulation(arr, n, subsetSum);
		System.out.println(count);
	}
	
	private static int countRecursive(int[] arr, int n, int subsetSum) {
		if(subsetSum == 0) {
			return 1;
		}else if(n== 0 && subsetSum != 0) {
			return 0;
		}
			
		if(arr[n-1] <= subsetSum) {
			return countRecursive(arr, n-1, subsetSum-arr[n-1]) 
					+ countRecursive(arr, n-1, subsetSum);
		}else {
			return countRecursive(arr, n-1, subsetSum);
		}
	}
	
	private static int countTabulation(int[] arr, int n, int subsetSum) {
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
