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
		String str = "****@@&&$$!!!#ssssTTTT))))a";
		String result = runLengthEncoding2(str);
		System.out.println(result);//1a1A1a1A5a1A3a4A1B3b4B
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
	
	public static String runLengthEncoding2(String str){
		StringBuffer result = new StringBuffer("");
		int count =1;
		for(int i=0; i<str.length()-1; i++){
			if(str.charAt(i) == str.charAt(i+1)){
				count++;
			}else{
				result.append(getEncodedString(i, count, str));
				count = 1;
			}
		}
		result.append(getEncodedString(str.length()-1, count, str));
		return result.toString();
	}
	
	private static StringBuffer getEncodedString(int i, int count, String str) {
		StringBuffer result = new StringBuffer("");
		int div = count/9; 
		int rem = count%9;
		while(div > 0){
			result.append(""+9+str.charAt(i)+"");
			div--;
		}
		result.append(""+rem+str.charAt(i));
		return result;
	}


}
