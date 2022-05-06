/**
 * 
 */
package com.alok.algoexpert.io.easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class BranchSum {
	
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
		
		List<Integer> list = branchSums(tree);
		System.out.println(list);
	}
	
	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static List<Integer> branchSums(BinaryTree root) {		
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		getBranchSum(root, 0, map);
		List<Integer> list = new ArrayList<Integer>(map.values());
		return list;

	}

	private static void getBranchSum(BinaryTree root, int sum,
			LinkedHashMap<Integer, Integer> map) {
		if (root == null) {			
			return ;
		}
		int newSum = sum + root.value;
		if ( root.left == null && root.right == null) {
				map.put(root.value, newSum);
				return;
		}
		getBranchSum(root.left, newSum, map);
		getBranchSum(root.right, newSum, map);		

	}
}
