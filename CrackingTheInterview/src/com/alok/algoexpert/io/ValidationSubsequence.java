/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class ValidationSubsequence {
	
	public static void main(String[] args) {
		
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
}
