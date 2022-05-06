/**
 * 
 */
package com.alok.tree;

/**
 * @author Alok Soni
 *
 */
public class BinarySearchTree {
	
	private class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private Node root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public Node add(Node node, int item) {
		if(node == null) {
			return new Node(item);
		}
		if(item < node.value) {
			node.left = add(node.left,item);
		}else if(item > node.value) {
			node.right = add(node.right,item);
		}
		return node;
	}
	
	public void add(int item) {	
		Node node = new Node(item);
		if(isEmpty()) {
			root = node;
			return;
		}
		Node current = root;
		while(current != null) {
			if(item < current.value) {
				if(current.left == null) {
					current.left = node;
					break;
				}
				current = current.left;
			}else {
				if(current.right == null) {
					current.right = node;
					break;
				}
				current = current.right;
			}
		}
	}
	
	public Node searchItem(int item) {
		if(isEmpty()) {
			System.out.println("tree is empty");
			return null;
		}
		Node current = root;
		while(current != null) {
			if(item < current.value) {
				current = current.left;
			}else if(item > current.value) {
				current = current.right;
			}else {
				return current;
			}
		}
		return null;
	}

	
	int minValue(Node root) 
    { 
        int minv = root.value; 
        while (root.left != null) 
        { 
            minv = root.left.value; 
            root = root.left; 
        } 
        return minv; 
    } 
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else {
			preorder(root);
			System.out.println();
			inorder(root);
			System.out.println();
			postorder(root);
			return "";
		}
	}
	
	private void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.value + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	private void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
	
	private void postorder(Node root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value + " ");
		return;
	}

	public Node removeRecursively(Node root, int item) {
		if(root == null) {
			return root;
		}
		if(item < root.value) {
			root.left = removeRecursively(root.left, item);
		}else if(item > root.value) {
			root.right = removeRecursively(root.right, item);
		}else {
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}else {
				Node successor = root.right;
				int minValue=successor.value;
				while(successor.left != null) {
					minValue = successor.left.value;
					successor = successor.left;
				}
				root.value = minValue;
				root.right = removeRecursively(root.right, minValue);
			}	
		}
		return root;	
	}
	
	public void remove(int item) {
		if(isEmpty()) {
			System.out.println("tree is empty");
			return ;
		}
		Node prev = null;
		Node current = root;
		while(current != null) {
			if(item < current.value) {
				prev = current;
				current = current.left;
			}else if(item > current.value) {
				prev = current;
				current = current.right;
			}else if(item == current.value){
				if(current.left == null && current.right == null) {
					if(prev.left != null && prev.left.value == item) {
						prev.left = null;
					}else {
						prev.right = null;
					}
				}else if(current.left == null) {
					Node tmp = current;
					current.value = current.right.value;
					current.right = null;
					tmp = null;
				}else if(current.right == null) {
					Node tmp = current;
					current.value = current.left.value;
					current.left = null;
					tmp = null;
				}else {
					Node successor = current.right;
					while(successor.left != null) {
						successor = successor.left;
					}
					current.value = successor.value;
					if(current.right.left == null) {
						current.right = successor.right;
					}else {
						current.right.left = successor.right;
//						Node tmp = current.right;
//						Node tmpPrev = tmp;
//						while(tmp.left != null) {
//							tmpPrev = tmp;
//							tmp = tmp.left;
//						}
//						if(tmpPrev.left != null && tmpPrev.left.value == item) {
//							tmpPrev.left = null;
//						}else {
//							tmpPrev.right = null;
//						}

					}
				}
				break;
			}else {
				System.out.println("item not found");
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = tree.add(tree.root,25);
		tree.root = tree.add(tree.root,20);
		tree.root = tree.add(tree.root,45);
		tree.root = tree.add(tree.root,10);
		tree.root = tree.add(tree.root,24);
		tree.root = tree.add(tree.root,8);
		tree.root = tree.add(tree.root,12);
		tree.root = tree.add(tree.root,9);
		tree.root = tree.add(tree.root,35);
		tree.root = tree.add(tree.root,95);
		tree.root = tree.add(tree.root,30);
		tree.root = tree.add(tree.root,50);
		tree.root = tree.add(tree.root,100);
		
		System.out.println(tree);
//		int item = 9;
//		Node node = tree.searchItem(item);
//		if(node != null) {
//			System.out.println("Item "  + item + " found ");
//		}else {
//			System.out.println("Item not found");	
//		}
////		
		int deleteItem = 8;
//		tree.removeRecursively(tree.root, deleteItem);
		tree.remove(deleteItem);
		System.out.println(tree);
//		
//		tree.inorder(tree.root);
	}
}
