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
public class MirrorTree {
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
	
	private static boolean isMirror(Node left, Node right) {
		if(left == null && right == null) {
			return true;
		}else if(left != null && right == null) {
			return false;
		}else if(right != null && left == null) {
			return false;
		}else if(left != null && right != null && left.value != right.value) {
			return false;
		}else {
			return isMirror(left.left, right.right);
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
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
//		root.left.left = new Node(3);
		root.left.right = new Node(3);
//		root.right.left = new Node(4);
		root.right.right = new Node(3);
		
		
		boolean isMirror = isMirror(root.left,root.right);
		
		System.out.println(isMirror);
		System.out.println(display());
	}
}
