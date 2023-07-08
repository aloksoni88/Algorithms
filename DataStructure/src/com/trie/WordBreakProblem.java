package com.trie;

import com.trie.Trie.Node;

/**
 * 
 * @author Alok Soni
 * 
 * Problem: Given an input string & dictionary of words, find out if the input string
 * 			can be broken into a space-separated sequence of dictionary words.
 * words[] = {i, like, samsung, mobile, ice}
 * key = "ilikesamsung"
 * 
 * output = true
 *
 */
public class WordBreakProblem {
	private static Node root = new Node();
	
	public static void main(String[] args) {
		String[] words = {"i", "like", "sam",  "samsung", "mobile"};
		String key = "ilikesamsung";
	
		
		for (int i=0; i< words.length; i++) {
			insert(words[i]);
		}
		

		Node current = root;
		printTrie(current);
		
		System.out.println();
		System.out.println(wordBreak(key));
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
	
	public static boolean wordBreak(String key) {
		if (key.length() == 0) {
			return true;
		}
		
		for (int i=1 ; i<= key.length(); i++) {
			String firstPart = key.substring(0, i);
			String secondPart = key.substring(i);
			
			if (search(firstPart) && wordBreak(secondPart)) { 
				System.out.println("Split Parts : " + firstPart);
				return true;
			}
		}
		return false;
	}
}
