/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 * Question
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
	Examples :
	
	Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
	Output : 5
	The longest common substring is “Geeks” and is of length 5.
	
	Input : X = “abcdxyz”, y = “xyzabcd”
	Output : 4
	The longest common substring is “abcd” and is of length 4.
	
	Input : X = “zxabcdezy”, y = “yzabcdezx”
	Output : 6
	The longest common substring is “abcdez” and is of length 6.
	
	https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 */
public class LongestCommonSubstringCount {
	public static void main(String[] args) {
		String str1 = "abcdxyz";
		String str2 = "xyzabcd";
		
		//int len = lcmRecursive(str1, str2, str1.length(), str2.length(),0);
		int len = lcmOptimized(str1, str2);
		System.out.println("Longest common substring is : " + len);
	}
	
	private static int lcmOptimized(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					int len = Math.max(t[i][j-1], t[i-1][j]);
					if(len > max) {
						max = len;
					}
					t[i][j] = 0;
				}
			}
		}
		return max;
	}
	
	private static int lcmRecursive(String str1, String str2, int m, int n,int max) {
		if(m == 0 || n == 0) {
			return max;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return lcmRecursive(str1, str2, m-1, n-1,max+1);
		}else {
			int len = Math.max(lcmRecursive(str1, str2, m, n-1,0), lcmRecursive(str1, str2, m-1, n,0));
			if(len > max) {
				max = len;
			}
			return max;
		}
//		if(str1.charAt(m-1) == str2.charAt(n-1)) {
//			max = lcmRecursive(str1, str2, m-1, n-1,max+1);
//		}
//		int len = Math.max(lcmRecursive(str1, str2, m, n-1,0), lcmRecursive(str1, str2, m-1, n,0));
//		if(len > max) {
//			max = len;
//		}
//		return max;
	}
}
