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
		BST bst = new BST(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(2);
		bst.insert(5);
		bst.insert(13);
		bst.insert(22);
		bst.insert(1);
		bst.insert(14);
		bst.insert(12);
		
		bst.display();
		
		System.out.println();
		boolean isContains = bst.contains(15);
		System.out.println(isContains);
		
		bst = bst.remove(10);
		bst.display();
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
		
		public void display() {
			display(this);
		}
		
		private void display(BST node) {
			if(node == null) {
				return;
			}
			display(node.left);
			System.out.print(node.value + " ");
			display(node.right);
		}

		public BST insert(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			BST current = this;
			while(current != null) {
				if(current.value > value) {
					if(current.left == null) {
						current.left = new BST(value);
						break;
					}
					current = current.left;
				}else if(current.value <= value) {
					if(current.right == null) {
						current.right = new BST(value);
						break;
					}
					current = current.right;
				}
			}
			return this;
		}
		

    public boolean contains(int value) {
      // Write your code here.
    	if(this.value == value) {
    		return true;
    	}
    	BST current = this;
    	while(current != null) {
    		if(current.value > value) {
    			current = current.left;
    		}else if(current.value < value) {
    			current = current.right;
    		}else {
    			return true;
    		}
    	}
    	return false;
    }
		

    public BST remove(int value) {
		// Write your code here.
		// Do not edit the return statement of this method.
		if(left == null && right == null){
			return this;	
		}
		return removeItem(this,value);
    }
		
		private BST removeItem(BST node, int item){
			if(node == null){
				return node;
			}
			if(node.value > value){
				node.left = removeItem(node.left, item);
			}
			else if(node.value < value){
				node.right = removeItem(node.right, item);
			}
			else if(node.left == null){
				return node.right;
			}else if(node.right == null){
				return node.left;
			}else{
				BST successor = node.right;
				int minValue = successor.value;
				while(successor.left != null){
						minValue = successor.left.value;
						successor = successor.left;
				}
				node.value = minValue;
				node.right = removeItem(node.right, minValue);
			}
			return node;
		} 
	}
}
