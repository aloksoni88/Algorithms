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
		getBranchSum(root, 0, map,root);
		List<Integer> list = new ArrayList<Integer>(map.values());
		return list;

	}

	private static void getBranchSum(BinaryTree root, int sum,
			LinkedHashMap<Integer, Integer> map, BinaryTree node) {
		if (root == null) {			
			return ;
		}
		int newSum = sum + root.value;
		if ( node.left == null && node.right == null) {
				map.put(node.value, newSum);
				return;
		}
		getBranchSum(root.left, newSum, map, root);
		getBranchSum(root.right, newSum, map, root);		

	}
}
