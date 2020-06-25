package com.string;

public class StringPermOfKthLength {

	public static void main(String[] args) {
		char[] set1 = {'a', 'b','c'}; 
	    int k = 3; 
	    printAllKLength(set1, k); 
	}
	
	
	static void printAllKLength(char[] set, int k) {
		int n = set.length;
		printAllKLengthRec(set, "", n, k);
	}

	static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
		if (k == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < n; ++i) {
			String newPrefix = prefix + set[i];
			printAllKLengthRec(set, newPrefix, n, k - 1);
		}
	}
}
