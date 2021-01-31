/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 *
 */

/**
 * 
 ********************** Question ************************
 * Given a string of size ‘n’. The task is to
 * remove or delete minimum number of characters from the string so that the
 * resultant string is palindrome.
 * 
 * Note: The order of characters should be maintained.
 * 
 * Examples :
 * 
 * Input : aebcbda Output : 2 Remove characters 'e' and 'd' Resultant string
 * will be 'abcba' which is a palindromic string
 * 
 * Input : geeksforgeeks Output : 8
 *
 */
public class MinNoStringDelToMakePanlindrome {
	public static void main(String[] args) {
		String str = "aebcbda";
		String reverseStr = new StringBuffer(str).reverse().toString();
		int result = getCountRecursive(str, reverseStr, str.length(), reverseStr.length());
		//int result = getCountOptimized(str, reverseStr);
		result = str.length() - result;
		System.out.println("Min No of String To be deleted to make string palindrome is : " + result);
	}
	
	private static int getCountOptimized(String str1, String str2) {
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
	
	private static int getCountRecursive(String str1, String str2, int m, int n) {
		if(m == 0 || n ==0) {
			return 0;
		}else if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1+ getCountRecursive(str1, str2, m-1, n-1);
		}else {
			return Integer.max(getCountRecursive(str1, str2, m, n-1), 
					getCountRecursive(str1, str2, m-1, n));
		}
	}
}
