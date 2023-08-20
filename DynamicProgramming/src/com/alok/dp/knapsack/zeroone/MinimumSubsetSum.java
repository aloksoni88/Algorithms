package com.alok.dp.knapsack.zeroone;

/**
 * @author Alok Soni
 *
 */
public class MinimumSubsetSum {
	public static void main(String[] args) {
		int arr[] = {6, 1, 11, 5};
		int n = arr.length;
		int sum = 0; 
		for(int i=0; i<n; i++) {
			sum = sum  + arr[i];
		}
//		int result = minimumSubsetSumRecursive(arr, n, sum,Integer.MAX_VALUE);
		int result = minimumSubsetSumTabulation(arr, n, sum,Integer.MAX_VALUE);
		System.out.println(result);
	}
	
	private static int minimumSubsetSumRecursive(int[] arr, int n, int sum,int minValue) {
		if(n ==0) {
			return minValue;
		}
		int min = Math.abs(sum - 2* arr[n-1]);
		if(min < minValue) {
			min = minimumSubsetSumRecursive(arr, n-1, sum, min);
		}else {
			minValue = minimumSubsetSumRecursive(arr, n-1, sum, minValue);
		}
		return min < minValue ? min : minValue;
	}
	
	private static int minimumSubsetSumTabulation(int[] arr, int n, int sum, int min) {
		for(int i=0; i<n; i++) {
			min = Math.min(min, Math.abs(sum-2*arr[i]));
		}
		return min;
	}
}
