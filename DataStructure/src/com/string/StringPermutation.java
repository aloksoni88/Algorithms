package com.string;


public class StringPermutation {
	private static int count = 0;
	static boolean[] alpha = new boolean[256];
	public static void main(String[] args) {
		String str = "abb";
		permutation(str, "");
		/*if(str == null || str.isEmpty()){
			System.out.println("empty string");
		}else if(str.length() == 1){
			System.out.println(str);
		}else if(str.length() == 2){
			System.out.println(str);
			System.out.println(""+str.charAt(1) + str.charAt(0));
		}else{
			permutationMyOwn(str, "");
		}*/
	}
	
	private static void permutation(String str, String ans){
		if(str.length() == 0){
			System.out.println(ans +" " + ++count);
			return;
		}
		
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			String ros = str.substring(0,i) + str.substring(i+1);
			permutation(ros, ans+ch);
		}
	}
	
	private static void permutationMyOwn(String str, String ans){
		/*System.out.println("ans: " + ans);
		if(str.length() == 0){
			System.out.println(ans +" ");
			return;
		}*/
		
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			String ros = str.substring(0,i) + str.substring(i+1);
			if(ros.length() == 2){
				String result = ans+ch + ros;
				System.out.println(result + " " + ++count);
				result = ans + ch + swap(ros);
				System.out.println(result + " " + ++count);
			}else{
				permutation(ros, ans+ch);
			}
		}
	}
	
	private static String swap(String str){
		char a = str.charAt(0);
		char b = str.charAt(1);
		return ""+b+a;
	}
}
