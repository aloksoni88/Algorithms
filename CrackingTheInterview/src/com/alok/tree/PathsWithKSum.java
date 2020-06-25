/**
 * 
 */
package com.alok.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Alok Soni
 *
 */
public class PathsWithKSum {
	private int[] arr = new int[10];
	private class Node{
		private int value;
		private Node left, right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	private Node node;
	private int pathCount = 0;
	private ArrayList<Integer> path = new ArrayList<Integer>();
	
	private void displayTree(Node node) {
		
		Queue<Node> queue = new LinkedList<Node>();
		Node current = node;
		queue.add(current);
		String str = "[";
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
		System.out.println(str);
	}
	
	private void findPathSum(Node node, int sum) {
		if(node == null) {
			return;
		}
		path.add(node.value);
		
		findPathSum(node.left, sum);
		
		findPathSum(node.right, sum);
		
		int totalSum = 0;
		for(int i= path.size()-1; i>=0 ; i--) {
			totalSum = totalSum + path.get(i);
			if(totalSum == sum) {
				printPath(path, i);
			}
		}
		path.remove(path.size()-1);
	}
	
	private void printPath(ArrayList<Integer> list, int index) {
		pathCount++;
		for(int i=index; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PathsWithKSum pathSum = new PathsWithKSum();
//		pathSum.node = pathSum.new Node(10);
//		pathSum.node.left = pathSum.new Node(5);
//		pathSum.node.right = pathSum.new Node(-3);
//		
//		pathSum.node.left.left = pathSum.new Node(3);
//		pathSum.node.left.right = pathSum.new Node(2);
//		
//		pathSum.node.left.left.left = pathSum.new Node(3);
//		pathSum.node.left.left.right = pathSum.new Node(-3);
//		
//		pathSum.node.left.right.right = pathSum.new Node(1);
//		
//		pathSum.node.right.right = pathSum.new Node(11);
//		
//		[10, 5, -3, 3, 2, 11, 3, -3, 1]
//		5 3 
//		5 2 1 
//		-3 11 
		
		pathSum.node = pathSum.new Node(1);
		pathSum.node.left = pathSum.new Node(3);
		pathSum.node.right = pathSum.new Node(-1);
		
		pathSum.node.left.left = pathSum.new Node(2);
		pathSum.node.left.right = pathSum.new Node(1);
		
		pathSum.node.left.right.left = pathSum.new Node(1);
		
		pathSum.node.right.left = pathSum.new Node(4);
		pathSum.node.right.right = pathSum.new Node(5);
		
		pathSum.node.right.left.left = pathSum.new Node(1);
		pathSum.node.right.left.right = pathSum.new Node(2);
		
		pathSum.node.right.right.right = pathSum.new Node(6);
	
		pathSum.displayTree(pathSum.node);
		
		int sum = 5;
		pathSum.findPathSum(pathSum.node, sum);
		System.out.println("Total no of path for sum " + sum  + " = " + pathSum.pathCount);
	}
}
