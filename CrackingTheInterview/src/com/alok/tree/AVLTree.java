/**
 * 
 */
package com.alok.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/**
 * @author Alok Soni
 *
 */
public class AVLTree {
	
	private class Node{
		private int value;
		private Node left;
		private Node right;
		private int height=1;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node value & Height : " + value +", " + height;
		}
	}
	
	private Node root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int getHeight(Node root) {
		if(root == null) {
			return 0;
		}
		return root.height;
	}
	
	public int getBalance(Node node) {
		if(node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
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
		
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		
		int balance = getBalance(node);
		
		//LL rotation
		if(balance > 1 && item < node.value) {
			return rightRotation(node);
		}
		
		//LR ratation
		if(balance > 1 && item > node.value) {
			node.left = leftRotation(node.left);
			return rightRotation(node);
		}
		
		//RR rotation
		if(balance < -1 && item > node.value) {
			return leftRotation(node);
		}

		//RL Rotation
		if(balance < -1 && item < node.value) {
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}
		
		return node;
	}
	
	public Node rightRotation(Node node) {
		Node tmp1 = node.left;
		Node tmp2 = tmp1.right;
		
		tmp1.right = node;
		node.left = tmp2;
		
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		tmp1.height = Math.max(getHeight(tmp1.left), getHeight(tmp1.right)) + 1;
		
		return tmp1;
	}
	
	public Node leftRotation(Node node) {
		Node tmp1 = node.right;
		Node tmp2 = tmp1.left;
		
		tmp1.left = node;
		node.right = tmp2;
		
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		tmp1.height = Math.max(getHeight(tmp1.left), getHeight(tmp1.right)) + 1;
		
		return tmp1;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else {
			Queue<Node> queue = new LinkedList<Node>();
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
	
	private void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
	
	public Node remove(Node root, int item) {
		if(root == null) {
			return root;
		}
		if(item < root.value) {
			root.left = remove(root.left, item);
		}else if(item > root.value) {
			root.right = remove(root.right, item);
		}else {
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			Node successor = root.right;
			int minValue = successor.value;
			while(successor.left != null) {
				minValue = successor.left.value;
				successor = successor.left;
			}
			root.value = minValue;
			root.right = remove(root.right, minValue);
		}
	
		if(root == null) {
			return root;
		}
		
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		int balance = getBalance(root);
		
		//LL rotation
		if(balance > 1 && getBalance(root.left) >= 0) {
			return rightRotation(root);
		}
		
		//LR ratation
		if(balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotation(root.left);
			return rightRotation(root);
		}
		
		//RR rotation
		if(balance < -1 && getBalance(root.right) <=0) {
			return leftRotation(root);
		}

		//RL Rotation
		if(balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotation(root.right);
			return leftRotation(root);
		}
		
		return root;
	}
	
	public void print(Node root) {

        if(root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
            width = (int)Math.pow(2, height-1);

        // Preparing variables for loop.
        List<Node> current = new ArrayList<Node>(1),
            next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength*width);
        for(int i = 0; i < maxHalfLength*width; i++)
            sb.append(' ');
        String textBuffer;

        // Iterating through height levels.
        for(int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int)Math.pow(2, height-1-i) - 1));

            // Creating spacer space indicator.
            textBuffer = sb.toString();

            // Print tree node elements
            for(Node n : current) {

                System.out.print(textBuffer);

                if(n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // Print tree node extensions for next level.
            if(i < height - 1) {

                for(Node n : current) {

                    System.out.print(textBuffer);

                    if(n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // Renewing indicators for next run.
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }

    }
	
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.add(tree.root,50);
		tree.root = tree.add(tree.root,40);
		tree.root = tree.add(tree.root,35);
		tree.root = tree.add(tree.root,36);
		tree.root = tree.add(tree.root,38);
		tree.root = tree.add(tree.root,60);
		tree.root = tree.add(tree.root,70);
		tree.root = tree.add(tree.root,80);
		
		System.out.println("BFS 0R levele order traversal");
		System.out.println(tree);
		
		System.out.println("Inorder traversal");
		tree.inorder(tree.root);
		System.out.println();
		
		tree.remove(tree.root, 40);
		System.out.println();
		System.out.println("===========================================================");
		System.out.println("after deletion");
		System.out.println("BFS 0R levele order traversal");
		System.out.println(tree);
		
		System.out.println("Inorder traversal");
		tree.inorder(tree.root);

		System.out.println();
		tree.print(tree.root);
	}
}
