/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class LevenshteinDistance {
	public static void main(String[] args) {
		String str1 = "abed";
		String str2 = "yabd";
		int result = levenshteinDistance(str1, str2);
		System.out.println(result);
	}
	
	public static int levenshteinDistance(String str1, String str2) {
	    if(str1 == null && str2 == null){
					return 0;
			}else if(str1.equals(str2)){
					return 0;
			}
		
			int count = distanceRecursive(str1, str2, str1.length(), str2.length());
//			int count = getDistanceOptimized(str1, str2);
			return count;
	  }
		
		//Tabulation method(optimzed) from recursive approach
		private static int getDistanceOptimized(String str1, String str2) {
			int[][] t = new int[str1.length()+1][str2.length()+1];
			
			for(int i=0; i<str1.length()+1; i++) {
				for(int j=0; j<str2.length()+1; j++) {
					if(i==0) {
						t[i][j] = j;
					}else if(j==0) {
						t[i][j] = i;
					}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
						t[i][j] = t[i-1][j-1];
					}else {
						t[i][j] = 1+min(t[i][j-1], t[i-1][j],t[i-1][j-1]);
					}
				}
			}
			
			return t[str1.length()][str2.length()];
		}
		
		//Recursive function
		private static int distanceRecursive(String str1, String str2, int m, int n) {
			if(m == 0 ) {
				return n;
			}else if(n == 0) {
				return m;
			}else if(str1.charAt(m-1) == str2.charAt(n-1)) {
				return distanceRecursive(str1, str2, m-1, n-1);
			}else {
				return 1+min(distanceRecursive(str1, str2, m, n-1),
								distanceRecursive(str1, str2, m-1, n),
								distanceRecursive(str1, str2, m-1, n-1));
			}
		}
		
		private static int min(int a, int b, int c) {
			if(a <= b && a <= c) {
				return a;
			}else if(b <= a && b <= c) {
				return b;
			}else {
				return c;
			}
		}
}
