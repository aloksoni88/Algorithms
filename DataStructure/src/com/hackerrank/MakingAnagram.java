package com.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MakingAnagram {
	public static void main(String[] args) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Outputs/making_anagrams_output.txt"));

			int[][] arr = new int[6][6];

			BufferedReader br = new BufferedReader(new FileReader("Inputs/making_anagram_input_test_2.txt"));
			String sCurrentLine;
			int counter = 0;
			String a="", b="";
			while ((sCurrentLine = br.readLine()) != null) {
				if(counter==0){
					a = sCurrentLine;	
				}else{
					b= sCurrentLine;
				}
				counter++;
				//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				
			}
			System.out.println("First input " + a);
			System.out.println("Second input " + b);
			int result = makeAnagram(a, b);
			System.out.println("Result "+ result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int makeAnagram(String a, String b) {
		int[] lettercounts = new int[26];
		for(char c : a.toCharArray()){
			System.out.print((c-'a') + " ");
			lettercounts[c-'a']++;
		}
		System.out.println();
		for(char c : b.toCharArray()){
			System.out.print((c-'a')+" ");
			lettercounts[c-'a']--;
		}
		System.out.println();
		int result = 0;
		for(int i : lettercounts){
			System.out.print(i+" ");
		}
		System.out.println();
		
		for(int i : lettercounts){
			System.out.print(Math.abs(i)+" ");
			result += Math.abs(i);
		}
		System.out.println();
		return result;

    }
}
