/**
 * 
 */
package com.alok.dp.matrixchainmultiplication;

/**
 * @author Alok Soni
 *
 */

/**
 * ################### Question #######################
 * 
 * Palindrome Partitioning | DP-17 
 * Given a string, a partitioning of the string
 * is a palindrome partitioning if every substring of the partition is a
 * palindrome. 
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning
 * of “ababbbabbababa”. 
 * Determine the fewest cuts needed for palindrome
 * partitioning of a given string. 
 * For example, minimum 3 cuts are needed for
 * “ababbbabbababa”. 
 * The three cuts are “a|babbbab|b|ababa”. 
 * If a string is palindrome, then minimum 0 cuts are needed. If a string of length n
 * containing all different characters, then minimum n-1 cuts are needed.
 * palindrome-partitioning
 *
 */
public class PalindromePartioning {
	private static int[][] t;
	public static void main(String[] args) {
		String str = "ababbbabbababa";
		t = new int[str.length()][str.length()];
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<str.length(); j++) {
				t[i][j] = -1;
			}
		}
		
		//int cuts = palindromePartitionRecursive(str, 0, str.length()-1);
		//int cuts = palindromePartitionMemoize(str, 0, str.length()-1);
		int cuts = palindromePartitionOptimize(str, 0, str.length()-1);
		System.out.println("Min no of cuts needed : " + cuts);
	}
	
	private static int palindromePartitionOptimize(String str, int i, int j) {
		if(i>= j) {
			return 0;
		}
		else if(isPalindrome(str,i,j)) {
			return 0;
		}
		if(t[i][j] != -1) {
			return t[i][j];
		}
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tmp = palindromePartitionRecursive(str, i, k);
			tmp = 1 + tmp + palindromePartitionRecursive(str, k+1, j);
			
			if(tmp < min) {
				min = tmp;
			}
		}
		return t[i][j] = min;
	}
	
	private static int palindromePartitionMemoize(String str, int i, int j) {
		if(i>= j) {
			return 0;
		}
		else if(isPalindrome(str,i,j)) {
			return 0;
		}
		if(t[i][j] != -1) {
			return t[i][j];
		}
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tmp = 1 + palindromePartitionRecursive(str, i, k) 
					+ palindromePartitionRecursive(str, k+1, j);
			if(tmp < min) {
				min = tmp;
			}
		}
		return t[i][j] = min;
	}
	
	private static int palindromePartitionRecursive(String str, int i, int j) {
		if(i>= j) {
			return 0;
		}
		else if(isPalindrome(str,i,j)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tmp = 1 + palindromePartitionRecursive(str, i, k) 
					+ palindromePartitionRecursive(str, k+1, j);
			if(tmp < min) {
				min = tmp;
			}
		}
		return min;
	}
	
	private static boolean isPalindrome(String str,int i,int j) {
		if(i >= j) {
			return true;
		}
		while(i < j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
	
		return true;
	}
}
