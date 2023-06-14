/**
 * 
 */
package com.alok.algoexpert.io.medium;

import com.alok.algoexpert.io.medium.BinaryTreeDiameter.BinaryTree;

/**
 * @author Alok Soni
 *
 */
public class FindSuccessor {
	static boolean isFound = false;
	static BinaryTree result = null;
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.left = new BinaryTree(2);
		tree.left.parent = tree;
		tree.right = new BinaryTree(3);
		tree.right.parent = tree;
		tree.left.left = new BinaryTree(4);
		tree.left.left.parent = tree.left;
		tree.left.right = new BinaryTree(5);
		tree.left.right.parent = tree.left;
		tree.left.left.left = new BinaryTree(6);
		tree.left.left.left.parent = tree.left.left;
		
		BinaryTree node = tree.right;
		BinaryTree successor = findSuccessor2(tree, node);
		System.out.println(successor != null ? successor.value : null);
	}

	// Time - O(n) Space - O(h) 
	// where n is the no of node in the tree
	// h is the height of the tree 
	public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		inorderTraversal(tree, node);
		return result;
	}

	public static void inorderTraversal(BinaryTree tree, BinaryTree node) {
		if (tree == null) {
			return;
		}
		inorderTraversal(tree.left, node);
		if (isFound) {
			isFound = false;
			result = tree;
		}
		if (node.value == tree.value) {
			isFound = true;
		}

		inorderTraversal(tree.right, node);
	}
	
	//This method is only applicable if there is parent node is given for node
	//Time - O(h) , Space- O(1) where h is the height of tree(avg case)
	public static BinaryTree findSuccessor2(BinaryTree tree, BinaryTree node) {
		if(tree == null) {
			return null;
		}
		if(node.right != null) {
			return getLeftMostChild(node.right);
		}
		return getSuccessorUsingParent(node);
	}
	
	private static BinaryTree getLeftMostChild(BinaryTree node) {
		BinaryTree currentNode = node;
		while(currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;
	}
	
	private static BinaryTree getSuccessorUsingParent(BinaryTree node) {
		BinaryTree parent = node.parent;
		while(parent != null && parent.right == node) {
			parent = parent.parent;
		}
		return parent;
	}
	
	
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
		
	}
}
