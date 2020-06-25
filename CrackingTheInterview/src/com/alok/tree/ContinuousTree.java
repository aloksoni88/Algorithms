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
public class ContinuousTree {
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
	

	private static boolean isContinuousTree(Node root) {
		if(root == null) {
			return true;
		}else if(root.left == null && root.right == null) {
			return true;
		}else {
			if(root.left == null) {
				return  Math.abs((root.value - root.right.value)) == 1 && isContinuousTree(root.right);
			}
			if(root.right == null) {
				return Math.abs((root.value - root.left.value)) == 1 && isContinuousTree(root.left);
			}
			return ( Math.abs(root.value - root.left.value) == 1 && Math.abs(root.value - root.right.value) == 1)
						&& isContinuousTree(root.left) && isContinuousTree(root.right);		
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
//		root.left.left = new Node(8);
//		root.left.right = new Node(5);
//		root.right.right = new Node(9);
		
		System.out.println(display());
		
		boolean isContiuousTree = isContinuousTree(root);
		
		System.out.println(isContiuousTree);
		System.out.println(display());
	}
}
