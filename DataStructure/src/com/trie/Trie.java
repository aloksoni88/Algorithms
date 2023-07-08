package com.trie;


public class Trie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		String[] words = {"the", "a", "there", "their", "any"};
		for (int i=0; i<words.length; i++) {
			trie.insert(words[i]);
		}
		Node current = root;
		trie.printTrie(current);
		
		String[] searchKeys = {"their", "thor", "an"};
		for (int i=0; i< searchKeys.length; i++) {
			System.out.println(trie.search(searchKeys[i]));
		}
		
	}
	
	private static Node root = new Node();
	
	public static class Node{
		Node[] children;
		boolean eow;
		
		public Node() {
			children = new Node[26];
			eow = false;
		}
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
