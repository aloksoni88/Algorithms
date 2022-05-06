/**
 * 
 */
package com.alok.algoexpert.io.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class ValidationSubsequence {
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
		ArrayList<Integer> sequence = new ArrayList<Integer>(Arrays.asList(1, 6, -1, -1, 10));
		boolean isSubsequence = isValid(array, sequence);
		System.out.println(isSubsequence);
	}

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		// Write your code here.
		int previous_index = 0;
		int count = 0;
		for (int i = 0; i < sequence.size(); i++) {
			for (int j = previous_index; j < array.size(); j++) {
				if (sequence.get(i) == array.get(j)) {
					previous_index = j + 1;
					count++;
					break;
				}
			}
		}

		if (sequence.size() == count) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean isValid(List<Integer> array, List<Integer> sequence) {
		if(array == null || sequence == null) {
			return false;
		}
		if(sequence.size() > array.size()) {
			return false;
		}
		int j=0;
		for(int i=0; i<array.size(); i++) {
			if(array.get(i) == sequence.get(j)) {
				j++;
			}
			if(j == sequence.size()) {
				return true;
			}
		}
		return false;
	}
}
