/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alok Soni
 *
 */
public class SuffixTrieConstruction {
	public static void main(String[] args) {
		String str = "babc";
		SuffixTrie suffixTrie = new SuffixTrie(str);
		System.out.println(suffixTrie.contains("abc"));

	}

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

		@Override
		public String toString() {
			return children.toString();
		}
	}

	static class SuffixTrie {
		TrieNode root = new TrieNode();
		char endSymbol = '*';

		public SuffixTrie(String str) {
			populateSuffixTrieFrom(str);
			System.out.println(root);
		}

		public void populateSuffixTrieFrom(String str) {
			if (str == null || str.length() == 0) {
				return;
			}
			char[] c = str.toCharArray();
			char endChar = '*';
			for (int i = 0; i < c.length; i++) {
				TrieNode node = root;
				for (int j = i; j < c.length; j++) {
					char ch = c[j];
					if (!node.children.containsKey(ch)) {
						TrieNode trieNode = new TrieNode();
						node.children.put(ch, trieNode);
					}
					node = node.children.get(ch);
				}
				node = node.children.put(endChar, null);
			}
		}

		public boolean contains(String str) {
			if (str == null || str.length() == 0) {
				return false;
			}
			char[] c = str.toCharArray();
			TrieNode node = root;
			char endChar = '*';
			for (int i = 0; i < c.length; i++) {
				char ch = c[i];
				if (node.children.containsKey(ch)) {
					node = node.children.get(ch);
				} else {
					return false;
				}
			}
			if (!node.children.containsKey(endChar)) {
				return false;
			}
			return true;
		}
	}
}
