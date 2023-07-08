package com.trie;

import com.trie.Trie.Node;

/**
 * 
 * @author Alok Soni
 * 
 * Problem: create a function boolean startWith(String prefix) for trie.
 * 			Return true if there is previously inseted string word that has the prefix prefix, and false otherwice
 * 
 * String[] words = { "apple", "app", "mango", "man", "women"};
 * prefix = "app" , output = true
 * prefix = "moon", output = false
 *
 */

public class StartWithProblem {
	private static Node root = new Node();
	public static void main(String[] args) {
		String[] words = { "apple", "app", "mango", "man", "women"};
		String[] prefix = {"app", "moon"};
		
		Node current = root;
		for (int i=0; i< words.length; i++) {
			insert(words[i]);
		}
		
		printTrie(current);
		System.out.println();
		
		for (int i=0; i< prefix.length; i++) {
			System.out.println(startWith(prefix[i]));
		}
	}
	
	public static boolean startWith(String prefix) {
		Node current = root;
		for (int i=0; i< prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return true;
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
