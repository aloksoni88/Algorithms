/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 */

/***
 * ################## Question ###############
 * Longest Repeating Subsequence
 * Given a string, find length of the longest
 * repeating subseequence such that the two subsequence don’t have same string
 * character at same position, 
 * i.e., any i’th character in the two subsequences
 * shouldn’t have the same index in the original string.
 * longest-repeating-subsequence
 * 
 * Examples:
 * 
 * Input: str = "abc" Output: 0 There is no repeating subsequence
 * 
 * Input: str = "aab" Output: 1 The two subssequence are 'a'(first) and
 * 'a'(second). Note that 'b' cannot be considered as part of subsequence as it
 * would be at same index in both.
 * 
 * Input: str = "aabb" Output: 2
 * 
 * Input: str = "axxxy" Output: 2
 *
 */
public class CountLongestRepeatingSubsequence {
	private static int[][] t;

	public static void main(String[] args) {
		String str = "baabebcdd";
		String str2 = str;
		//initMemoirzationArr(str,str2);
		//int len = lrsMemoization(str, str2,str.length(),str.length());
		//int len = lrsRecursive(str,str2,str.length(),str.length());
		int len = lrsOptimized(str, str2);
		System.out.println("Length of LCS is " + len);
	}

	private static int lrsOptimized(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		t = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1) && i != j) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}
		return t[m][n];
	}

	private static void initMemoirzationArr(String str1, String str2) {
		int length = str1.length() > str2.length() ? str1.length() : str2.length();
		t = new int[length + 1][length + 1];
		for (int i = 0; i < length + 1; i++) {
			for (int j = 0; j < length + 1; j++) {
				t[i][j] = -1;
			}
		}
	}

	private static int lrsMemoization(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (t[m][n] != -1) {
			return t[m][n];
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1) && m != n) {
			return t[m][n] = 1 + lrsMemoization(str1, str2, m - 1, n - 1);
		} else {
			return t[m][n] = Math.max(lrsMemoization(str1, str2, m, n - 1), lrsMemoization(str1, str2, m - 1, n));
		}
	}

	private static int lrsRecursive(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1) && m != n) {
			return 1 + lrsRecursive(str1, str2, m - 1, n - 1);
		} else {
			return Math.max(lrsRecursive(str1, str2, m, n - 1), lrsRecursive(str1, str2, m - 1, n));
		}
	}
}
