package com.alok.dp.knapsack.unbounded;
/**
 * 
 */

/**
 * @author Alok Soni
 * Question
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
	Examples :
	
	Input:   str1 = "geek",  str2 = "eke"
	Output: 5 as "geeke"
	
	Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
	Output:  9 as "AGXGTXAYB"
	https://www.geeksforgeeks.org/shortest-common-supersequence/
 */
public class ShortestCommonSuperseqCount {
	public static void main(String[] args) {
		String str1 = "abdhli";
		String str2 = "adhxli";
		
		//int result = scsRecursive(str1, str2, str1.length(), str2.length());
		int result = scsOptimized(str1, str2);
		result = (str1.length() + str2.length()) - result;
		System.out.println("Shortest common supersequence length is : " + result);
		
		
	}
	
	private static int scsRecursive(String str1,String str2, int m, int n) {
		if(m == 0 || n == 0 ) {
			return 0;
		}else if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1+scsRecursive(str1, str2, m-1, n-1);
		}else {
			return Math.max(scsRecursive(str1, str2, m, n-1),scsRecursive(str1, str2, m-1, n));
		}
	}
	
	private static int scsOptimized(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i==0  || j== 0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
				
			}
		}
		
		return t[str1.length()][str2.length()];
	}
}
