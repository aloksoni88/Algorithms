/**
 * 
 */
package com.alok.dp.tree;

/**
 * @author Alok Soni
 *
 */

/**
 * ################## Question ###################
 * 
 * Diameter of a Binary Tree 
 * The diameter of a tree (sometimes called the width)
 * is the number of nodes on the longest path between two end nodes. The diagram
 * below shows two trees each with diameter nine, the leaves that form the ends
 * of a longest path are shaded (note that there is more than one path in each
 * tree of length nine, but no path longer than nine nodes).
 *
 */
public class BinaryTreeDiameter {
	private static Node root;
	public static void main(String[] args) {
		BinaryTreeDiameter tree = new BinaryTreeDiameter(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(14);
        tree.root.left.left.left.left = new Node(24);
        
        
        int diameter = getDiameter(root, Integer.MIN_VALUE);
        System.out.println("Diameter of Binary tree is : " + (diameter+1));
	}
	
	private static int getDiameter(Node node, int result) {
		if(node == null) {
			return 0;
		}
		
		int left = getDiameter(node.left, result);
		int right = getDiameter(node.right, result);
		
		int tmp = Math.max(left,right) + 1;
		int ans = Math.max(tmp, (1+left+right));
		result  = Math.max(result, ans);
		return tmp;
	}
	
}

class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 