/**
 * 
 */
package com.alok.algoexpert.io.easy;

/**
 * @author Alok Soni
 *
 */
public class NodeDepth {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.left = new BinaryTree(2);
	    tree.right = new BinaryTree(3);

	    tree.left.left = new BinaryTree(4);
	    tree.left.right = new BinaryTree(5);
	    tree.right.left = new BinaryTree(6);
	    tree.right.right = new BinaryTree(7);

	    tree.left.left.left = new BinaryTree(8);
	    tree.left.left.right = new BinaryTree(9);
	    tree.left.right.left = new BinaryTree(10);
	    
	    int nodeDepth = nodeDepths(tree);
	    System.out.println(nodeDepth);
	}
	
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
