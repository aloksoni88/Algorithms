/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class NodeDepth {
	public static int nodeDepths(BinaryTree root) {
		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return getDepth(root, 0);
	}

	private static int getDepth(BinaryTree root, int depth) {
		if (root == null) {
			return 0;
		}
		return depth + getDepth(root.left, depth + 1) + getDepth(root.right, depth + 1);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
