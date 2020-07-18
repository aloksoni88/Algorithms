/**
 * 
 */
package com.alok.dp.knapsack.unbounded;

/**
 * @author Alok Soni
 * Question
 * Given two strings �str1� and �str2� of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

	Examples:	
	Input : str1 = "heap", str2 = "pea" 
	Output : Minimum Deletion = 2 and
	         Minimum Insertion = 1
	p and h deleted from heap
	Then, p is inserted at the beginning
	One thing to note, though p was required yet
	it was removed/deleted first from its position and
	then it is inserted to some other position.
	Thus, p contributes one to the deletion_count
	and one to the insertion_count.
	
	Input : str1 = "geeksforgeeks", str2 = "geeks"
	Output : Minimum Deletion = 8
	         Minimum Insertion = 0       
 */
public class MinNumOfInsertionDelToConvertString {
	private static int[][] t;
	public static void main(String[] args) {
		String str1 = "sjfdsdjkff";
		String str2 = "sdfkjh";
		int count = lcmOptimized(str1, str2);
		int deletion = str1.length() - count;
		int insertion = str2.length() - count;
		
		System.out.println("Minimum Deletion = "+ deletion);
		System.out.println("Minimum Insertion = "+ insertion);
	}
	
	private static int lcmOptimized(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		t = new int[m+1][n+1];
		
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i == 0 || j==0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
				}
			}
		}
		return t[m][n];
	}
	
	private static void initMemoirzationArr(String str1, String str2) {
		int length = str1.length() > str2.length() ? str1.length() : str2.length();
		t = new int[length+1][length+1];
		for(int i = 0; i< length+1; i++) {
			for(int j=0; j<length+1; j++) {
				t[i][j] = -1;
			}
		}
	}
	
	private static int lcmMemoization(String str1, String str2, int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(t[m][n] != -1) {
			return t[m][n];
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return t[m][n] = 1+lcmRecursive(str1, str2, m-1, n-1);
		}else {
			return t[m][n] = Math.max(lcmRecursive(str1, str2, m, n-1), lcmRecursive(str1, str2, m-1, n));
		}
	}
	
	private static int lcmRecursive(String str1, String str2, int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1+lcmRecursive(str1, str2, m-1, n-1);
		}else {
			return Math.max(lcmRecursive(str1, str2, m, n-1), lcmRecursive(str1, str2, m-1, n));
		}
	}
}
