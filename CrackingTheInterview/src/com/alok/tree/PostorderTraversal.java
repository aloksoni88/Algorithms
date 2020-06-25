/**
 * 
 */
package com.alok.tree;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class PostorderTraversal {
private static Node root;
	
	private static void postorderTraversal(Node node) {
		if(node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.value + " ");
	}
	
	private static void postorderTraversalIterative() {
		if(root == null) {
			System.out.println("tree is empty");
			return;
		}
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		int top = current.value;
		Stack<Node> postOrderStack = new Stack<Node>();
		stack.push(current);
		while(!stack.isEmpty()) {
			current = stack.pop();
			if(current != null) {
				if(current.left != null) {
					stack.push(current.left);
				}
				if(current.right != null) {
					stack.push(current.right);
				}
				postOrderStack.push(current);
			}
		}
		while(!postOrderStack.isEmpty()) {
			System.out.print(postOrderStack.pop().value + " ");
		}
	
	}

	
	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
//		postorderTraversal(root);
		postorderTraversalIterative();
		
	}
}
