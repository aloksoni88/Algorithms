/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String str1 = "clement";
		String str2 = "antoine";
		List<Character> result = longestCommonSubsequence(str1, str2);
		System.out.println(result);
	}
	

	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		HashMap<String, String> map = new HashMap<>();
		//String result = getLCSRecursive(str1, str2, str1.length(), str2.length(), new StringBuffer(""),map);
		String result = getLCS(str1, str2);
		ArrayList<Character> charList = new ArrayList<>();
		for(char c: result.toCharArray()) {
			charList.add(c);
		}
		return charList;
	}
	
	//Time - O(n*m) - n is the length of str1 , m is the length of str2
	//Spcae - O(n*m)
	private static String getLCS(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i == 0 || j == 0) {
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
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				result = str1.charAt(i-1) + result;
				i--;
				j--;
			}else if(t[i-1][j] > t[i][j-1]) {
				i--;
			}else {
				j--;
			}
		}
		return result;
	}
	
	
	private static String getLCSRecursive(String str1, String str2, int m, int n,
			StringBuffer lcs,HashMap<String, String> map) {
		if(m == 0 || n == 0) {
			return "";
		}
		if(map.containsKey(m + "_"+n)) {
			return map.get(m+"_"+n);
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			getLCSRecursive(str1, str2, m-1, n-1, lcs,map);
			char c = str1.charAt(m-1);
			if(!lcs.toString().contains(""+c)) {
				lcs.append(c);
			}
			return lcs.toString();
		}else {
			getLCSRecursive(str1, str2, m, n-1, lcs,map);
			getLCSRecursive(str1, str2, m-1, n, lcs,map);
			
			map.put(m+"_"+n, lcs.toString());
			return lcs.toString();
		}
	}
}
