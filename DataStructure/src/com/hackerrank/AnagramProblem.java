package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author mehar
 * 
 * Problem:

An anagram is a word that can be written as a permutation of the characters of another word, 
like "dirty room" and "dormitory" (ignore spaces). However, "the" and "thee" are not anagrams, 
since "the" only has a single "e" whereas "thee" has two "e" characters (spaces can occur zero, or multiple times, however.)

Given a list of words as strings, you should return another list of strings, each containing words that are mutual anagrams.

Each string of the output should be a single group of anagarms joined with commas.
Within an output string, the expression should be sorted lexicographically. 
If a group contains only a single element, output that one-element group as a single string.
 And the string should be also output in lexicographical order. Given e.g.:

pear
amleth
dormitory
tinsel
dirty room
hamlet
listen
silnet
... the output would be:

amleth,hamlet
dirty room,dormitory
listen,silnet,tinsel
pear
 *
 */

public class AnagramProblem {
	
	public static void main(String[] args) {
		String[] inputList = {"pear","amleth","dormitory","tinsel","dirty room","hamlet","listen","silnet"};
		List<String> output = listAnagram(inputList);
		System.out.println(output);
		
	}
	
	private static List<String> listAnagram(String[] strArr){
		List<String> output = new ArrayList<String>();
		List<StringBuffer> checkList = new ArrayList<StringBuffer>();
		if(strArr != null && strArr.length > 0){
			Arrays.sort(strArr);
			for(int i = 0; i<strArr.length; i++){
				System.out.print(strArr[i] + " ");
			}
			System.out.println();
			for(int i = 0; i<strArr.length; i++){
				StringBuffer anagramStr = new StringBuffer(strArr[i]) ;
				boolean isAnagram = false;
				for(int j=i+1; j<strArr.length-1;j++){
					if(checkAnagram(strArr[i],strArr[j])){
						isAnagram = true;
						if(anagramStr.toString().isEmpty()){
							anagramStr.append(strArr[j]);
						}else{
							anagramStr.append(" " + strArr[j]);
						}
						if(!checkList.contains(new StringBuffer(strArr[i]))){
							checkList.add(new StringBuffer(strArr[i]));
						}
						if(!checkList.contains(new StringBuffer(strArr[j]))){
							checkList.add(new StringBuffer(strArr[j]));
						}
					}
				}
				/*if(isAnagram){
					checkList.add(new StringBuffer(strArr[i]));
					//System.out.println(anagramStr);
				}*/
				if(isAnagram){
					output.add(anagramStr.toString());
				}
				/*if(!checkList.contains(anagramStr.toString())){
					output.add(strArr[i]);
				}*/
			}
		}
		return output;
	}
	
	private static boolean checkAnagram(String str1, String str2){
		char[] char1 = str1.replaceAll("\\s", "").toCharArray();
		char[] char2 = str2.replaceAll("\\s", "").toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		if(Arrays.equals(char1, char2)){
			//System.out.println("checkAnagram " + str1 + " " + str2);
			return true;
		}else{
			return false;
		}
	}
	
	/*private static List<String> listAnagram(String[] strArr){
		List<String> output = Arrays.asList(strArr);
		List<char[]> inputList = new ArrayList<char[]>();
		if(strArr != null && strArr.length > 0){
			for(int i = 0; i<strArr.length; i++){
				inputList.add(strArr[i].toCharArray());
			}
			for(int i = 0; i<inputList.size(); i++){
				Arrays.sort(inputList.get(i));
			}
			HashMap<char[], Integer> map = new HashMap<char[], Integer>();
			for(char[] ch : inputList){
				int count = 1;
				if(map.containsKey(ch)){
					count = map.get(ch)+1;
				}
				map.put(ch, count);
			}
		}
		return output;
	}*/
}
