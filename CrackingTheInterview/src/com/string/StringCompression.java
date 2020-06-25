package com.string;

public class StringCompression {
	public static void main(String[] args) {
		String input = "abcdefg";
		String output = compressString(input);
		System.out.println("Compressed string is : " + output);
	}
	
	private static String compressString(String input) {
		String result = "";
		int counter = 1;
		for(int i=0; i<input.length(); i++) {
			if(i != 0) {
				if(input.charAt(i) != input.charAt(i-1)) {
					result = result + input.charAt(i-1) + counter;
					counter = 1;
				}else {
					counter++;
				}
				if(i == input.length()-1) {
					if(input.charAt(i) != input.charAt(i-1)) {
						result = result + input.charAt(i) + counter;	
					}else {
						result = result + input.charAt(i) + counter;
					}
				}
			}
		}
		if(result.replace("1", "").equalsIgnoreCase(input)){
			return input;
		}
		return result;
	}
}
