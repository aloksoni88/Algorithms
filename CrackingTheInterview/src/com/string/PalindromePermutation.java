/**
 * 
 */
package com.string;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Alok Soni
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
	is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
	EXAMPLE
	Input: Tac t Coa
	Output: Tru e (permutations : "tac o cat" , "atc o eta" , etc. ) 
 */
public class PalindromePermutation {
	static ArrayList<String> list= new ArrayList<String>();
	public static void main(String[] args) {
		String input = "aabcb";
		isPermutationOfPalindrome(input);
		if(!list.isEmpty()) {
			System.out.println(list.size());
			System.out.println("True Permutations: " + list);
		}else {
			System.out.println("False");
		}
	}
	
	private static void isPermutationOfPalindrome(String input){
		findPermutation(input, "");
	}
	
	private static void findPermutation(String input,String prefix){
		if(input.length() == 0){
			if(isPalindrome(prefix.replace(" ", "")) && !list.contains(prefix)) {
				list.add(prefix);
			}
			return;
		}
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			String ros = input.substring(0,i) + input.substring(i+1);
			findPermutation(ros, prefix+ch);
		}
	}
	

	private static boolean isPalindrome(String str) {
		int length = str.length();
		for(int i=0; i<length/2; i++) {
			if(str.charAt(i) != str.charAt(length-1-i)) {
				return false;
			}
		}
		return true;
	}

}
