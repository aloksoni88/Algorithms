package com.alok.algoexpert.io.medium;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Alok Soni
 *
 */
public class PowerSet {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(powerset(list));

	}

	public static List<List<Integer>> powerset(List<Integer> array) {
		
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		if (array == null || array.isEmpty()) {
			return result;
		}

		for (int i = 0; i < array.size(); i++) {
			int setSize = result.size();
			for (int k = 0; k < setSize; k++) {
				ArrayList<Integer> currentSet = new ArrayList<>(result.get(k));
				currentSet.add(array.get(i));
				result.add(new ArrayList<>(currentSet));
			}
		}
		return result;
	}

}
