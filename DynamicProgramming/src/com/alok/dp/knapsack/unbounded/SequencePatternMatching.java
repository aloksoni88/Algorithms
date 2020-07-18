/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 * Question
 * input 
 * String1 = "AXY"
 * String2 = "ADXCPY"
 * output = true
 * 
 * String1 = "AXY"
 * String2 = "ADYCPX"
 * output = false
 */
public class SequencePatternMatching {
	public static void main(String[] args) {
		String str1 = "axy";
		String str2 = "adxcpy";
		
		//int count = spmRecursive(str1, str2, str1.length(), str2.length());
		int count = spmOptimized(str1, str2);
		if(str1.length() >= str2.length() && str2.length() == count) {
			System.out.println(true);
		}else if(str2.length() > str1.length() && str1.length() == count) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
	private static int spmOptimized(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] t = new int[m+1][n+1];
		
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
	
	
	private static int spmRecursive(String str1, String str2, int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1+spmRecursive(str1, str2, m-1, n-1);
		}else {
			return Math.max(spmRecursive(str1, str2, m, n-1), spmRecursive(str1, str2, m-1, n));
		}
	}
}
