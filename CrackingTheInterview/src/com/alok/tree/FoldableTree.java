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
public class FoldableTree {
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
	
	private static boolean isFoldable(Node a, Node b) {
		if(a == null && b == null) {
			return true;
		}else if(a == null && b != null) {
			return false;
		}else if(b == null && a != null) {
			return false;
		}else {
			return isFoldable(a.left,b.right);
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
		root = new Node(4);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(8);
		root.right.left = new Node(5);
		root.right.right = new Node(9);
		
		System.out.println(display());
		if(root == null || (root.left == null && root.right == null)) {
			System.out.println(true);
			return;
		}else if(root.left == null && root.right != null) {
			System.out.println(false);
			return;
		}else if(root.right == null && root.left != null) {
			System.out.println(false);
			return;
		}
		
		boolean isFoldable = isFoldable(root.left,root.right);
		
		System.out.println(isFoldable);
		System.out.println(display());
	}
}
