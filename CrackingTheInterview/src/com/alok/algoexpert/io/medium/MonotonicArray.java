/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class MonotonicArray {
	public static void main(String[] args) {
		int[] array = { 1, -5, -10, -1100, -900, -1101, -1102, -9001 };

		boolean result = isMonotonic(array);
		System.out.println(result);
	}

	public static boolean isMonotonic(int[] array) {
		if (array == null || array.length <= 2) {
			return true;
		}
		boolean isDec = false;
		boolean isInc = false;
		for (int i = 0; i < array.length - 1; i++) {
			if (!isInc && !isDec) {
				if (array[i] < array[i + 1]) {
					isInc = true;
				} else if (array[i] > array[i + 1]) {
					isDec = true;
				}
			} else {
				if (isInc && array[i] > array[i + 1]) {
					return false;
				} else if (isDec && array[i] < array[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}
}
