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
		
		String result = scsRecursive(str1, str2, str1.length(), str2.length(), "");
		System.out.println("Shortest common supersequence is : " + result);
	}
	
	private static String scsRecursive(String str1, String str2, int m, int n, String result) {
		if(m == 0 || n == 0) {
			return result;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			if(!result.contains(str1.charAt(m-1)+"")) {
				result = result+str1.charAt(m-1);	
			}
			return scsRecursive(str1, str2, m-1, n-1, result);
		}else {
			result = scsRecursive(str1, str2, m, n-1, str2.charAt(n-1)+"");
			String result2 = scsRecursive(str1, str2, m-1, n, str1.charAt(m-1)+"");
			if(!result.contains(result2)) {
				result = result+result2;
			}
			return result;  
		}
	}
}