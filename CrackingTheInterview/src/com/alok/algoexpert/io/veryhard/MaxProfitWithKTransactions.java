/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

/**
 * @author Alok Soni
 *
 */
public class MaxProfitWithKTransactions {
	public static void main(String[] args) {
		int[] prices = {5, 11, 3, 50, 60, 90};
		int result = maxProfitWithKTransactions(prices, 3);
		System.out.println(result);
	}

	// Time - O(nk) , Space - O(nk)
	// where n is the number of element in array and k is the item value
	public static int maxProfitWithKTransactions(int[] prices, int k) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[][] profits = new int[k + 1][prices.length];
		for (int t = 1; t < k + 1; t++) {
			int maxThusSoFar = Integer.MIN_VALUE;
			for (int d = 1; d < prices.length; d++) {
				maxThusSoFar = Math.max(maxThusSoFar, profits[t - 1][d - 1] - prices[d - 1]);
				profits[t][d] = Math.max(profits[t][d - 1], maxThusSoFar + prices[d]);
			}
		}
		return profits[k][prices.length - 1];
	}
}
