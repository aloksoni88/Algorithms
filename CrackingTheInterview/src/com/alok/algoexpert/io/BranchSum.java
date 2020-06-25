/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class BranchSum {
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
		if (root == null) {
			return null;	
		}
		List<Integer> list = new ArrayList<>();
		if (root.left == null && root.right == null) {
			list.add(root.value);
			return list;
		}
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		map = getBranchSum(root, 0, map,root);
		list = new ArrayList<Integer>(map.values());
		return list;

	}

	private static LinkedHashMap<Integer, Integer> getBranchSum(BinaryTree root, int sum,
			LinkedHashMap<Integer, Integer> map, BinaryTree node) {
		if (root == null) {
			if (!map.containsKey(node.value) && node.left == null && node.right == null) {
				map.put(node.value, sum);
			}
			sum = 0;
			return map;
		}
		sum = sum + root.value;
		map = getBranchSum(root.left, sum, map, root);
		map = getBranchSum(root.right, sum, map, root);
		return map;

	}
}
