/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 * Question
 * Given two strings "X" and "Y", print the longest common substring.
	Examples :
	
	Input : X = "GeeksforGeeks", y = "GeeksQuiz"
	Output : Geeks
	The longest common substring is "Geeks" and is of length 5.
	
	Input : X = "abcdxyz", y = "xyzabcd"
	Output : abcd
	The longest common substring is "abcd" and is of length 4.
	
	Input : X = "zxabcdezy", y = "yzabcdezx"
	Output : abcdez
	The longest common substring is "abcdez" and is of length 6.
	
 */
public class PrintLongestCommonSubstring {
	public static void main(String[] args) {
		String inputStr1 = "OldSite:GeeksforGeeks.org";
		String inputStr2 = "NewSite:GeeksQuiz.com";
		//StringBuffer lcm = lcmRecursive(inputStr1,inputStr2,inputStr1.length(),inputStr2.length(),new StringBuffer(""));
		StringBuffer lcm = lcmOptimized(inputStr1,inputStr2);
		System.out.println("Longest common substring is : " + lcm);
	}
	
	private static StringBuffer lcmOptimized(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		int row =0,col =0;
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
						if(t[i][j-1]  > t[i-1][j]) {
							row = i; 
							col = j-1;
						}else {
							row = i-1; 
							col = j;
						}
					}
					t[i][j] = 0;
				}
			}
		}
		//[
			//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
			//[0, 0, 1, 0, 0, 0, 0, 0, 1, 0],
			//[0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
			//[0, 0, 0, 1, 0, 0, 0, 0, 0, 0],
			//[0, 0, 0, 0, 2, 0, 0, 0, 0, 0],
			//[0, 0, 0, 0, 0, 3, 0, 0, 0, 0],
			//[0, 0, 0, 0, 0, 0, 4, 0, 0, 0],
			//[0, 0, 0, 0, 0, 0, 0, 5, 0, 0],
			//[0, 0, 1, 0, 0, 0, 0, 0, 6, 0],
			//[0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
		//]
		
//		[
//			[0, 0, 0, 0, 0, 0, 0, 0],
//			[0, 0, 0, 0, 1, 0, 0, 0],
//			[0, 0, 0, 0, 0, 2, 0, 0], 
//			[0, 0, 0, 0, 0, 0, 3, 0], 
//			[0, 0, 0, 0, 0, 0, 0, 4], 
//			[0, 1, 0, 0, 0, 0, 0, 0], 
//			[0, 0, 2, 0, 0, 0, 0, 0], 
//			[0, 0, 0, 3, 0, 0, 0, 0]
//		]
		String result = "";
		while(t[row][col] != 0) {
			result =  str1.charAt(row-1) + result;
			row--;
			col--;
		}
		return new StringBuffer(result);
	}
	
	private static StringBuffer lcmRecursive(String str1, String str2, int m, int n, StringBuffer lcm) {
		if(m == 0 || n == 0) {
			return lcm;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			lcmRecursive(str1, str2, m-1, n-1,lcm);
			return !lcm.toString().contains(str1.charAt(m-1)+"") ? lcm.append(str1.charAt(m-1)) : lcm;
		}else {
			StringBuffer buf = lcmRecursive(str1, str2, m, n-1,new StringBuffer()).append(lcmRecursive(str1, str2, m-1, n,new StringBuffer()));
			if(buf.length() > lcm.length()) {
				lcm = buf;
			}
			return lcm;
		}
	}
	
}
