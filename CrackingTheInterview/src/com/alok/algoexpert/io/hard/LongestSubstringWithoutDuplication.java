/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */
public class LongestSubstringWithoutDuplication {
	public static void main(String[] args) {
		String str = "clementisacap";
		String substring = longestSubstringWithoutDuplication(str);
		System.out.println(substring);
	}

	//Time - O(n)
	/**Space - O(min(n,a)) where n is the length of string & a is the length 
	of unique characters in the string**/
	public static String longestSubstringWithoutDuplication(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<>();
		String currentSubstr = "", resultSubstr = "";
		int startIndex = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(map.containsKey(ch)) {
				if(currentSubstr.length() > resultSubstr.length()) {
					resultSubstr = currentSubstr;
				}
				int lastSeenCharIdx = map.get(ch);
				startIndex = Integer.max(startIndex, lastSeenCharIdx+1);
				map.put(ch, i);
				currentSubstr = str.substring(startIndex,i+1);
			}else {
				map.put(ch, i);
				currentSubstr = currentSubstr + ch;
			}
		}
		return currentSubstr.length() > resultSubstr.length() ? currentSubstr : resultSubstr;
	}

}
