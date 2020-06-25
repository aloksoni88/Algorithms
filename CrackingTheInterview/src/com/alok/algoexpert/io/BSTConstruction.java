/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class BSTConstruction {

	public static void main(String[] args) {
		 BSTConstruction bstConstruction = new BSTConstruction();
		 BST bst= bstConstruction.new BST(10);	
		 bst.insert(10);
		// BST bst = bstConstruction.new BST(10);
		// bst.insert(10);
		

	}

	public class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		private BST root;

		public BST insert(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			
			
//			if (value < this.value) {
//				if (left == null) {
//					BST node = new BST(value);
//					left = node;
//				} else {
//					left.insert(value);
//				}
//			} else {
//				if (right == null) {
//					BST node = new BST(value);
//					right = node;
//				} else {
//					right.insert(value);
//				}
//			}

			BST node = new BST(value);
			BST current = this;
			while (current != null) {
				if (current.value > value) {
					if (current.left == null) {
						current.left = node;
						break;
					}
					current = current.left;
				} else if (current.value < value) {
					if (current.right == null) {
						current.right = node;
						break;
					}
					current = current.right;
				}
			}

			return this;
		}

		public boolean contains(int value) {
			// Write your code here.
			BST current = this;
			while (current != null) {
				if (current.value == value) {
					return true;
				}
				if (current.value > value) {
					current = current.left;
				} else if (current.value < value) {
					current = current.right;
				}
			}
			return false;
		}

		public BST remove(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			if (this.left == null && this.right == null) {
				return this;
			}
			return removeItem(this, value);
		}

		private BST removeItem(BST node, int item) {
			if (node == null) {
				return null;
			}
			if (node.value > value) {
				node.left = removeItem(node.left, item);
			} else if (node.value < value) {
				node.right = removeItem(node.right, item);
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				BST successor = node.right;
				int minValue = node.value;
				while (successor.left != null) {
					successor = successor.left;
					minValue = successor.left.value;
				}
				node.value = minValue;
				node.right = removeItem(node.right, minValue);
			}
			return this;
		}
	}
}
