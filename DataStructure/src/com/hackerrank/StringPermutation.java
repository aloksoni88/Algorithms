package com.hackerrank;

public class StringPermutation {
	
	public static void main(String[] args){
		permutation("abc");
		System.out.println("total no of Permutation "+resultCount);
	}

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	static int resultCount = 0;
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	resultCount++;
	    	System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++){
	        	//System.out.println((prefix + str.charAt(i)) + " " + str.substring(0, i) + str.substring(i+1, n));
	        	//permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        	if(i+3 <= n){
	        		System.out.println(str.substring(i,i+3));
	        	}
	        }
	    }
	}
}

