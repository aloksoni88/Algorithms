/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class RightSmallerThan {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(8, 5, 11, -1, 3, 4, 2));
		ArrayList<Integer> result = (ArrayList<Integer>) rightSmallerThan2(list);
		System.out.println(result);
	}

	/**
	 * AverageCase 
	 * Time - O(nlog(n)), Space - O(n)
	 * worst case 
	 * Time - O(n^2), Space- o(n) 
	 * n is the number of element in array
	 **/
	public static List<Integer> rightSmallerThan2(List<Integer> array) {
		if (array == null || array.isEmpty()) {
			return array;
		}
		int lastIndex = array.size() - 1;
		BinarySearchTree bst = new BinarySearchTree(array.get(lastIndex), lastIndex, 0);
		for (int i = lastIndex - 1; i >= 0; i--) {
			bst.insert(array.get(i), i);
		}
		List<Integer> rightSmallerCounts = new ArrayList<>(array);
		getRightSmallerCounts(bst, rightSmallerCounts);
		return rightSmallerCounts;
	}

	private static void getRightSmallerCounts(BinarySearchTree bst, List<Integer> rightSmallerCounts) {
		if (bst == null) {
			return;
		}
		rightSmallerCounts.set(bst.index, bst.currentRightSmallerCount);
		getRightSmallerCounts(bst.left, rightSmallerCounts);
		getRightSmallerCounts(bst.right, rightSmallerCounts);
	}

	// Time - O(n^2) Space - O(n) where n is the length of element in list
	public static List<Integer> rightSmallerThan(List<Integer> array) {
		if (array == null || array.isEmpty()) {
			return array;
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < array.size() - 1; i++) {
			int count = 0;
			for (int j = i + 1; j < array.size(); j++) {
				if (array.get(i) > array.get(j)) {
					count++;
				}
			}
			result.add(count);
		}
		result.add(0);
		return result;
	}

}

class BinarySearchTree {
	public int value;
	public int index;
	public int leftItemCount;
	public int currentRightSmallerCount;
	public BinarySearchTree left;
	public BinarySearchTree right;

	public BinarySearchTree(int value, int index, int currentRightSmallerCount) {
		this.value = value;
		this.index = index;
		this.currentRightSmallerCount = currentRightSmallerCount;
		leftItemCount = 0;
		left = null;
		right = null;
	}

	public void insert(int value, int index) {
		insertHelper(value, index, 0);
	}

	private void insertHelper(int value, int index, int currentRightSmallerCount) {
		if (value < this.value) {
			leftItemCount++;
			if (left == null) {
				left = new BinarySearchTree(value, index, currentRightSmallerCount);
			} else {
				left.insertHelper(value, index, currentRightSmallerCount);
			}
		} else {
			currentRightSmallerCount = currentRightSmallerCount + leftItemCount;
			if (value > this.value) {
				currentRightSmallerCount++;
			}
			if (right == null) {
				right = new BinarySearchTree(value, index, currentRightSmallerCount);
			} else {
				right.insertHelper(value, index, currentRightSmallerCount);
			}
		}
	}
}
