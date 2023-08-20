/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.trie.Trie.Node;

/**
 * @author Alok Soni
 *
 */
public class BoggleBoard {
	public static void main(String[] args) {
		char[][] board = { { 't', 'h', 'i', 's', 'i', 's', 'a' }, { 's', 'i', 'm', 'p', 'l', 'e', 'x' },
				{ 'b', 'x', 'x', 'x', 'x', 'e', 'b' }, { 'x', 'o', 'g', 'g', 'l', 'x', 'o' },
				{ 'x', 'x', 'x', 'D', 'T', 'r', 'a' }, { 'R', 'E', 'P', 'E', 'A', 'd', 'x' },
				{ 'x', 'x', 'x', 'x', 'x', 'x', 'x' }, { 'N', 'O', 'T', 'R', 'E', '-', 'P' },
				{ 'x', 'x', 'D', 'E', 'T', 'A', 'E' } };
		String[] words = { "this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED" };
		List<String> result = boggleBoard(board, words);
		System.out.println(result);
	}


	// Time - O(nm*8^s + ws)
	// Space - O(nm + ws)
	public static List<String> boggleBoard(char[][] board, String[] words) {
		if (words == null || words.length == 0) {
			return new ArrayList<>();
		}
		Trie trie = new Trie();
		for (String str : words) {
			trie.addWords(str);
		}
		ArrayList<String> finalWords = new ArrayList<>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				explore(i, j, board, trie.root, finalWords, visited);
			}
		}

		return finalWords;
	}

	private static void explore(int i, int j, char[][] board, TrieNode trieNode, List<String> finalWords,
			boolean[][] visited) {
		if (visited[i][j]) {
			return;
		}
		if (!trieNode.children.containsKey(board[i][j])) {
			return;
		}
		visited[i][j] = true;
		trieNode = trieNode.children.get(board[i][j]);
		if (trieNode.children.containsKey('*')) {
			if (!finalWords.contains(trieNode.word)) {
				finalWords.add(trieNode.word);
			}
		}
		List<Integer[]> neighbours = getNeigbours(i, j, board);
		for (int k = 0; k < neighbours.size(); k++) {
			Integer[] neighbour = neighbours.get(k);
			explore(neighbour[0], neighbour[1], board, trieNode, finalWords, visited);
		}
		visited[i][j] = false;
	}

	private static List<Integer[]> getNeigbours(int i, int j, char[][] board) {
		List<Integer[]> neigbours = new ArrayList<>();
		if (i > 0 && j > 0) {
			neigbours.add(new Integer[] { i - 1, j - 1 });
		}
		if (i > 0) {
			neigbours.add(new Integer[] { i - 1, j });
		}
		if (i > 0 && j < board[0].length - 1) {
			neigbours.add(new Integer[] { i - 1, j + 1 });
		}
		if (j < board[0].length - 1) {
			neigbours.add(new Integer[] { i, j + 1 });
		}
		if (i < board.length - 1 && j < board[0].length - 1) {
			neigbours.add(new Integer[] { i + 1, j + 1 });
		}
		if (i < board.length - 1) {
			neigbours.add(new Integer[] { i + 1, j });
		}
		if (i < board.length - 1 && j > 0) {
			neigbours.add(new Integer[] { i + 1, j - 1 });
		}
		if (j > 0) {
			neigbours.add(new Integer[] { i, j - 1 });
		}
		return neigbours;
	}

}

class TrieNode {
	HashMap<Character, TrieNode> children = new HashMap<>();
	String word = "";
}

class Trie {
	TrieNode root;
	Character endSymbol;

	public Trie() {
		this.root = new TrieNode();
		this.endSymbol = '*';
	}

	public void addWords(String str) {
		TrieNode node = this.root;
		for (int i = 0; i < str.length(); i++) {
			TrieNode newNode = new TrieNode();
			if (!node.children.containsKey(str.charAt(i))) {
				node.children.put(str.charAt(i), newNode);
			}
			node = node.children.get(str.charAt(i));
		}
		node.children.put(endSymbol, null);
		node.word = str;
	}
}
