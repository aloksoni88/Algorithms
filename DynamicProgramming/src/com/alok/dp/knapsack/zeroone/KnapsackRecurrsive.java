package com.alok.dp.knapsack.zeroone;

/**
 * 
 * @author Alok Soni
 *
 */
public class KnapsackRecurrsive {
	public static void main(String[] args) {
		int[] value = {100, 60, 120};
		int[] weight = {10, 20, 30};
		int W = 30;
		int result = knapsackRecurrsive(value, weight, W, weight.length);
		System.out.println(result);
	}
	
	private static int knapsackRecurrsive(int[] value, int[] weight, int W, int n) {
		if(n == 0 || W == 0) {
			return 0;
		}
		else if(weight[n-1] <= W) {
			return Integer.max(value[n-1] + knapsackRecurrsive(value, weight, W-weight[n-1], n-1),
						knapsackRecurrsive(value, weight, W, n-1));
		}else if(weight[n-1] > W) {
			return knapsackRecurrsive(value, weight, W, n-1);
		}
		return 0;
	}
}
