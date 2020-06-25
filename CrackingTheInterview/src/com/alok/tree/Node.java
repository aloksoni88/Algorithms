/**
 * 
 */
package com.alok.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Alok Soni
 *
 */
public class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node() {
		
	}
	public Node(int value) {
		this.value = value;
	}
	
	public static boolean isEmpty() {
		return root == null;
	}
	
	private static Node root;
	
	public static String display() {
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
}
