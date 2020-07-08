/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 * Question : Longest common subsequence
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
   LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequenceCount {
	private static int[][] t;
	public static void main(String[] args) {
		String inputStr1 = "heap";
		String inputStr2 = "pea";
		//initMemoirzationArr(inputStr1,inputStr2);
		//int len = lcmMemoization(inputStr1, inputStr2, inputStr1.length(), inputStr2.length());
		//int len = lcmRecursive(inputStr1,inputStr2,inputStr1.length(),inputStr2.length());
		int len = lcmOptimized(inputStr1, inputStr2);
		System.out.println("Length of LCS is " + len);
	}
	
	private static int lcmOptimized(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		t = new int[m+1][n+1];
		
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
	
	private static void initMemoirzationArr(String str1, String str2) {
		int length = str1.length() > str2.length() ? str1.length() : str2.length();
		t = new int[length+1][length+1];
		for(int i = 0; i< length+1; i++) {
			for(int j=0; j<length+1; j++) {
				t[i][j] = -1;
			}
		}
	}
	
	private static int lcmMemoization(String str1, String str2, int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(t[m][n] != -1) {
			return t[m][n];
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return t[m][n] = 1+lcmRecursive(str1, str2, m-1, n-1);
		}else {
			return t[m][n] = Math.max(lcmRecursive(str1, str2, m, n-1), lcmRecursive(str1, str2, m-1, n));
		}
	}
	
	private static int lcmRecursive(String str1, String str2, int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1+lcmRecursive(str1, str2, m-1, n-1);
		}else {
			return Math.max(lcmRecursive(str1, str2, m, n-1), lcmRecursive(str1, str2, m-1, n));
		}
	}
}

