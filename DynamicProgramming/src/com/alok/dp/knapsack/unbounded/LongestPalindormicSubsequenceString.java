/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 *
 */

/**
 * *******************Question********************* 
 * Given a sequence, find the length of the longest palindromic
 * subsequence in it. longest-palindromic-subsequence As another example, if the
 * given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is
 * the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also
 * palindromic subsequences of the given sequence, but not the longest ones.
 *
 */
public class LongestPalindormicSubsequenceString {
	public static void main(String[] args) {
		String str = "BBABCBCAB";
		String reverseStr = new StringBuffer(str).reverse().toString();
		String result = longestPalindromicSubsequenceRecursive(str, reverseStr, str.length(), reverseStr.length());
//		String result = lPSOptimized(str, reverseStr);
		System.out.println("Longest palindromic subsequence is = "+ result);
	}
	
	private static int lPSOptimized(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		return t[str1.length()][str2.length()];
	}
	
	private static String longestPalindromicSubsequenceRecursive(String str1, String str2, int m, int n) {
		if(m == 0 || n ==0) {
			return "";
		}else if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return str1.charAt(m-1)+ longestPalindromicSubsequenceRecursive(str1, str2, m-1, n-1);
		}else {
			String pal1 = longestPalindromicSubsequenceRecursive(str1, str2, m, n-1);
			String pal2 = longestPalindromicSubsequenceRecursive(str1, str2, m-1, n);
			return pal1.length() > pal2.length() ? pal1 : pal2;
		}
	}
}
