/**
 * 
 */
package com.alok.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alok Soni
 *
 */
public class MinimalTree {
	
	private class Node{
		private int value;
		private Node left;
		private Node right;
		Node(int value){
			this.value = value;
		}
	}
	private Node node;
	
	public Node createMinimalTree(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Array is empty");
			return null;
		}
		if(arr.length == 1) {
			return new Node(arr[0]);
		}
		return minimalSubtree(arr, 0, arr.length-1);
	}
	
	private Node minimalSubtree(int[] arr, int start, int end) {
		if(arr == null || start > end) {
			return null;
		}
		int mid = (start + end)/2;
//		if(node == null) {
//			node = new Node(arr[mid]); 
//		}else {
//			return new Node(arr[mid]);	
//		}
		Node node = new Node(arr[mid]);
		node.left = minimalSubtree(arr, start, mid-1);
		node.right = minimalSubtree(arr, mid+1, end);
		return node;
	}
	
	private void display(Node node) {
		System.out.println("Level order");
		if(node == null) {
			System.out.println("[]");
		}else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);
			while(!queue.isEmpty()) {
				Node n = queue.remove();
				if(n != null) {
					System.out.print (n.value + " ");
				}
				if(n.left != null) {
					queue.add(n.left);
				}
				if(n.right != null) {
					queue.add(n.right);
				}
			}
		}
		
		System.out.println();
		System.out.println("inorder");
		inorder(node);
		
		System.out.println();
		System.out.println("preorder");
		preorder(node);
		
		System.out.println();
		System.out.println("postorder");
		postorder(node);
	}
	
	
	private void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);;
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	
	private void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preorder(node.left);;
		preorder(node.right);
	}
	
	private void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + " ");
	}
	
	public static void main(String[] args) {
		MinimalTree tree = new MinimalTree();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Node node = tree.createMinimalTree(arr);
		tree.display(node);
	}
}
