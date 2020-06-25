package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.stack.Utils;

public class AnagramCount {
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			StringBuilder builder = new StringBuilder();
			for(int k=0; k<noOfTestCase; k++){
				
				String str = br.readLine().trim();
				String word = br.readLine().trim();
				//String[] anagrams = findAnagramWord(word);
				word = sortString(word);
				int count = 0;
				for(int i=0; i<=str.length()-word.length(); i++){
					String s = str.substring(i,word.length()+i);
					//System.out.print(s + " ");
					String sortedString = sortString(s);
					if(sortedString.equalsIgnoreCase(word)){
						count++;
					}
				}
				
				builder.append(count+"\n");
			}
			System.out.println(builder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String sortString(String word){
		char[] charArr = word.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
	
	private static String[] findAnagramWord(String word){
		String anagram = "";
		for(int i=0; i<word.length(); i++){
			String s = word.substring(i) + word.substring(0, i);
			anagram = anagram.isEmpty() ? s : anagram + " " + s;
		}
		//System.out.println(anagram);
		String[] arr = anagram.trim().split("\\s+");
		return arr;
	}
	
	static void printPermutn(String str, String ans) 
    { 
  
        // If string is empty 
		
        if (str.length() == 0) { 
            //System.out.print(ans + " "); 
            //anagrams.add(ans);
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 
 
}
