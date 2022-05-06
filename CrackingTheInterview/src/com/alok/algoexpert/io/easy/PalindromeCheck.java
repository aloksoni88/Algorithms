/**
 * 
 */
package com.alok.algoexpert.io.easy;

/**
 * @author Alok Soni
 *
 */
public class PalindromeCheck {
	public static void main(String[] args) {
		boolean isPal = isPalindrome("maananaam");
		System.out.println(isPal);
	}
	
	public static boolean isPalindrome(String str) {
		if (str.length() == 1) {
			return true;
		}
		for (int i = 0; i < str.length(); i++) {
			int endIndex = str.length() - 1 - i;
			if (i > endIndex) {
				return true;
			}
			char s = str.charAt(i);
			char e = str.charAt(endIndex);
			if (s != e) {
				return false;
			}
		}
		return false;
	}
	
	
	public static boolean isPalindrome2(String str){
		if(str == null || str.isEmpty()){
			return false;
		}else if(str.length() == 1){
			return true;
		}
		for(int i=0; i< str.length()/2; i++){
			char reverseChar = str.charAt(str.length()-i-1);
			char currentChar = str.charAt(i);
			if(reverseChar != currentChar){
				return false;
			}
		}
		return true;
		
	}

}
