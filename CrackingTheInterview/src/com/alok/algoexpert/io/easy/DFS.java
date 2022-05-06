/**
 * 
 */
package com.alok.algoexpert.io.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alok.algoexpert.io.easy.BranchSum.BinaryTree;

/**
 * @author Alok Soni
 *
 */
public class DFS {
	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> depthFirstSearch(List<String> array) {
			if (children == null) {
				return null;
			}
			return depthFirstSearchAlgo(array);
		}

		private List<String> depthFirstSearchAlgo(List<String> array) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(this);
			while (!stack.isEmpty()) {
				Node node = stack.pop();
				if (!array.contains(node.name)) {
					array.add(node.name);
				}
				List<Node> childrens = node.children;
				if (childrens != null && !childrens.isEmpty()) {
					for (int i = childrens.size() - 1; i >= 0; i--) {
						Node child = childrens.get(i);
						stack.push(child);
					}
				}
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}
	
	
	
	
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
		
		List<Integer> dfs = depthFirstSearch(tree);
		System.out.println(dfs);
		
	}
	
	private static List<Integer> depthFirstSearch(BinaryTree tree){
		List<Integer> list = new ArrayList<Integer>();
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		stack.push(tree);
		
		while(!stack.isEmpty()) {
			BinaryTree bTree = stack.pop();
			if(!list.contains(bTree.value)) {
				list.add(bTree.value);
			}
			
			if(bTree.right != null) {
				stack.push(bTree.right);
			}
			if(bTree.left != null) {
				stack.push(bTree.left);
			}
		}
		return list;
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
}
