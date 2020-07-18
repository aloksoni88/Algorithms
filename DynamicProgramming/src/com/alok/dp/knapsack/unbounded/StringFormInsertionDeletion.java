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
public class StringFormInsertionDeletion {
	public static void main(String[] args) {
		String str1 = "geeksforgeeks";
		String str2 = "geeks";
		String result = getLCM(str1, str2);
		System.out.println("Longest common subsequence is : "+result);
		int deletion = str1.length() -  result.length();
		int insertion = str2.length() - result.length();
		System.out.println("Minimum Deletion " + deletion);
		System.out.println("Minimum Insertion " + insertion);
	}
	
	private static String getLCM(String str1, String str2) {
		int[][] t = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<str1.length()+1; i++) {
			for(int j=0; j<str2.length()+1; j++) {
				if(i==0 || j == 0) {
					t[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Integer.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		
		String result = "";
		int i = str1.length(), j = str2.length();
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				result = str1.charAt(i-1) + result;
				i--;
				j--;
			}else if(t[i-1][j] > t[i][j-1]) {
				i--;
			}else {
				j--;
			}
		}
		return result;
	}
}
