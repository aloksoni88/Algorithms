/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */
public class LargestRange {
	public static void main(String[] args) {
		int[] arr = { 0, -5, 9, 19, -1, 18, 17, 2, -4, -3, 10, 3, 12, 5, 16, 4, 11, 7, -6, -7, 6, 15, 12, 12, 2, 1, 6,
				13, 14, -2 };
//		int[] result = largestRange(arr);
		int[] result = largestRangeOptimize(arr);
		System.out.println(Arrays.toString(result));
	}

	// Time - O(N)
	// Space - O(N)
	public static int[] largestRangeOptimize(int[] array) {

		if (array == null) {
			return array;
		} else if (array.length == 1) {
			return new int[] { array[0], array[0] };
		}
		HashMap<Integer, Boolean> map = new HashMap<>();
		int[] range = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
		int maxRangeCount = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], false);
		}
		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i])) {
				continue;
			}
			int[] currentRange = getRange(i, map);
			if (range[0] == Integer.MAX_VALUE && range[1] == Integer.MAX_VALUE) {
				range = currentRange;
				maxRangeCount = range[1] - range[0] + 1;
			} else if ((currentRange[1] - currentRange[0]) + 1 > maxRangeCount) {
				range = currentRange;
				maxRangeCount = range[1] - range[0] + 1;
			}
		}
		return range;
	}

	private static int[] getRange(int item, HashMap<Integer, Boolean> map) {
		int[] range = new int[] { -1, -1 };
		int i = item;
		while (map.containsKey(i)) {
			map.put(i, true);
			i--;
		}
		range[0] = i + 1;
		i = item;
		while (map.containsKey(i)) {
			map.put(i, true);
			i++;
		}
		range[1] = i - 1;
		return range;
	}

	// Time - O(NLog(n))
	// Space - O(1)
	public static int[] largestRange(int[] array) {
		if (array == null) {
			return new int[] {};
		} else if (array.length == 1) {
			return new int[] { array[0], array[0] };
		} else if (array.length == 2) {
			return new int[] { array[0], array[1] };
		}
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int first = -1, second = -1;
		int currentCount = 0, existingCount = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if ((array[i]) == array[i + 1] || (array[i] + 1) == array[i + 1]) {
				currentCount++;
			} else if (first == -1 && second == -1) {
				first = array[0];
				second = array[i];
				existingCount = currentCount;
				currentCount = 0;
			} else if ((currentCount > 0 && currentCount > existingCount) || first == second) {
				existingCount = currentCount;
				first = array[i - currentCount];
				second = array[i];
				currentCount = 0;
			} else {
				currentCount = 0;
			}
		}
		if ((currentCount > 0 && currentCount > existingCount) || first == second) {
			existingCount = currentCount;
			first = array[array.length - 1 - currentCount];
			second = array[array.length - 1];
			currentCount = 0;
		}
		if (first == -1) {
			first = array[0];
		}
		if (second == -1) {
			second = array[array.length - 1];
		}
		return new int[] { first, second };
	}
}
