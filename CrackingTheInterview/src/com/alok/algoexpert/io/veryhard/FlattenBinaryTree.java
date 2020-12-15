/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class FlattenBinaryTree {
	public static void main(String[] args) {
		FlattenBinaryTree.BinaryTree tree = new FlattenBinaryTree.BinaryTree(1);
		tree.left = new FlattenBinaryTree.BinaryTree(2);
		tree.right = new FlattenBinaryTree.BinaryTree(3);
		tree.right.left = new FlattenBinaryTree.BinaryTree(6);
		tree.left.left = new FlattenBinaryTree.BinaryTree(4);
		tree.left.right = new FlattenBinaryTree.BinaryTree(5);
		tree.left.right.left = new FlattenBinaryTree.BinaryTree(7);
		tree.left.right.right = new FlattenBinaryTree.BinaryTree(8);

		flattenBinaryTree(tree);
	}

	// Time - O(n)
	// Space - O(d) where d is the depth(height) of binary tree
	// where n is the number of element in tree
	//if tree is balanced then the space complexity is O(log(n))
	public static BinaryTree flattenBinaryTree(BinaryTree root) {
		if (root == null) {
			return root;
		}
		BinaryTree leftMostNode = flattenTree(root)[0];
		return leftMostNode;
	}
	
	private static BinaryTree[] flattenTree(BinaryTree root) {
		BinaryTree leftMost;
		BinaryTree rightMost;
		if(root.left == null) {
			leftMost = root;
		}else {
			BinaryTree[] leftNRightMostNodes = flattenTree(root.left);
			connectNode(leftNRightMostNodes[1], root);
			leftMost = leftNRightMostNodes[0];
		}
		
		if(root.right == null) {
			rightMost = root;
		}else {
			BinaryTree[] leftNRightMostNodes = flattenTree(root.right);
			connectNode(root, leftNRightMostNodes[0]);
			rightMost = leftNRightMostNodes[1];
		}
		return new BinaryTree[] {leftMost, rightMost};
	}
	
	private static void connectNode(BinaryTree left, BinaryTree right) {
		left.right = right;
		right.left = left;
	}

	/***************************************************/
	// Time - O(n)
	// Space - O(n)
	// where n is the number of element in tree
	public static BinaryTree flattenBinaryTree2(BinaryTree root) {
		if (root == null) {
			return root;
		}
		List<BinaryTree> list = new ArrayList<>();
		list = inorderTraversal(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			BinaryTree left = list.get(i);
			BinaryTree right = list.get(i + 1);
			left.right = right;
			right.left = left;
		}
		return list.get(0);
	}

	private static List<BinaryTree> inorderTraversal(BinaryTree root, List<BinaryTree> list) {
		if (root != null) {
			inorderTraversal(root.left, list);
			list.add(root);
			inorderTraversal(root.right, list);
		}
		return list;
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
