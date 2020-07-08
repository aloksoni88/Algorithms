package com.alok.algoexpert.io.medium;

public class InvertBinaryTree {
	public static void invertBinaryTree(BinaryTree tree) {
		if (tree == null) {
			return;
		}
		invertBST(tree);
	}

	private static BinaryTree invertBST(BinaryTree tree) {
		if (tree == null) {
			return null;
		}
		BinaryTree tmp = tree.right;
		tree.right = invertBST(tree.left);
		tree.left = invertBST(tmp);
		return tree;
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
