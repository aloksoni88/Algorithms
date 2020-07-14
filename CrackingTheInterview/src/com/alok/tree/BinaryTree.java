/**
 * 
 */
package com.alok.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.TreeSet;


/**
 * @author Alok Soni
 *
 */
public class BinaryTree {
	
	private class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	public Node root;
	private int size;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean add(int item) {
		Node node = new Node(item);
		if(isEmpty()) {
			root = node;
		}else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node current = queue.remove();
				if(current.left == null) {
					current.left = node;
					break;
				}
				queue.add(current.left);
				
				if(current.right == null) {
					current.right = node;
					break;
				}else {
					queue.add(current.right);
				}
			}
		}
		size++;
		return true;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else {
			Queue<Node> queue = new LinkedList<BinaryTree.Node>();
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
	
	public void getRandomNumber(Node node) {
		Random random = new Random();
		int number = random.nextInt(size);
		System.out.println("Random number is : " + number);
		Node n = getRandomNumberUtil(node, number);
		System.out.println( "A Random Node From Tree : " + n.value);
	}
	
	private Node getRandomNumberUtil(Node node, int count) {
		if(node == null) {
			return node;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Node current = node;
		queue.add(current);
		String str = "[";
		int cnt =0;
		if(cnt == count) {
			return node;
		}
		while(!queue.isEmpty()) {
			current = queue.remove();
			if(cnt == count) {
				return current;
			}
			str = str + current.value + ", ";
			if(current.left != null) {
				queue.add(current.left);
			}
			
			if(current.right != null) {
				queue.add(current.right);
			}
			cnt++;
		}	
		return node;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(1);
		binaryTree.add(2);
		binaryTree.add(3);
		binaryTree.add(4);
		binaryTree.add(5);
		binaryTree.add(6);
		binaryTree.add(7);
		System.out.println(binaryTree);
		
		System.out.println(binaryTree.size());
		binaryTree.getRandomNumber(binaryTree.root);
		
	}
	
}
