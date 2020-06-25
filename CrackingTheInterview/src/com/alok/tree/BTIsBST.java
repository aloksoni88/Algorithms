/**
 * 
 */
package com.alok.tree;

/**
 * @author Alok Soni
 *
 */
public class BTIsBST {
	
	class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value = value;
		}
	}
	private Node root;
	private int prev=-1;
	
	public boolean inorder(Node root) {
		if(root == null) {
			return true;
		}
		boolean isBst = inorder(root.left);
		if(!isBst) {
			return false;
		}
		System.out.print(root.value + " ");
		if(prev != -1 && prev > root.value) {
			return false;
		}
		prev = root.value;
		isBst = inorder(root.right);
		return isBst;
	}
	
	public static void main(String[] args) {
		BTIsBST tree = new BTIsBST(); 
        tree.root = tree.new Node(10); 
        tree.root.left = tree.new Node(8); 
        tree.root.right = tree.new Node(12); 
        tree.root.left.left = tree.new Node(6); 
        tree.root.left.right = tree.new Node(10); 
        tree.root.right.left = tree.new Node(12);
        tree.root.right.right = tree.new Node(25);
        
        boolean isBal = tree.inorder(tree.root);
        System.out.println();
        System.out.println("Is Balanced : " + isBal);
	}
}
