package com.alok.algoexpert.io;

import com.alok.algoexpert.io.BSTConstruction.BST;

public class ValidateBST {
	public static void main(String[] args) {
		BST bst = new BST(10);
		bst.left = new BST(5);
		bst.right = new BST(15);
		bst.left.right = new BST(10);
		bst.display(bst);
		System.out.println();
		boolean result = validateBst(bst);
		System.out.println(result);
	}

	
	public static boolean validateBst(BST tree) {
		if (tree == null || (tree.left == null && tree.right == null)) {
			return true;
		}

		return isValidate(tree,Integer.MIN_VALUE, Integer.MAX_VALUE);
		//return isValidate(tree);
	}

	private static boolean isValidate(BST tree, int min, int max) {
		if (tree == null) {
			return true;
		}
		if (tree.value < min || tree.value > max) {
			return false;
		}
		boolean isValid = isValidate(tree.left, min, tree.value - 1);
		isValid = isValid ? isValidate(tree.right, tree.value, max) : false;
		return isValid;
	}

	private static BST prevNode = null;
	private static boolean isValidate(BST tree) {
		if (tree == null) {
			return true;
		}
		boolean isValid = isValidate(tree.left);
		if (!isValid) {
			return false;
		}
		if (prevNode != null && prevNode.value >= tree.value) {
			return false;
		}
		prevNode = tree;
		return isValid ? isValidate(tree.right) : false;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
		
		public void display(BST node) {
			if(node == null) {
				return;
			}
			display(node.left);
			System.out.print(node.value + " ");
			display(node.right);
		}
	}
}
