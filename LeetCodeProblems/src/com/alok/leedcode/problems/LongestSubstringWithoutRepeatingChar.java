package com.alok.leedcode.problems;

public class LongestSubstringWithoutRepeatingChar {
	private static int[][] t;
	public static void main(String[] args) {
		String str = "lskflksanf";
		t = new int[str.length()+1][str.length()+1];
		for(int i=0; i<str.length()+1; i++) {
			for(int j=0; j<str.length()+1; j++) {
				t[i][j] = -1;
			}
		}
//		System.out.println(longestSubstringOptimize(str, str));
//		int result = longestSubstrign(str, str, 
//				str.length(), str.length(), new StringBuffer(""));
//		System.out.println("output : "+result);
		System.out.println(longestSubStr(str));
	}
	
	private static String res = "";
	private static int longestSubstrign(String str1, String str2, int m, int n, StringBuffer result) {
		if(m == 0 || n == 0) {
			return res.length();
		}
		if(t[m][n] != -1) {
			return t[m][n];
		}
		if(str1.charAt(m-1) == str2.charAt(n-1) && !result.toString().contains(""+str1.charAt(m-1))) {
			longestSubstrign(str1, str2, m-1, n-1, result.append(str1.charAt(m-1)));
		}else {
			if(res.length() < result.length()) {
				res = result.toString();
			}
			longestSubstrign(str1, str2, m-1, n, new StringBuffer(""));
			longestSubstrign(str1, str2, m, n-1, new StringBuffer(""));
		}
		return t[m][n] =res.length();
	}
	
	private static int longestSubstringOptimize(String s, String str) {
		int[][]t =new int[s.length()+1][s.length()+1];
		String result = "";
		String res = "";
		int max=0,row=0,col=0;
		for(int i=0; i<str.length()+1; i++) {
			for(int j=0; j<str.length()+1; j++) {
				t[i][j] = -1;
			}
		}
		
		for(int i=0; i<s.length()+1; i++) {
			for(int j=0; j<s.length()+1; j++) {
				if(i ==0 || j == 0) {
					t[i][j] = 0;
				}else if(s.charAt(i-1) == str.charAt(j-1) && !result.contains(""+s.charAt(i-1))) {
					result = result + s.charAt(i-1);
					t[i][j] = 1+ t[i-1][j-1];
				}else {
					if(res.length() < result.length()) {
						res = result;
					}
					result ="";
					int len = Math.max(t[i][j-1], t[i-1][j]);
					if(len > max) {
						max = len;
					}
					t[i][j] = 0;
				}
			}
		}
		return t[s.length()][s.length()];
	}
	
	private static int longestSubStr(String str) {
		//geeksforgeeks
		if(str == null || str.isEmpty()) {
			return -1;
		}
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			boolean[] visited = new boolean[256];
			
			for(int j=i; j< str.length(); j++) {
				if(visited[str.charAt(j)]) {
					break;
				}else {
					count = Integer.max(count, j-i+1);	
					visited[str.charAt(j)] = true;
				}
			}
		}
		return count;
	}
}
