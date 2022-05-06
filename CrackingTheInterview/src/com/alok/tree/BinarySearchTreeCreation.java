/**
 * 
 */
package com.alok.tree;

/**
 * @author Alok Soni
 *
 */
public class BinarySearchTreeCreation {
	
	class BST{
		private int value;
		private BST left;
		private BST right;
		
		public BST(int value) {
			this.value = value;
		}
	}
	
	BST root;
	
	public void insert(int item) {
		BST bst = new BST(item);
		if(root == null) {
			root = bst;
			return;
		}
		BST current = root;
		while(current != null) {
			if(current.value > item) {
				if(current.left == null) {
					current.left = bst;
					break;
				}
				current = current.left;
			}else if(current.value < item) {
				if(current.right == null) {
					current.right = bst;
					break;
				}
				current = current.right;
			}
		}
	}
	
	public boolean contains(int item) {
		if(root == null) {
			return false;
		}
		BST current = root;
		while(current != null) {
			if(current.value == item) {
				return true;
			}else if(current.value > item) {
				current = current.left;
			}else {
				current = current.right;
			}
		}
		return false;
	}
	
	public void remove(int item) {
		removeItem(root, item);
	}
	
	private BST removeItem(BST node, int item) {
		if(node == null) {
			return node;
		}
		if(node.value > item) {
			node.left = removeItem(node.left,item);
		}else if(node.value < item) {
			node.right = removeItem(node.right, item);
		}else if(node.left == null) {
			return node.right;
		}else if(node.right == null) {
			return node.left;
		}else {
			BST successor = node.right;
			int minValue = successor.value;
			while(successor.left != null) {
				minValue = successor.left.value;
				successor = successor.left;
			}
			node.value = minValue;
			node.right = removeItem(node.right, minValue);
		}
		return node;
	}
	
	public void displayTree() {
		System.out.println("Preorder");
		preorder(root);
		System.out.println();
		System.out.println("Inorder");
		inorder(root);
		System.out.println();
		System.out.println("Postorder");
		postorder(root);
	}
	
	private void preorder(BST node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	private void postorder(BST node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + " ");
	}
	
	private void inorder(BST node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		BinarySearchTreeCreation bst = new BinarySearchTreeCreation();
		bst.insert(11);
		bst.insert(7);
		bst.insert(21);
		bst.insert(5);
		bst.insert(9);
		bst.insert(16);
		bst.insert(25);
		bst.insert(8);
		
		bst.displayTree();
		System.out.println();
		boolean isPresent = bst.contains(9);
		System.out.println("isPresent "+ isPresent);
		
		System.out.println();
		bst.remove(11);
		System.out.println("After removing the item : " + 11);
		bst.displayTree();
	}
}
