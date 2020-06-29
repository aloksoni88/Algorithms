package com.alok.algoexpert.io;

public class MaxSubsetSumNoAdjacent {
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
	}
}
