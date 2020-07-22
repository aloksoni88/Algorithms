/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class GroupAnagrams {
	
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("yo");
		words.add("act");
		words.add("flop");
		words.add("tac");
		words.add("cat");
		words.add("oy");
		words.add("olfp");
		System.out.println(groupAnagrams(words));
	}
	
	public static List<List<String>> groupAnagrams(List<String> words) {
		if (words == null || words.isEmpty()) {
			return new ArrayList<>();
		}
		System.out.println(words);
		List<String> sortedWords = new ArrayList<>();
		
		for(int i=0; i<words.size(); i++) {
			String str = words.get(i);
			char[] charArr= str.toCharArray();
			Arrays.sort(charArr);
			sortedWords.add(new String(charArr));
		}
		
		System.out.println(sortedWords);

		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < sortedWords.size(); i++) {
			List<String> list = new ArrayList<>();
			if (!map.containsKey(sortedWords.get(i))) {
				list.add(words.get(i));
				map.put(sortedWords.get(i), list);
			} else {
				list = map.get(sortedWords.get(i));
				list.add(words.get(i));
				map.put(sortedWords.get(i), list);
			}
		}
		List<List<String>> result = new ArrayList();
		for(List<String> value : map.values()) {
			result.add(value);
		}
		return result;
	}
}
