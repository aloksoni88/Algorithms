/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;

/**
 * @author Alok Soni
 *
 */
public class SunsetViews {
	public static void main(String[] args) {
		int[] buildings = { 3, 5, 4, 4, 3, 1, 3, 2 };
		String direction = "EAST";
		ArrayList<Integer> result = sunsetViews(buildings, direction);
		System.out.println(result);
	}

	// Time - O(n), Space - O(n) where n is the length of buildings
	public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
		if (buildings == null || buildings.length == 0) {
			return new ArrayList<>();
		}
		ArrayList<Integer> result = new ArrayList<>();
		int length = buildings.length - 1;
		if (direction.equals("EAST")) {
			int max = buildings[length];
			result.add(length);
			for (int i = length - 1; i >= 0; i--) {
				if (buildings[i] > max) {
					max = buildings[i];
					result.add(0, i);
				}
			}
		} else {
			int max = buildings[0];
			result.add(0);
			for (int i = 1; i <= length; i++) {
				if (buildings[i] > max) {
					max = buildings[i];
					result.add(i);
				}
			}
		}
		return result;
	}
}
