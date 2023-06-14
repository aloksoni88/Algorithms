/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String str = "abcbdbcdbbababdddb";
		//System.out.println(longestPalindromicSubstring(str));
		System.out.println(lpsOptimized(str));
	}
	
	//Time - O(n^2)
	//Space - O(1)
	public static String lpsOptimized(String str) {
		if (str == null || str.isEmpty() || str.length() == 1) {
			return str;
		}
		int[] longest = {0,1};
		for(int i=0; i<str.length(); i++) {
			int[] odd = getPalindoremIndexs(str,i-1, i+1);
			int[] even = getPalindoremIndexs(str,i-1, i);
			
			int[] max = (odd[1] - odd[0]) > (even[1] - even[0]) ? odd : even;
			if((longest[1]- longest[0]) < max[1]- max[0] ) {
				longest = max;
			}
			
		}
		return str.substring(longest[0],longest[1]);
	}
	
	private static int[] getPalindoremIndexs(String str,int left, int right) {
	
		while(left >=0  && right < str.length()) {
			if(str.charAt(left) != str.charAt(right)) {
				return new int[] {left+1,right};
			}
			left--;
			right++;
		}
		return new int[] {left+1,right};
	}

	//Time - O(n^3)
	//Space - O(n^2)
	public static String longestPalindromicSubstring(String str) {
		if (str == null || str.isEmpty() || str.length() == 1) {
			return str;
		}
		String longest = "";
		for(int i=0; i<str.length(); i++) {
			for(int j=i; j<str.length(); j++) {
				String substrig = str.substring(i, j+1);
				if(isPalindrome(substrig) && longest.length() < substrig.length()) {
					longest = substrig;
				}
			}
		}
		return longest;
	}
	
	
	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length()-1;
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	

}
