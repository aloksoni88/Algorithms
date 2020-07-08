/**
 * 
 */
package com.alok.algoexpert.io.easy;

/**
 * @author Alok Soni
 *
 */
public class PalindromeCheck {
	 public static boolean isPalindrome(String str) {
		    if(str.length() == 1 ){
						return true;
				}
				for(int i=0; i<str.length(); i++){
						int endIndex = str.length()-1-i;
						if(i> endIndex){
								return true;
						}
						char s = str.charAt(i);
						char e = str.charAt(endIndex);
						if(s != e){
								return false;
						}
				}
		    return false;
		  }
}
