/**
 * 
 */
package com.alok.tree;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class IterativeInorder {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		inorderTraversal(root);
	}
	
	private static void inorderTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		while(current != null || stack.size() != 0) {
			
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.value + " ");
			
			current = current.right;
		}
	}
}

