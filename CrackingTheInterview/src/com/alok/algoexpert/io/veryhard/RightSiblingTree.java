/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

/**
 * @author Alok Soni
 *
 */
public class RightSiblingTree {

	public static BinaryTree rightSiblingTree(BinaryTree root) {
		rightSiblingTree(root, null, false);
		return root;
	}
	
	//Time - O(n)
	//Space - O(d) 
	//where n is the number of element and d is the depth of tree
	private static void rightSiblingTree(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
		if(node == null) {
			return;
		}
		BinaryTree leftChild = node.left;
		BinaryTree rightChild = node.right;
		rightSiblingTree(leftChild, node, true);
		if(parent == null) {
			node.right = null;
		}else if(isLeftChild) {
			node.right = parent.right;
		}else if(parent.right != null) {
			node.right = parent.right.left;
		}else {
			node.right = null;
		}	
		rightSiblingTree(rightChild,node, false);
	}

	// This is the class of the input root. Do not edit it.
	static class BinaryTree {
		int value;
		BinaryTree left = null;
		BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
