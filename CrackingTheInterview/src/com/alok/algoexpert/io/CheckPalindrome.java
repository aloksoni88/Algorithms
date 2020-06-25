/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class CheckPalindrome {
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
