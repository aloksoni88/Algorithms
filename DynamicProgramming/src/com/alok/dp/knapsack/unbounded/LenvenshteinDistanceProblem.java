/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 * 
 */

/***************** Question ***********************/

/*******
	Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert �str1� into �str2�.
	
	Insert
	Remove
	Replace
	All of the above operations are of equal cost.
	
	Examples:
	
	Input:   str1 = "geek", str2 = "gesek"
	Output:  1
	We can convert str1 into str2 by inserting a 's'.
	
	Input:   str1 = "cat", str2 = "cut"
	Output:  1
	We can convert str1 into str2 by replacing 'a' with 'u'.
	
	Input:   str1 = "sunday", str2 = "saturday"
	Output:  3
	Last three and first characters are same.  We basically
	need to convert "un" to "atur".  This can be done using
	below three operations. 
	Replace 'n' with 'r', insert t, insert a
	https://www.geeksforgeeks.org/edit-distance-dp-5/
**************/

public class LenvenshteinDistanceProblem {
	public static void main(String[] args) {
		String str1 = "biting";
		String str2 = "mitten";
		//String result = getLCM(str1, str2);
		//int count = distanceRecursive(str1, str2, str1.length(), str2.length());
		int count = getDistanceOptimized(str1, str2);
		System.out.println("Lenvenshtein Distance is : "+count);
			
	}
	
	private static int getDistanceOptimized(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i==0) {
					t[i][j] = j;
				}else if(j==0) {
					t[i][j] = i;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = t[i-1][j-1];
				}else {
					t[i][j] = 1+min(t[i][j-1], t[i-1][j],t[i-1][j-1]);
				}
			}
		}
		
		return t[str1.length()][str2.length()];
	}
	
	private static int distanceRecursive(String str1, String str2, int m, int n) {
		if(m == 0 ) {
			return n;
		}else if(n == 0) {
			return m;
		}else if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return distanceRecursive(str1, str2, m-1, n-1);
		}else {
			return 1+min(distanceRecursive(str1, str2, m, n-1),
							distanceRecursive(str1, str2, m-1, n),
							distanceRecursive(str1, str2, m-1, n-1));
		}
	}
	
	private static int min(int a, int b, int c) {
		if(a <= b && a <= c) {
			return a;
		}else if(b <= a && b <= c) {
			return b;
		}else {
			return c;
		}
	}
}
