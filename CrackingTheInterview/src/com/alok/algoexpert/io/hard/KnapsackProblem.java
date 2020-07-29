/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class KnapsackProblem {
	public static void main(String[] args) {
		int[][] items = {{1,2},{4,3},{5,6},{6,7}};
		int capacity = 10;
//		System.out.println(knapsackProblemRecursive(items, capacity));		
		System.out.println(knapsackProblem(items, capacity));
	}
	
	public static List<List<Integer>>  knapsackProblem(int[][] items, int capacity) {
		int[] itemArr = new int[items.length];
		int[] weights = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			itemArr[i] = items[i][0];
			weights[i] = items[i][1];
		}
		return kanpsacProblem(itemArr, weights,capacity, items);
	}
	
	private static List<List<Integer>> kanpsacProblem(int[] values, int[] weights, int capacity,int[][] items){
		int[][] t= new int[values.length+1][ capacity+1];
		for(int i=0; i<values.length+1; i++) {
			for(int j=0; j<capacity+1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}else if(weights[i-1] <= j) {
					t[i][j] = Math.max(values[i-1]+ t[i-1][j-weights[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		System.out.println(t[items.length][capacity]);
		return getItems(t, t[items.length][capacity],items);
	}
	
	private static List<List<Integer>> getItems(int[][] knapsackValues,int capacity,int[][] items){
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> capList = new ArrayList<>();
		capList.add(capacity);
		result.add(capList);
		result.add(new ArrayList<>());
		
		int row = knapsackValues.length-1;
		int col = knapsackValues[0].length-1;
		while(row > 0) {
			if(knapsackValues[row][col] == knapsackValues[row-1][col]) {
				row--;
			}else {
				result.get(1).add(0,row-1);
				col = col - items[row-1][1];
				row--;
			}
			if(row == 0) {
				break;
			}
		}
		return result;
	}

	public static int knapsackProblemRecursive(int[][] items, int capacity) {
		// Write your code here.
		// Replace the code below.
		// List<Integer> totalValue = Arrays.asList(10);
		// List<Integer> finalItems = Arrays.asList(1, 2);
		// var result = new ArrayList<List<Integer>>();
		// result.add(totalValue);
		// result.add(finalItems);
		// return result;

		int[] itemArr = new int[items.length];
		int[] weights = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			itemArr[i] = items[i][0];
			weights[i] = items[i][1];
		}
		int total = knapsack(itemArr, weights, itemArr.length, capacity);
		return total;
	}
	

	private static HashMap<String,Integer> map = new HashMap<>();
	private static int knapsack(int[] itemArr, int[] weights, int n, int capacity) {
		if (n == 0 || capacity == 0) {
			return 0;
		}
		if(map.containsKey(n+"_" + capacity)) {
			return map.get(n+"_" +capacity);
		}
		if (weights[n-1] <= capacity) {
			int val = Math.max(itemArr[n-1] + knapsack(itemArr, weights, n-1, capacity-weights[n-1]), 
					knapsack(itemArr, weights, n-1, capacity));
			map.put(n+"_"+capacity, val);
			return val;
		}else {
			int val = knapsack(itemArr, weights, n-1, capacity);
			map.put(n+"_"+capacity, val);
			return val;
		}
	}
	
	
}
