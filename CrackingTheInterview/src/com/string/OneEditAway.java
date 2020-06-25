package com.string;

public class OneEditAway {
	public static void main(String[] args) {
		String input1 = "";
		String input2 = "";
		checkString(input1,input2);
	}
	
	private static void checkString(String input1,String input2) {
		int lenDiff = 0;
		int length = 0;
		if(input1.length() > input2.length()) {
			length = input2.length();
			lenDiff = input1.length() - input2.length();
		}else {
			length = input1.length();
			lenDiff = input2.length() - input1.length();
		}
		if(lenDiff > 1) {
			System.out.println("no , no of edit " + lenDiff);
			return;
		}
		int count = 0;
		for(int i=0; i<length; i++) {
			if(input1.charAt(i) != input2.charAt(i)) {
				count++;
			}
		}
		if(count > 1) {
			System.out.println("no , no of edit " + (count + lenDiff));
		}else {
			System.out.println("yes , no of edit " + (count + lenDiff));
		}
	}
}
