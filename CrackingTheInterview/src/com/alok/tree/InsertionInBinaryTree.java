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
public class InsertionInBinaryTree {
	private static class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node() {
			
		}
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static boolean isEmpty() {
		return root == null;
	}
	
	private static Node root;
	
	private static void insertionInBinaryTreeLevelOrder(int item) {
		Node node = new Node(item);
		if(isEmpty()) {
			System.out.println("tree was empty,item added at root");
			root = node;
			return;
		}else {
			Queue<Node> queue = new LinkedList<Node>();
			//Node current = root;
			queue.add(root);
			while(!queue.isEmpty()) {
				Node current = queue.remove();
				
				if(current.left == null) {
					current.left = node;
					break;
				}else {
					queue.add(current.left);
				}
				
				if(current.right == null) {
					current.right = node;
					break;
				}else {
					queue.add(current.right);
				}
			}
		}
	}
	
	
	public static String display() {
		if(isEmpty()) {
			return "[]";
		}else {
			Queue<Node> queue = new LinkedList<Node>();
			Node current = root;
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
	
	
	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		System.out.println(display());
		
		insertionInBinaryTreeLevelOrder(12);
		
		System.out.println(display());
	}
}
