/**
 * 
 */
package com.trie;

/**
 * @author Alok Soni
 *
 */
public class Trie {

	public Node root = new Node();

	public static class Node {
		public Node children[];
		public boolean eow;
		public String word;

		public Node() {
			children = new Node[26];
		}
	}

	public void addWords(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
			if (current.children[index] == null) {
				current.children[index] = new Node();
			}
			if (i == word.length() - 1) {
				current.children[index].eow = true;
				current.children[index].word = word;
			}
			current = current.children[index];
		}
	}
}
