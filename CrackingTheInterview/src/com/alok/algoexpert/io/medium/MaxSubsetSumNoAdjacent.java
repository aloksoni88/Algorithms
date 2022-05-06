package com.alok.algoexpert.io.medium;

public class MaxSubsetSumNoAdjacent {
	public static void main(String[] args) {
		int[] arr= {105, 75, 120, 75,90,135};
		//output = 330, 75+120+135
		
		int result = maxSubsetSumNoAdjacent(arr);
		System.out.println(result);
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
