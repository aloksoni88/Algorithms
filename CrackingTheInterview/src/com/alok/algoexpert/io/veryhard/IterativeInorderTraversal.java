/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.function.Function;

/**
 * @author Alok Soni
 *
 */
public class IterativeInorderTraversal {
	public static void main(String[] args) {

	}

	public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
		
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
