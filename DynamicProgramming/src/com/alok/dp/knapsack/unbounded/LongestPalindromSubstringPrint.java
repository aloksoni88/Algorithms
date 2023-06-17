/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 *
 */
public class LongestPalindromSubstringPrint {
	public static void main(String[] args) {
		String str = "babaca";
		String str2 = new StringBuffer(str).reverse().toString();
		String result = longestPalindromSubstring(str, str2, str.length(), str2.length(), "");
//		String result = longestPanlindromSubstringOptimize(str, str2);
		System.out.println("Longest Palindrom substring : " + result);
	}
	
	public static String longestPalindromSubstring(String str1, String str2, int m, int n, String result) {
		if (m == 0 || n == 0) {
			return result;
		}
		if (str1.charAt(m-1) == str2.charAt(n-1)) {
			return longestPalindromSubstring(str1, str2, m-1, n-1, (str1.charAt(m-1) + result));
		}else {
			String pal1 = longestPalindromSubstring(str1, str2, m-1, n, "");
			String pal2 = longestPalindromSubstring(str1, str2, m, n-1, "");
			String str = pal1.length() > pal2.length() ? pal1 : pal2;
			return str.length() > result.length() ? str : result;
		}
	}
}
