package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alok.algoexpert.io.medium.BSTConstruction.BST;

public class BSTTraversal {
	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
		if (tree == null) {
			return array;
		}
		inOrderTraverse(tree.left, array);
		array.add(tree.value);
		inOrderTraverse(tree.right, array);
		return array;
	}

	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		if (tree == null) {
			return array;
		}
		array.add(tree.value);
		preOrderTraverse(tree.left, array);
		preOrderTraverse(tree.right, array);
		return array;
	}

	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		if (tree == null) {
			return array;
		}
		postOrderTraverse(tree.left, array);
		postOrderTraverse(tree.right, array);
		array.add(tree.value);
		return array;
	}
	
	public static List<Integer> levelOrderTraversal(BST tree, List<Integer> array){
		if(tree == null) {
			return array;
		}
		Queue<BST> queue = new LinkedList<BST>();
		queue.add(tree);
		
		while(!queue.isEmpty()) {
			BST current = queue.poll();
			array.add(current.value);
			
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
		return array;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
		
		public BST insert(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			BST current = this;
			while (current != null) {
				if (current.value > value) {
					if (current.left == null) {
						current.left = new BST(value);
						break;
					}
					current = current.left;
				} else if (current.value <= value) {
					if (current.right == null) {
						current.right = new BST(value);
						break;
					}
					current = current.right;
				}
			}
			return this;
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(2);
		bst.insert(5);
		bst.insert(22);
		bst.insert(1);
		
	
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(BSTTraversal.inOrderTraverse(bst, list));
		list.clear();
		System.out.println(BSTTraversal.preOrderTraverse(bst, list));
		list.clear();
		System.out.println(BSTTraversal.postOrderTraverse(bst, list));
		list.clear();
		System.out.println(BSTTraversal.levelOrderTraversal(bst, list));
	}
}
