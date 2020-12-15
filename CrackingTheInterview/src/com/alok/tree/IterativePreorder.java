/**
 * 
 */
package com.alok.tree;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class IterativePreorder {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		preorderTraversal(root);
	}
	
	private static void preorderTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		stack.push(current);
		while(stack.size() != 0) {
			current = stack.peek();
			System.out.print(current.value + " ");
			stack.pop();
			
			if(current.right != null) {
				stack.push(current.right);
			}
			if(current.left != null) {
				stack.push(current.left);
			}
		}
	}
}

