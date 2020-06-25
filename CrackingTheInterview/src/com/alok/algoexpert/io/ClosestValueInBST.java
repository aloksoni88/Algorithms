/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class ClosestValueInBST {
	public static int findClosestValueInBst(BST tree, int target) {
		if (tree == null) {
			return -1;
		}
		if ((tree.left == null && tree.right == null) || tree.value == target) {
			return tree.value;
		}
		if (target < tree.value) {
			return getClosestValueInBST(tree.left, target, tree.value);
		} else {
			return getClosestValueInBST(tree.right, target, tree.value);
		}
	}

	private static int getClosestValueInBST(BST tree, int target, int closestValue) {
		if (tree == null) {
			return closestValue;
		}
		int currentValue = tree.value;
		if (Math.abs(target - closestValue) > Math.abs(target - currentValue)) {
			closestValue = currentValue;
		}
		closestValue = getClosestValueInBST(tree.left, target, closestValue);

		closestValue = getClosestValueInBST(tree.right, target, closestValue);
		return closestValue;
	}

	public static int findClosestValueInBstIterative(BST tree, int target) {
		if (tree == null) {
			return -1;
		}
		if ((tree.left == null && tree.right == null) || tree.value == target) {
			return tree.value;
		}
		int closestValue = tree.value;
		BST current = tree;
		while (current != null) {
			if (current.value == target) {
				return target;
			}
			if(target > current.value) {
				current = current.right;
			}else {
				current = current.left;
			}
			if (current != null && Math.abs(target - closestValue) > Math.abs(target - current.value)) {
				closestValue = current.value;
			} 
		}
		return closestValue;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		ClosestValueInBST tree = new ClosestValueInBST();
		BST bst = new BST(10);
		bst.left = new BST(5);
		bst.right = new BST(15);
		bst.left.left = new BST(2);
		bst.left.right = new BST(5);
		bst.left.left.left = new BST(1);
		
		bst.right.left = new BST(13);
		bst.right.right = new BST(22);
		bst.right.left.right = new BST(14);
		
		int closestValue = tree.findClosestValueInBstIterative(bst, 12);
		System.out.println(closestValue);
	}
}
