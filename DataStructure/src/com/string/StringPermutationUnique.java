package com.string;

import java.util.HashSet;

public class StringPermutationUnique {
	private static int count = 0;
	private static HashSet<String> set = new HashSet<String>();
	public static void main(String[] args) {
		String str = "aaa";
		uniquePermutation(str,"");
		System.out.println("Total no of unique combinations are : " + set.size());
		System.out.println(set);
	}
	
	private static void uniquePermutation(String str, String ans){
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i+1);
			if(ros.length() == 2){
				String result = ans +ch + ros;
				set.add(result);
				result = ans + ch + swap(ros);
				set.add(result);
			}else{
				uniquePermutation(ros, ans+ch);
			}
		}
	}
	
	private static String swap(String str){
		return "" + str.charAt(1) + str.charAt(0);
	}
}
