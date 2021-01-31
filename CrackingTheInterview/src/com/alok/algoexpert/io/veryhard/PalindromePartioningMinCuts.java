/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

/**
 * @author Alok Soni
 *
 */
public class PalindromePartioningMinCuts {
	public static void main(String[] args) {
		String str = "noonabbad";
		int result = palindromePartitioningMinCuts(str);		
		System.out.println(result);
	}

	public static int palindromePartitioningMinCuts(String str) {
		if(str == null || str.isEmpty()) {
			return -1;
		}
	
		
		return palindromePartitioningMinCutsRecursive(str, 0, str.length()-1);		
	}
	
	private static int palindromePartitioningMinCutsRecursive(String str, int i, int j) {
		if(i >= j) {
			return 0;
		}
		else if(isPalindrome(str, i, j)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int temp =  1 + palindromePartitioningMinCutsRecursive(str, i, k)
						+ palindromePartitioningMinCutsRecursive(str, k+1, j);
			if(temp < min) {
				min = temp;
			}
		}	
		return min;
	}
	
	private static boolean isPalindrome(String str, int i, int j) {
		if(i>=j) {
			return true;
		}
		while(i <= j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
