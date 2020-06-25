package com.string;

public class StringRotation {
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		boolean isRotation = checkRotation(s1,s2);
		System.out.println("Is rotation : " + isRotation);
	}
	
	private static boolean checkRotation(String s1, String s2) {
		if(s1.length() == s2.length() && (s1+s2).contains(s2)) {
			return true;
		}
		return false;
	}
}
