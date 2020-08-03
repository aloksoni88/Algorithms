/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class MaxPathSumInBinaryTree {
	public static void main(String[] args) {

	}

	public static int maxPathSum(BinaryTree tree) {
		List<Integer> list = getMaxPathSum(tree);
		return list.get(1);
	}
	
	private static List<Integer> getMaxPathSum(BinaryTree tree){
		if(tree == null) {
			return new ArrayList<>(Arrays.asList(0,Integer.MIN_VALUE));
		}
		List<Integer> leftChildSum = getMaxPathSum(tree.left);
		Integer leftMaxBranch = leftChildSum.get(0);
		Integer leftMaxPathSum = leftChildSum.get(1);
		
		List<Integer> rightChildSum = getMaxPathSum(tree.right);
		Integer rigthMaxBranch = rightChildSum.get(0);
		Integer rightMaxPathSum = rightChildSum.get(1);
		
		Integer maxChildSumBranch = Math.max(leftMaxBranch, rigthMaxBranch);
		Integer maxSumBranch = Math.max(maxChildSumBranch+tree.value, tree.value);
		Integer maxSumTriangle = Math.max(maxSumBranch, leftMaxBranch + tree.value + rigthMaxBranch);
		
		Integer maxPathSum = Math.max(leftMaxPathSum, Math.max(maxSumTriangle, rightMaxPathSum));
		return new ArrayList<>(Arrays.asList(maxSumBranch,maxPathSum));
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
