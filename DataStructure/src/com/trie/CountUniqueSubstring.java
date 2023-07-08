package com.trie;

import com.trie.Trie.Node;

/**
 * 
 * @author Alok Soni
 * 
 * problem: Given a string of length n of lowercase alphabet characters, we need to count total number of distinct(unique) substrings of this  string.
 * 
 * str = "ababa"
 * output = 10
 *
 */

public class CountUniqueSubstring {
	private static Node root = new Node();
	
	public static void main(String[] args) {
		String str = "abba";
		
		System.out.println(countUniqueSubstring(str));
		
	}
	
	public static int countUniqueSubstring(String str) {
		for (int i=0; i< str.length(); i++) {
			String suffix = str.substring(i);
			insert(suffix);
		}
		Node current = root;
		return countTrieNode(current);
	}
	
	private static int countTrieNode(Node root) {
		if (root == null) {
			return 0;
		}
		
		int count =0;
		for (int i=0; i< 26; i++) {
			if (root.children[i] != null) {
				count = count + countTrieNode(root.children[i]);
			}
		}
		return count+1;
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
