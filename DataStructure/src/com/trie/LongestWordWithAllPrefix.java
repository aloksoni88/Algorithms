package com.trie;

import com.trie.Trie.Node;

/**
 * 
 * @author Alok Soni
 * 
 * Problem: Longest word with all prefix
 * 	Find the longest string in words such that every prefix of it  is also in words.
 *  words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 *  
 *  output = "apple"
 *
 */

public class LongestWordWithAllPrefix {
	private static Node root = new Node();

	
	public static void main(String[] args) {
		//String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String[] words = {"a", "ab", "abc", "p", "pb", "pbd", "pbdh", "pbde"};
		
		Node current = root;
		for (int i=0; i< words.length; i++) {
			insert(words[i]);
		}
		printTrie(current);
		
		System.out.println();
		
		String ans = longestWordWithAllPrefix(current, new StringBuilder(), "");
		
		System.out.println(ans);
	}
	
	public static String longestWordWithAllPrefix(Node root, StringBuilder temp, String ans) {
		if (root == null) {
			return "";
		}
		for (int i=0; i< 26; i++) {
			if (root.children[i] != null && root.children[i].eow) {
				char ch = (char)('a' + i);
				temp.append(ch);
				if (temp.length() > ans.length()) {
					ans = temp.toString();
				}
				ans = longestWordWithAllPrefix(root.children[i], temp, ans);
				temp.deleteCharAt(temp.length()-1);
			}
		}
		return ans;
	}
	

	public static void printTrie(Node root) {
		if (root == null) {
			return;
		}
		for (int i=0; i< 26; i++) {
			if (root.children[i] != null) {
				System.out.print((char)(i + 'a') + " ");
				if (root.children[i].eow) {
					System.out.println();
				}
			}
			printTrie(root.children[i]);
		}
	}
	
	public static void insert(String word) {
		Node current = root;
		for (int i=0; i< word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Node();
			}
			if (i == word.length()-1) {
				current.children[index].eow = true;
			}
			current = current.children[index];
		}
	}
	
	public static boolean search(String word) {
		Node current = root;
		for (int i=0; i< word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				return false;
			}
			if (i == word.length()-1 && !current.children[index].eow) {
				return false;
			}
			current = current.children[index];
		}
		return true;
	}

}
