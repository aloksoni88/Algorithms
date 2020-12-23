/**
 * 
 */
package com.alok.algoexpert.io.easy;

import java.util.LinkedHashMap;

/**
 * @author Alok Soni
 *
 */
public class RunLengthEncoding {
	public static void main(String[] args) {
		String str = "aAaAaaaaaAaaaAAAABbbbBBBB";
		String result = runLengthEncoding(str);
		System.out.println(result);
	}

	//Time - O(n), Space - O(n) where n is the length of string 
	public static String runLengthEncoding(String string) {
		StringBuilder result = new StringBuilder();
		char prevChar = string.charAt(0);
		int count = 1;
		for(int i=1; i<string.length(); i++) {
			if(prevChar == string.charAt(i)) {
				count++;				
			}else {		
				getLengthEncoding(count, result, prevChar);
				prevChar = string.charAt(i);
				count = 1;
			}			
		}
		getLengthEncoding(count, result, prevChar);
		return result.toString();
	}
	
	private static void getLengthEncoding(int count, StringBuilder result, char prevChar) {
		int div = count/9;
		int rem = count%9; 
		if(div >= 1 && rem > 0) {				
			for(int k=0; k<div; k++) {
				result.append(9 +""+prevChar);
			}
			if(rem != 0) {
				result.append(rem + "" +prevChar);
			}
		}else {
			result.append(count + ""+ prevChar);					
		}		
	}

}
