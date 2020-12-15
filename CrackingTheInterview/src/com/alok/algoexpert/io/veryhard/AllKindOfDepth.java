/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class AllKindOfDepth {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.left = new BinaryTree(2);
		tree.right = new BinaryTree(3);
		tree.left.left = new BinaryTree(4);
		tree.left.right= new BinaryTree(5);
		tree.left.left.left = new BinaryTree(8);
		tree.left.left.right= new BinaryTree(9);
		tree.right.left = new BinaryTree(6);
		tree.right.right = new BinaryTree(7);
		
		int allDepth = allKindsOfNodeDepths(tree);
		System.out.println(allDepth);
		
	}
	
	/************* Better Solution *********************/
	//Time - O(n) for balanced tree 
	//Space - O(n) 
	//n is the number of element 
	public static int allKindsOfNodeDepths(BinaryTree root) {
		return getAllNodeDepts(root, 0,0);
	}
	
	private static int getAllNodeDepts(BinaryTree root, int depthSum, int depth) {
		if(root == null) {
			return 0;
		}
		depthSum = depthSum + depth;
		return depthSum + getAllNodeDepts(root.left, depthSum,depth+1) 
						+ getAllNodeDepts(root.right, depthSum,depth+1);
	}
	
	
	/************* Better Solution *********************/
	//Time - O(n) for balanced tree 
	//Space - O(n) 
	//n is the number of element 
	public static int allKindsOfNodeDepths2(BinaryTree root) {
		HashMap<BinaryTree, Integer> nodeCounts = new HashMap<>();
		HashMap<BinaryTree, Integer> nodeDepths = new HashMap<>();
		addNodeCounts(root, nodeCounts);
		addNodeDepths(root, nodeDepths, nodeCounts);
		return sumAllNodeDepts(root, nodeDepths);
	}
	
	private static int sumAllNodeDepts(BinaryTree root, HashMap<BinaryTree, Integer> nodeDepths) {
		if(root == null) {
			return 0;
		}
		return sumAllNodeDepts(root.left, nodeDepths)
				+ sumAllNodeDepts(root.right, nodeDepths)
				+ nodeDepths.get(root);
	}
	
	private static void addNodeCounts(BinaryTree root, HashMap<BinaryTree, Integer> nodeCounts) {
		nodeCounts.put(root, 1);
		if(root.left != null) {
			addNodeCounts(root.left, nodeCounts);
			nodeCounts.put(root,nodeCounts.get(root) + nodeCounts.get(root.left));
		}
		if(root.right != null) {
			addNodeCounts(root.right, nodeCounts);
			nodeCounts.put(root, nodeCounts.get(root)+ nodeCounts.get(root.right));
		}
	}
	
	private static void addNodeDepths(BinaryTree root, HashMap<BinaryTree, Integer> nodeDepths, 
				HashMap<BinaryTree, Integer> nodeCounts) {
		nodeDepths.put(root, 0);
		if(root.left != null) {
			addNodeDepths(root.left, nodeDepths, nodeCounts);
			nodeDepths.put(root, nodeDepths.get(root) + nodeDepths.get(root.left) + nodeCounts.get(root.left));
		}
		if(root.right != null) {
			addNodeDepths(root.right, nodeDepths, nodeCounts);
			nodeDepths.put(root, nodeDepths.get(root) + nodeDepths.get(root.right) + nodeCounts.get(root.right));
		}
	}
	
	/*********** Iterative solution ********************/
	//Time - O(nlog(n)) for balanced tree and O(n^2) for skewed binary tree
	//Space - O(h) for balanced tree and O(n) for skewed binary tree
	//n is the number of element and h is the height of binary tree
	public static int allKindsOfNodeDepths3(BinaryTree root) {
		if(root == null) {
			return 0;
		}
		int sumOfAllDepths = 0;
		Stack<BinaryTree> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			BinaryTree node = stack.peek();
			stack.pop();
			if(node == null) {
				continue;
			}
			sumOfAllDepths = sumOfAllDepths +  getAllNodeDepts(node, 0);
			stack.add(node.left);
			stack.add(node.right);
		}
		return sumOfAllDepths;
	}
	
	
	/*********** Recursive solution ********************/
	//Time - O(nlog(n)) for balanced tree and O(n^2) for skewed binary tree
	//Space - O(h) for balanced tree and O(n) for skewed binary tree
	//n is the number of element and h is the height of binary tree
	public static int allKindsOfNodeDepthsRecursive(BinaryTree root) {
		if(root == null) {
			return 0;
		}
		return allKindsOfNodeDepthsRecursive(root.left) 
				+ allKindsOfNodeDepthsRecursive(root.right)
				+ getAllNodeDepts(root, 0);
	}
	
	private static int getAllNodeDepts(BinaryTree root,int depth) {
		if(root == null) {
			return 0;
		}
		return depth + getAllNodeDepts(root.left, depth+1) + getAllNodeDepts(root.right, depth+1);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
