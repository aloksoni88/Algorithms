/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alok Soni
 *
 */
public class NumbersInPi {

	public static void main(String[] args) {
		String pi = "3141592653589793238462643383279";
		String[] numbers = { "314159265358979323846264338327", "9" };
		int spaceCount = numbersInPi(pi, numbers);
		System.out.println("Space Count is : " + spaceCount);

	}

	public static int numbersInPi(String pi, String[] numbers) {
		if (pi == null || pi.length() == 0 || numbers == null || numbers.length == 0) {
			return -1;
		}

		Set<String> set = new HashSet<>();
		for (String num : numbers) {
			set.add(num);
		}
		HashMap<String, Integer> map = new HashMap<>();
		int spaceCount = getSpaceCount(pi, set, 0, map);
		return spaceCount == Integer.MAX_VALUE ? -1 : spaceCount;
	}

	private static int getSpaceCount(String pi, Set<String> set, int index, HashMap<String, Integer> map) {
		if (pi.length() == index) {
			return -1;
		}
		if (map.containsKey(String.valueOf(index))) {
			return map.get(String.valueOf(index));
		}
		int min = Integer.MAX_VALUE;
		for (int i = index; i < pi.length(); i++) {
			String substring = pi.substring(index, i + 1);
			if (set.contains(substring)) {
				int space = getSpaceCount(pi, set, i + 1, map);

				if (space == Integer.MAX_VALUE) {
					min = Math.min(min, space);
				} else {
					min = Math.min(min, space + 1);
				}
			}
		}
		map.put(String.valueOf(index), min);
		return min;
	}
}
