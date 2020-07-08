package com.alok.dp.knapsack.zeroone;

/**
 * 
 * @author Alok Soni
 *
 */
public class KnapsackRecurrsiveMemoization {
	private static int[][] t;
	public static void main(String[] args) {
		int[] value = {60, 100, 120};
		int[] weight = {10, 20, 30};
		int W = 50;
		int n = value.length;
		t = new int[n+1][W+1];
		//initialize array
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				t[i][j] = -1;
			}
		}
		
		int result = knapsackRecurrsiveMemoization(value, weight, W, 3);
		System.out.println(result);
	}
	
	private static int knapsackRecurrsiveMemoization(int[] value, int[] weight, int W, int n) {
		if(n == 0 || W == 0) {
			return 0;
		}
		if(t[n][W] != -1) {
			return t[n][W];
		}
		else if(weight[n-1] <= W) {
			return t[n][W] = Integer.max(value[n-1] + knapsackRecurrsiveMemoization(value, weight, W-weight[n-1], n-1),
					knapsackRecurrsiveMemoization(value, weight, W, n-1));
		}else if(weight[n-1] > W) {
			return t[n][W] = knapsackRecurrsiveMemoization(value, weight, W, n-1);
		}
		return 0;
	}
}
