package com.alok.algoexpert.io.medium;

public class MaxSubsetSumNoAdjacent {
	public static void main(String[] args) {
		int[] arr= {75, 105, 120, 75,90,135};
		//output = 330, 75+120+135
		
//		int result = maxSubsetSumNoAdjacent(arr);
//		int result = maxSubsetSumRecursive(arr, arr.length-1);
		int[] t = new int[arr.length];
//		int result = maxSubsetSumMemoization(arr, arr.length-1,t);
		int result = maxSubsetSumTabulation(arr);
//		int result = maxSubsetSumTabulationOptimize(arr);
		System.out.println(result);
	}
	
	//Time - O(N), Space - O(N)
	public static int maxSubsetSumTabulationOptimize(int[] arr) {
		int n = arr.length;
		
		
		int prev1 = arr[0];
		int prev2 = 0;
	
		for (int i=1; i<n; i++) {
			int included = prev2 + arr[i];
			int excluded = prev1;
			int ans = Math.max(included, excluded);
			prev2 = prev1;
			prev1 = ans;
		}
		return prev1;
	}
	
	//Time - O(N), Space - O(N)
	public static int maxSubsetSumTabulation(int[] arr) {
		int n = arr.length;
		int[] t = new int[n];
		
		
		t[0] = arr[0];
		for (int i=2; i<n; i++) {
			int included = t[i-2] + arr[i];
			int excluded = t[i-1];
			t[i] = Math.max(included, excluded);
		}
		return t[n-1];
	}
	
	
	public static int maxSubsetSumMemoization(int[] arr, int n, int[]t) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return arr[n];
		}
		
		if (t[n] != 0) {
			return t[n];
		}
		int include = maxSubsetSumRecursive(arr, n-2) + arr[n];
		int exclude = maxSubsetSumRecursive(arr, n-1);
		
		t[n] = Math.max(include, exclude);
		return t[n];
	}
	
	public static int maxSubsetSumRecursive(int[] arr, int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return arr[n];
		}
		int include = maxSubsetSumRecursive(arr, n-2) + arr[n];
		int exclude = maxSubsetSumRecursive(arr, n-1);
		
		return Math.max(include, exclude);
	}
	
	
	public static int maxSubsetSumNoAdjacent(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		} else {
			int first = array[0];
			int second = (first > array[1]) ? first : array[1];
			for (int i = 2; i < array.length; i++) {
				int current = first + array[i];
				if (current > second) {
					first = second;
					second = current;
				} else {
					first = second;
				}
			}
			return second;
		}
		//first = 105
		//second = 105
		//i=2, current = 225, first = 105, second = 225
		//i=3, current = 180, first = 225, second = 225
		//i=4, current = 315, first = 225, second = 315
		//i=5, current = 360, first = 315, second = 360
	}
}
