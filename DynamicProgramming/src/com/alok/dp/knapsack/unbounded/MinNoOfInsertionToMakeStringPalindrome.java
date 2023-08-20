/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 *
 */

/**
 * ################## Question #################### 
 * Minimum insertions to form apalindrome | DP-28
 * 
 * Given a string str, the task is to find the minimum number of characters to
 * be inserted to convert it to palindrome.
 * 
 * Before we go further, let us understand with few examples:
 * 
 * ab: Number of insertions required is 1 i.e. bab 
 * aa: Number of insertions required is 0 i.e. aa 
 * abcd: Number of insertions required is 3 i.e. dcbabcd
 * abcda: Number of insertions required is 2 i.e. adcbcda which is same as
 * number of insertions in the substring bcd(Why?). 
 * abcde: Number of insertions required is 4 i.e. edcbabcde
 *
 */
public class MinNoOfInsertionToMakeStringPalindrome {
	public static void main(String[] args) {
		String str = "abcda";
		String reverseStr = new StringBuffer(str).reverse().toString();
		//int minNoOfInsertion = insertionCountRecursive(str, reverseStr, str.length(), str.length());
		int minNoOfInsertion = insertionCountOptimized(str, reverseStr);
		minNoOfInsertion = str.length() - minNoOfInsertion;
		System.out.println("Min no of insertion to make string palindrome is : " + minNoOfInsertion);
	}
	
	private static int insertionCountOptimized(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][]t = new int[m+1][n+1];
		
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i == 0 || j==0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
				}
			}
		}
		return t[m][n];
	}

	private static int insertionCountRecursive(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		} else if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return 1 + insertionCountRecursive(str1, str2, m - 1, n - 1);
		} else {
			return Math.max(insertionCountRecursive(str1, str2, m, n - 1),
					insertionCountRecursive(str1, str2, m - 1, n));
		}
	}
}
