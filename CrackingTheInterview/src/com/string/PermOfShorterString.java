package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * 
 * @author Alok Soni
 * Question
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
	other. 	
 *
 */
public class PermOfShorterString {
	public static void main(String[] args) {
		String pattern = "abbc";
		String txt = "cbabadcbbabbcbabaabccbabc";
		if(pattern == null || txt == null || pattern.trim().isEmpty() || txt.trim().isEmpty()){
			System.out.println("Pattern or text is empty");
			return;
		}else if(pattern.length() > txt.length()){
			System.out.println("Pattern length is greater than the given text");
			return;
		}
		foundSubstring(pattern, txt);
	
	}
	
	private static void foundSubstring(String pattern , String txt){
		boolean isFound = false;
		int[] ascii = new int[26];
		for(int i=0; i<pattern.length(); i++){
			ascii[pattern.charAt(i) - 'a']++; 
		}
		for(int i=0; i<=(txt.length()-pattern.length()); i++){
			String substr = txt.substring(i, i+pattern.length());
			/*if(isMatchedUsingMap(substr, pattern)){
				isFound = true;
				System.out.println("Found at index : " + i);
			}*/
			if(isMatchedUsingArray(substr, ascii)){
				isFound = true;
				System.out.println("Found at index : " + i);
			}
			
		}
		if(!isFound){
			System.out.println("No substring found");
		}
	}
	
	
	private static boolean isMatchedUsingArray(String substr, int[] patternAscii){
		int[] substrAscii = new int[26];
		for(int i=0; i<substr.length(); i++){
			substrAscii[substr.charAt(i) - 'a']++; 
		}
		for(int i=0; i<26; i++){
			if(substrAscii[i] != patternAscii[i]){
				return false;
			}
		}
		return true;
	}
	
	
	private static boolean isMatchedUsingMap(String substr, String pattern){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<pattern.length(); i++){
			char c1 = substr.charAt(i);
			char c2 = pattern.charAt(i);
			if(map.containsKey(c1)){
				map.put(c1, map.get(c1)+1);
			}else{
				map.put(c1, 1);
			}
			if(map.containsKey(c2)){
				map.put(c2, map.get(c2)+1);
			}else{
				map.put(c2, 1);
			}
		}
		for(int i:map.values()){
			if(i%2 != 0){
				return false;
			}
		}
		return true;
	}
}
