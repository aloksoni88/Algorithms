package com.alok.algoexpert.io.medium;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	public static void invertBinaryTree(BinaryTree tree) {
		if (tree == null) {
			return;
		}
		invertBST(tree);
	}

	private static BinaryTree invertBST(BinaryTree tree) {
		if (tree == null) {
			return null;
		}
		BinaryTree tmp = tree.right;
		tree.right = invertBST(tree.left);
		tree.left = invertBST(tmp);
		return tree;
	}
	
	private static void mirrorTree(BinaryTree tree) {
		if(tree == null) {
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			BinaryTree current = queue.poll();
			
			BinaryTree tmp = current.left;
			current.left = current.right;
			current.right = tmp;
			
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	public void insert(int value) {
		BinaryTree binaryTree = new BinaryTree(value);
		if(root == null) {
			root = binaryTree;
		}else {
			Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryTree current = queue.remove();
				if(current.left == null) {
					current.left = binaryTree;
					break;
				}
				queue.add(current.left);
				
				if(current.right == null) {
					current.right = binaryTree;
					break;
				}
				queue.add(current.right);
			}
		}
	}

	BinaryTree root;
	 class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		InvertBinaryTree binaryTree = new InvertBinaryTree();
		binaryTree.insert(5);
		binaryTree.insert(15);
		binaryTree.insert(2);
		binaryTree.insert(5);
		binaryTree.insert(22);
		binaryTree.insert(1);
		
		System.out.println(binaryTree);
		System.out.println();
		System.out.println("Invert Binary tree");
//		invertBinaryTree(binaryTree.root);
		mirrorTree(binaryTree.root);
		System.out.println();
		System.out.println(binaryTree);
//		levelOrderTraversal(binaryTree);
	}
	
	@Override
	public String toString() {
		if(root == null) {
			return "[]";
		}else {
			Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
			BinaryTree current = root;
			queue.add(current);
			String str = "[";;
			while(!queue.isEmpty()) {
				current = queue.remove();
				str = str + current.value + ", ";
				if(current.left != null) {
					queue.add(current.left);
				}
				
				if(current.right != null) {
					queue.add(current.right);
				}
			}
			str = str.substring(0,str.length()-2) + "]";
			return str;
		}
	}
	
	public static void levelOrderTraversal(BinaryTree tree){
		if(tree == null) {
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(tree);
		
		while(!queue.isEmpty()) {
			BinaryTree current = queue.poll();
			System.out.print(current.value + " ");
			
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
	}
}
