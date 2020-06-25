package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTree {
	public static Node node;
	
	public static void insertItem(Node tmp,int data){
		if(tmp == null){
			tmp = new Node(data);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(tmp);
		while(!q.isEmpty()){
			tmp = q.remove();
			if(tmp.left == null){
				tmp.left = new Node(data);
				break;
			}else{
				q.add(tmp.left);
			}
			
			if(tmp.right == null){
				tmp.right = new Node(data);
				break;
			}
		}
	}
	
	public static Node deleteItem(int data){
		if(node == null){
			System.out.println("Tree is empty");
			return node;
		}
		if(node.key == data && node.left == null && node.right == null){
			System.out.println("Only 1 item in tree which is root, root node deleted");
			node = null;
			return node;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		Node tmp = node;
		Node delete_node = null;
		while(!q.isEmpty()){
			tmp = q.remove();
			if(tmp.key == data){
				delete_node = tmp;
			}
			if(tmp.left != null){
				q.add(tmp.left);
			}
			if(tmp.right != null){
				q.add(tmp.right);
			}
		}
		int x = tmp.key;
		if(delete_node != null){
			deleteDeepestNode(node, tmp);
			delete_node.key = x;
		}else{
			System.out.println("deletion item not found");
		}
		return node;
	}
	
	public static void deleteDeepestNode(Node root, Node deepestNode){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			root = q.remove();
			if(deepestNode == root){
				root = null;
				return;
			}
			if(root.left != null){
				if(root.left == deepestNode){
					root.left = null;
					return;
				}else{
					q.add(root.left);
				}
			}
			if(root.right != null){
				if(root.right == deepestNode){
					root.right = null;
					return;
				}else{
					q.add(root.right);
				}
			}
		}
	}
	
	public static void displayTree(Node node){
		if(node == null){
			System.out.println("Tree is null");
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty()){
			Node tmp = q.remove();
			System.out.print(tmp.key + " ");
			if(tmp.left != null){
				q.add(tmp.left);
			}
			if(tmp.right != null){
				q.add(tmp.right);
			}
		}
	}
	
	
	public static void main(String[] args) {
		node = new Node(1);
		insertItem(node,2);
		insertItem(node,3);
		insertItem(node,4);
		insertItem(node,5);
		insertItem(node,6);
		insertItem(node,7);
		displayTree(node);
		
		deleteItem(3);
		System.out.println();
		displayTree(node);
		
		System.out.println();
		deleteItem(10);
		System.out.println();
		displayTree(node);
	}
}
