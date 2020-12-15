/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Alok Soni
 *
 */
public class IterativeInorderTraversal {
	public static List<Integer> testArray = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2, root);
		root.left.left = new BinaryTree(4, root.left);
		root.left.left.right = new BinaryTree(9, root.left.left);
		root.right = new BinaryTree(3, root);
		root.right.left = new BinaryTree(6, root.right);
		root.right.right = new BinaryTree(7, root.right);

		iterativeInOrderTraversal(root, IterativeInorderTraversal::testCallback);
		System.out.println(testArray);
		
	}

	public static Void  testCallback(BinaryTree tree) {
		if (tree == null) {
			return null;
		}
		testArray.add(tree.value);
		return null;
	}

	// Time - O(n)
	// Space - O(1)
	// where n is the number of node in tree
	public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
		if (tree == null) {
			return;
		}
		BinaryTree previous = null;
		BinaryTree current = tree;

		while (current != null) {
			BinaryTree next;

			if (previous == null || previous == current.parent) {
				if (current.left != null) {
					next = current.left;
				} else {
					callback.apply(current);
					next = current.right != null ? current.right : current.parent;
				}
			} else if (previous == current.left) {
				callback.apply(current);
				next = current.right != null ? current.right : current.parent;
			} else {
				next = current.parent;
			}
			previous = current;
			current = next;
		}
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		public BinaryTree parent;

		public BinaryTree(int value) {
			this.value = value;
		}

		public BinaryTree(int value, BinaryTree parent) {
			this.value = value;
			this.parent = parent;
		}
	}
}
