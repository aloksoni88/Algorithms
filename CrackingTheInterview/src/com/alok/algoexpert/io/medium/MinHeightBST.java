package com.alok.algoexpert.io.medium;

import java.util.List;

public class MinHeightBST {
	public static BST minHeightBst(List<Integer> array) {

		return minHeight(array, 0, array.size() - 1);
	}

	private static BST minHeight(List<Integer> list, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			BST bst = new BST(list.get(mid));
			bst.left = minHeight(list, low, mid - 1);
			bst.right = minHeight(list, mid + 1, high);
			return bst;
		} else {
			return null;
		}

	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
}
