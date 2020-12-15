/**
 * 
 */
package com.alok.tree;

/**
 * @author Alok Soni
 *
 */
public class IterativeInorderWithConstantSpace {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		inorderTraversal(root);
	}

	/**
	 * @param root
	 */
	private static void inorderTraversal(Node root) {
		Node current = root;
		Node predecesor = null;
		while(current != null) {
			if(current.left == null) {
				System.out.print(current.value + " ");
				current = current.right;
			}else {
				/* Find the inorder predecessor of current */
				predecesor = current.left;
				while(predecesor.right != null && predecesor.right != current) {
					predecesor = predecesor.right;
				}
				
				/* Make current as right child of its inorder predecessor */
				if(predecesor.right == null) {
					predecesor.right = current;
					current = current.left;
				}else {
					/* Revert the changes made in the 'if' part to restore the  
                    original tree i.e., fix the right child of predecessor*/
					predecesor.right = null;
					//System.out.print(current.value + " ");
					current = current.right;
				}
			}
		}
	}
	
	
}
