/**
 * 
 */
package com.string;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class Anagram {
	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silens";
		
		boolean result = checkAnagram2(str1, str2);
		System.out.println(result);
	}
	
	 private static boolean checkAnagram(String str1, String str2) {
		if(str1 == null || str2 == null) {
			return false;
		}else if(str1.length() != str2.length()) {
			return false;
		}
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		
		int[] count1 = new int[256];
		Arrays.fill(count1, 0);
		int[] count2 = new int[256];
		Arrays.fill(count2, 0);
		
		for(int i=0; i<char1.length; i++) {
			count1[char1[i]]++;
			count2[char2[i]]++;
		}
		System.out.println(Arrays.toString(count1));
		System.out.println(Arrays.toString(count2));
		
		for(int i=0; i<256; i++) {
			if(count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}
	 
	private static boolean checkAnagram2(String str1, String str2) {
		if(str1 == null || str2 == null) {
			return false;
		}else if(str1.length() != str2.length()) {
			return false;
		}
		
		int count = 0;
		for(int i=0; i<str1.length(); i++) {
			count = count + str1.charAt(i);
		}
		
		for(int i=0; i<str2.length(); i++) {
			count = count - str2.charAt(i);
		}
		if(count == 0) {
			return true;
		}
		return false;
	}
}
