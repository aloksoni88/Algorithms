/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class LevenshteinDistance {
	public static void main(String[] args) {
		String s1 = "cereal";
		String s2 = "saturday";
		int counter=0;
		String tmp = s1;
		for(int i=0; i<s2.length(); i++){
			if(i >= s1.length() || s1.charAt(i) != s2.charAt(i)) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
