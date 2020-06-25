/**
 * 
 */
package com.alok.tree;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class InorderTraversal {
	
	private static Node root;
	
	private static void inorderTraversal(Node node) {
		if(node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.print(node.value + " ");
		inorderTraversal(node.right);
	}
	
	private static void inorderTraversalInterative() {
		if(root == null) {
			System.out.println("tree is empty");
			return;
		}
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		
		while(current != null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}	
			
			current = stack.pop();
			System.out.print(current.value + " ");
			current = current.right;
		}
	
	}
	
	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		//inorderTraversal(root);
		inorderTraversalInterative();
		
	}
}
