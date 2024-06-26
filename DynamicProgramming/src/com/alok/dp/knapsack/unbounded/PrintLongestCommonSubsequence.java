/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 *Question : Print Longest common subsequence
 * LCS for input Sequences "ABCDGH" and "AEDFHR" is "ADH".
   LCS for input Sequences "AGGTAB" and "GXTXAYB" is "GTAB"
 */
public class PrintLongestCommonSubsequence {
	public static void main(String[] args) {
		String inputStr1 = "AGGTAB";//"ABCDGH";
		String inputStr2 = "GXTXAYB";//"AEDFHR";
		//StringBuffer lcm = lcmRecursive(inputStr1,inputStr2,inputStr1.length(),inputStr2.length(),new StringBuffer(""));
		StringBuffer lcm = lcmOptimized(inputStr1,inputStr2);
		System.out.println("Longest common subsequence is : " + lcm);
	}
	
	private static StringBuffer lcmOptimized(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		int i = str1.length(), j = str2.length();
		String result = "";
		while(i> 0 && j>0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				result = result + str1.charAt(i-1);
				i--;
				j--;
			}else if(t[i-1][j] > t[i][j-1]) {
				i--;
			}else {
				j--;
			}
		}
		return new StringBuffer(result).reverse();
	}
	
	private static StringBuffer lcmRecursive(String str1, String str2, int m, int n, StringBuffer lcm) {
		if(m == 0 || n == 0) {
			return lcm;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			lcmRecursive(str1, str2, m-1, n-1,lcm);
			char c= str1.charAt(m-1);
			if(!lcm.toString().contains(c+"")) {
				lcm.append(c);
			}
		}else {
			lcmRecursive(str1, str2, m, n-1,lcm);
			lcmRecursive(str1, str2, m-1, n,lcm);
		}
		return lcm;
	}
	
}
