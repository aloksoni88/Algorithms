/**
 * 
 */
package com.alok.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;



/**
 * @author Alok Soni
 *
 */
public class BinaryTreeDeletion {
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
	
	private static void deleteItem(int item) {
		if(isEmpty()) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Node current = root;
		queue.add(current);
		Node delete_node = null;
		while(!queue.isEmpty()) {
			current = queue.remove();
			if(delete_node == null && current.value == item) {
				delete_node = current;
			}
			
			if(current.left != null) {
				queue.add(current.left);
			}
			
			if(current.right != null) {
				queue.add(current.right);
			}
		}
		
		
		if(delete_node == null) {
			System.out.println("item not found to delete");
		}else {
			delete_node.value = current.value;
			deleteLastNode(delete_node, current);
		}
	}
	
	private static void deleteLastNode(Node deleted_node,Node lastNode) {
		Queue<Node> queue = new LinkedList<Node>();
		Node current = root;
		queue.add(current);
		while(!queue.isEmpty()) {
			current = queue.remove();
			
			if(current != null &&  current.left  == lastNode) {
				current.left = null;
				return;
			}else if(current != null && current.right == lastNode) {
				current.right = null;
				return;
			}
			
			if(current.left != null) {
				queue.add(current.left);
			}
			
			if(current.right != null) {
				queue.add(current.right);
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
		root.left.right = new Node(12);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		System.out.println(display());
		
		deleteItem(10);
		
		System.out.println(display());
		
	}
}
