/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Alok Soni
 *
 */
public class MultiStringSearch {
	public static void main(String[] args) {
		String bigString = "Mary goes to the shopping center every week.";
		String[] smallStrings = {"to", "Mary", "centers", "shop", "shopping", "string", "kappa"};
		List<Boolean> matchingResult = multiStringSearch(bigString, smallStrings);
		System.out.println(matchingResult);
	}
	
	/******************* Solution 1(Optimzed One)*********************/
	//Time - O(ns + bn) 
	//Space - O(ns)
	/*where b is the length of big string
			n is the length of the biggest string of small string ex - shopping is the biggest string of small string
			s is the length of the small string*/
	public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
		Trie trie = new Trie();
		ArrayList<Boolean> result = new ArrayList<>();
		int smallStrLen = smallStrings.length;
		for(int i=0; i< smallStrLen; i++) {
			String smallString = smallStrings[i];
			trie.createTrie(smallString);
		}
		
		HashSet<String> matchedStringSet = new HashSet<>();
		
		for(int i=0; i< bigString.length(); i++) {
			TrieNode node = trie.root;
			for(int j=i; j< bigString.length(); j++) {
				char ch = bigString.charAt(j);
				if(!node.children.containsKey(ch)) {
					break;
				}
				node = node.children.get(ch);
				if(node.children.containsKey(trie.endSymbol)) {
					matchedStringSet.add(node.word);
				}
			}
		}
		System.out.println(matchedStringSet);
		
		for(int i=0; i<smallStrLen; i++) {
			String smallString = smallStrings[i];
			if(matchedStringSet.contains(smallString)) {
				result.add(true);
			}else {
				result.add(false);
			}
		}
		return result;
	}
	
	static class TrieNode{
		Map<Character,TrieNode> children = new HashMap<>();
		String word;
	}
	
	static class Trie{
		TrieNode root = new TrieNode();
		char endSymbol = '*';
		
		private void createTrie(String str) {
			TrieNode node = root;
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(!node.children.containsKey(ch)) {
					TrieNode newNode = new TrieNode();
					node.children.put(ch, newNode);
				}
				node = node.children.get(ch);
			}
			node.children.put(endSymbol, null);
			node.word = str;
		}
	}

	/******************* Solution 2*********************/
	//Time - O(b^2 + ns) 
	//Space - O(b^2 + s)
	/*where b is the length of big string
			n is the length of the biggest string of small string ex - shopping is the biggest string of small string
			s is the length of the small string*/
	public static List<Boolean> multiStringSearch2(String bigString, String[] smallStrings) {
		TrieNodeSuffix trieNodeSuffix = new TrieNodeSuffix(bigString);
		ArrayList<Boolean> result = new ArrayList<>();
		int smallStrLen = smallStrings.length;
		for(int i=0; i< smallStrLen; i++) {
			String smallString = smallStrings[i];
			boolean isFound = trieNodeSuffix.isExist(smallString);
			result.add(isFound);
		}
		return result;
	}
	
	static class TrieNode2{
		Map<Character, TrieNode2> children = new HashMap<>();
	}
	
	static class TrieNodeSuffix{
		TrieNode2 root = new TrieNode2();
		
		public TrieNodeSuffix(String str) {
			createSuffixTrie(str);
		}
		
		private void createSuffixTrie(String str) {
			for(int i=0; i< str.length(); i++) {
				createSuffixTrie(str, i);
			}
		}
		
		private void createSuffixTrie(String str, int currentIndex) {
			TrieNode2 node = root;
			for(int i=currentIndex; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(!node.children.containsKey(ch)) {
					TrieNode2 newNode = new TrieNode2();
					node.children.put(ch, newNode);
				}
				node = node.children.get(ch);
			}
		}
		
		private boolean isExist(String smallString) {
			TrieNode2 node = root;
			for(int i=0; i<smallString.length(); i++) {
				char ch = smallString.charAt(i);
				if(!node.children.containsKey(ch)) {
					return false;
				}
				node = node.children.get(ch);
			}
			return true;
		}
	}
	
	
	/******************* Solution 3*********************/
	//Time - O(bns) 
	//Space - O(n)
	/*where b is the length of big string
			n is the length of the biggest string of small string ex - shopping is the biggest string of small string
			s is the length of the small string*/
	public static List<Boolean> multiStringSearch3(String bigString, String[] smallStrings) {
		ArrayList<Boolean> result = new ArrayList<>();
		int smallStrLen = smallStrings.length;
		for(int i=0; i< smallStrLen; i++) {
			String smallString = smallStrings[i];
			boolean isFound = isExist(smallString, bigString);
			result.add(isFound);
		}
		return result;
	}
	
	private static boolean isExist(String smallString, String bigString) {
		int smallStrIndex = 0;
		int bigStrIndex = 0;
		while(bigStrIndex < bigString.length()) {
			if(smallString.charAt(smallStrIndex) == bigString.charAt(bigStrIndex)) {
				smallStrIndex++;
				bigStrIndex++;
			}else {
				smallStrIndex = 0;
				bigStrIndex++;
			}
			if(smallStrIndex == smallString.length()) {
				return true;
			}
		}
		return false;
	}
	
//	private static boolean isExist(String smallString, String bigString) {
//		String[] strArr = bigString.split(" ");
//		for(int i=0; i<strArr.length; i++) {
//			if(strArr[i].equals(smallString) || strArr[i].contains(smallString)) {
//				return true;
//			}
//		}
//		
//		for(int i=0; i<strArr.length; i++) {
//			String str = strArr[i];
//			if(smallString.length() <= str.length()) {
//				int count = 0;
//				while(count < smallString.length()) {
//					if(str.charAt(count) == smallString.charAt(count)) {
//						count++;
//					}else {
//						break;
//					}
//				}
//				if(count == smallString.length()) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
}
