/**
 * 
 */
package com.alok.tree;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class IterativePostorder {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		//postOrderTraversal(root);
		postorderTraversal(root);
	}
	
	//using 1 stack
	private static void postorderTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		while(true){
			while(current != null) {
				stack.push(current);
				stack.push(current);
				current = current.left;
			}
			if(stack.isEmpty()) {
				return;
			}
			current = stack.pop();
			if(!stack.isEmpty() && stack.peek() == current) {
				current = current.right;
			}else {
				System.out.print(current.value + " ");
				current = null;
			}
		}
	}	
	
	//using 2 stack
	private static void postOrderTraversal(Node root) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		Node current = root;
		stack1.push(current);
		while(!stack1.isEmpty()) {
			current = stack1.peek();
			stack1.pop();
			
			stack2.push(current);
			
			if(current.left != null) {
				stack1.push(current.left);
			}
			if(current.right != null) {
				stack1.push(current.right);
			}
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().value + " ");
		}
	}
}

