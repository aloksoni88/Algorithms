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
	Output: "geeke"
	
	Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
	Output:  "AGXGTXAYB"
	https://www.geeksforgeeks.org/shortest-common-supersequence/
 */
public class PrintShortestCommonSupersequence {
	public static void main(String[] args) {
		String str1 = "geek";
		String str2 = "eke";
		
		String result = getSCSString(str1, str2);
		System.out.println("Shortest common supersequence is : " + result);
	}
	
	private static String getSCSString(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		
		int i=str1.length(),j = str2.length();
		StringBuffer result = new StringBuffer();
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				result.append(str1.charAt(i-1));
				i--;
				j--;
			}else if(t[i-1][j] > t[i][j-1]) {
				result.append(str1.charAt(i-1));
				i--;
			}else {
				result.append(str2.charAt(j-1));
				j--;
			}
		}
		
		while(i > 0) {
			result.append(str1.charAt(i-1));
			i--;
		}
		
		while(j > 0) {
			result.append(str2.charAt(j-1));
			j--;
		}
		return result.reverse().toString();
	}
}
