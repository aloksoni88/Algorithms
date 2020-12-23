/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class BinaryTreeDiameter {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.left = new BinaryTree(3);
		tree.right = new BinaryTree(2);
		tree.left.left = new BinaryTree(7);
		tree.left.right = new BinaryTree(4);
		tree.left.left.left = new BinaryTree(8);
		tree.left.left.right = null;
		tree.left.left.left.left = new BinaryTree(9);
		tree.left.left.left.right = null;
		tree.left.right.left = null;
		tree.left.right.right = new BinaryTree(5);
		tree.left.right.right.left = null;
		tree.left.right.right.right = new BinaryTree(6);
		tree.left.right.right.right.left = null;
		tree.left.right.right.right.right = null;
		tree.right.left = null;
		tree.right.right = null;
		
		int diameter = binaryTreeDiameter(tree);
		System.out.println("Diameter is : "+ diameter);
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	// average case when tree is balanced
	// Time - O(n), Space - O(h)
	// where n is the no of nodes in the tree and h is the height of the tree
	public static int binaryTreeDiameter(BinaryTree tree) {
		if (tree == null) {
			return 0;
		}

		int lHeight = getHeight(tree.left);
		int rHeight = getHeight(tree.right);

		int lDiameter = binaryTreeDiameter(tree.left);
		int rDiameter = binaryTreeDiameter(tree.right);

		return Math.max(lHeight + rHeight, Math.max(lDiameter, rDiameter));
	}

	private static int getHeight(BinaryTree tree) {
		if (tree == null) {
			return 0;
		}
		int lHeight = getHeight(tree.left);
		int rHeight = getHeight(tree.right);
		return 1 + Math.max(lHeight, rHeight);
	}
}
