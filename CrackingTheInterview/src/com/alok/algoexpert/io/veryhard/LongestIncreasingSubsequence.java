/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] array = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
		List<Integer>  result= longestIncreasingSubsequence(array);
		System.out.println(result);
	}

	public static List<Integer> longestIncreasingSubsequence(int[] array) {
		if (array == null || array.length == 0) {
			return new ArrayList<>();
		}
		List<Integer> max = new ArrayList<>();
		for(int i=0; i<array.length; i++) {			
			List<Integer> max2 = lisRecursive(array, i);			
			if(max2.size() > max.size()) {
				max = max2;				
			}			
		}	
		return max;
	}
	
	private static List<Integer> lisRecursive(int[] array, int n){
		if(n == 0) {			
			return new ArrayList<>();
		}	
		List<Integer> ans = new ArrayList<>();
		for(int i=n; i>=0; i--) {
			if(array[i] < array[n]) {
				List<Integer> ans2 = lisRecursive(array, i);
				ans2.add(array[i]);
				if(ans2.size() > ans.size()) {
					ans = ans2;
				}				
			}
		}		
		return ans;
	}
}
