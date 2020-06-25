package com.datastructure;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
	
	Node root;
	
	class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node insertData(Node root, int data){
		if(root == null){
			root = new Node(data);
		}else if(data < root.data){
			root.left = insertData(root.left, data);
		}else if(data > root.data){
			root.right = insertData(root.right,data);
		}
		return root;
	}
	
	private void traverseInorderWithourRecurrsin(Node root){
		if(root != null){
			Stack<Node> stack = new Stack<Node>();
			Node currentNode = root;
			while(stack.size() != 0 || currentNode != null){
				if(currentNode != null){
					stack.push(currentNode);
					currentNode = currentNode.left;
				}else{
					Node node = stack.pop();
					System.out.print(" " + node.data);
					currentNode = node.right;
				}
			}
		}
	}
	
	private void traverseInorder(Node root){
		if(root != null){
			traverseInorder(root.left);
			System.out.print(" "+root.data);
			traverseInorder(root.right);
		}
	}
	
	private void traversePreorderWithourRecurrsin(Node root){
		if(root != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while(stack.size() != 0){
				Node node = stack.pop();
				System.out.print(" "+node.data);
				if(node.right != null){
					stack.push(node.right);
				}
				if(node.left != null){
					stack.push(node.left);
				}
			}
		}
	}
	
	private void traversePreorder(Node root){
		if(root != null){
			System.out.print(" "+root.data);
			traversePreorder(root.left);
			traversePreorder(root.right);
		}
	}
	
	private void traversePostorderWithourRecurrsin(Node root){
		if(root != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while(stack.size() != 0){
				Node currentNode = stack.peek();
				boolean isLeaf = currentNode.left == null && currentNode.right == null;
				boolean finishedSubtree = currentNode.left == root || currentNode.right == root;
				if( isLeaf || finishedSubtree){
					System.out.print(" " + currentNode.data);
					stack.pop();
					root = currentNode;
				}else{
					if(currentNode.right != null){
						stack.push(currentNode.right);
					}
					if(currentNode.left != null){
						stack.push(currentNode.left);
					}
				}
			}
		}	
	}
	
	private void traversePostorder(Node root){
		if(root != null){
			traversePostorder(root.left);
			traversePostorder(root.right);
			System.out.print(" "+root.data);
		}
	}
	
	private void traverseTree(){
		System.out.println("Inorder traversal");
		traverseInorder(root);
		System.out.println();
		System.out.println("Inorder traversal without recurrsion");
		traverseInorderWithourRecurrsin(root);
		System.out.println();
		System.out.println("Preorder traversal");
		traversePreorder(root);
		System.out.println();
		System.out.println("Preorder traversal without recurrsion");
		traversePreorderWithourRecurrsin(root);
		System.out.println();
		System.out.println("Postorder traversal");
		traversePostorder(root);
		System.out.println();
		System.out.println("Postorder traversal without recurrsion");
		traversePostorderWithourRecurrsin(root);
		System.out.println();
	}
	
	private void add(int data){
		root = insertData(root,data);
	}
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(10);
		tree.add(5);
		tree.add(12);
		tree.add(3);
		tree.add(7);
		tree.add(11);
		tree.add(13);
		tree.traverseTree();
	}
	
}
