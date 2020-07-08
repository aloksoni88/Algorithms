package com.alok.dp.knapsack.zeroone;

/**
 * 
 * @author Alok Soni
 *
 */
//we also call this method as tabulation method
public class KnapsackProblemBottomUp {
	public static void main(String[] args) {
		int[] value = {60, 100, 120};
		int[] weight = {10, 20, 30};
		int W = 50;
		int n = value.length;
		int result = knapsack(value,weight,W,n);
		System.out.println(result);
	}
	
//	private static int knapsackRecurrsive(int[] value, int[] weight, int W, int n) {
//		if(n == 0 || W == 0) {
//			return 0;
//		}
//		else if(weight[n-1] <= W) {
//			return Integer.max(value[n-1] + knapsackRecurrsive(value, weight, W-weight[n-1], n-1),
//						knapsackRecurrsive(value, weight, W, n-1));
//		}else if(weight[n-1] > W) {
//			return knapsackRecurrsive(value, weight, W, n-1);
//		}
//		return 0;
//	}
	
	/**
	 * We are creating bottom up approach from recurssive method 
	 * 
	 */
	private static int knapsack(int[] value, int[] weight, int W, int n) {
		int t[][] = new int[n+1][W+1];
		
		//Table initialization
//		for(int i=0; i<n+1; i++) {
//			t[i][0] = 0;
//		}
//		for(int i=0; i<n+1; i++) {
//			t[0][i] = 0;
//		}
//		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				//Table initialization//////////
				if(i==0 || j==0) {
					t[i][j] = 0;
				}
				//////////////////
				else if(weight[i-1] <= j) {
					t[i][j] = Integer.max(value[i-1] + t[i-1][j-weight[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][W];
		
	}
}
