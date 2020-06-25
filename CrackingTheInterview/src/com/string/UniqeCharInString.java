package com.string;

/**
 *  Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	cannot use additional data structures?
**/ 
public class UniqeCharInString {
	public static void main(String[] args) {
		String str = "hutg9mnd!nk9";
		if(str == null || str.isEmpty()){
			System.out.println("empty string");
			return; 
		}
		boolean isUnique = isUnique(str);
		System.out.println("String has unique characters : " + isUnique);
	}
	
	private static boolean isUnique(String str){
		boolean[] alpha = new boolean[256];
		for(int i=0; i<str.length(); i++){
			if(alpha[256 - str.charAt(i)]){
				return false;
			}else{
				alpha[256 - str.charAt(i)] = true;
			}
		}
		return true;
	}
}
