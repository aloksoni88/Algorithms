/**
 * 
 */
package com.string;

/**
 * @author Alok Soni
 * Question
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
	has sufficient space at the end to hold the additional characters, and that you are given the "true"
	length of the string. (Note: If implementing in Java, please use a character array so that you can
	perform this operation in place.)
	EXAMPLE
	Input: "Mr 3ohn Smit h 13
	Output: "Mr%203ohn%20Smith" 
 */
public class URLify {
	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		if(input == null || input.trim().isEmpty()){
			System.out.println("empty string");
			return;
		}
		char[] output = urlify(input.toCharArray(),input.trim().length());
		for(int i=0; i<output.length; i++){
			System.out.print(output[i]);	
		}
	}
	
	private static char[] urlify(char[] arr,int length){
		char[] output = new char[arr.length];
		int index = 0;
		for(int i=0; i<length; i++){
			if(arr[i] == ' '){
				output[index] = '%';
				output[index+1] = '2';
				output[index+2] = '0';
				index = index + 3;
			}else{
				output[index]  = arr[i];
				index++;
			}
		}
		return output;
	}
}
