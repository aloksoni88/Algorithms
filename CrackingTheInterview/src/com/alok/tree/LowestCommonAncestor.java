/**
 * 
 */
package com.alok.tree;

/**
 * @author Alok Soni
 *
 */
public class LowestCommonAncestor {
	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		tree.right.left = new Node(7);
		tree.right.left.right = new Node(8);
		
		Node lowestCommonAncestor = findLCA(tree, 9, 10);
		if (lowestCommonAncestor != null) {
			System.out.println(lowestCommonAncestor.data);
		} else {
			System.out.println(" Could not find lca");
		}
		
		
	}
	
	static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static Node findLCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		
		if (root.data == n1 || root.data == n2) {
			return root;
		}
		
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);
		
		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else if (right != null) {
			return right;
		} else {
			return null;
		}
	}
	
	
}
