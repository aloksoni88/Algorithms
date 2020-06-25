/**
 * 
 */
package com.alok.tree;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class PreorderTraversal {
private static Node root;
	
	private static void preorderTraversal(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	private static void preorderTraversalInterative() {
		if(root == null) {
			System.out.println("tree is empty");
			return;
		}
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(current);
		while(current != null || !stack.isEmpty()) {
			current = stack.pop();
			if(current != null) {
				System.out.print(current.value + " ");
				stack.push(current.right);
				stack.push(current.left);
			}
		}
	}
	
	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
//		preorderTraversal(root);
		preorderTraversalInterative();
		
	}
}
