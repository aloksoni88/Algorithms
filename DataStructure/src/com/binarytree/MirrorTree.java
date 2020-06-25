package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
	public static void main(String[] args) {
		Node node = new Node(1);
		CreateBinaryTree.insertItem(node,2);
		CreateBinaryTree.insertItem(node,3);
		CreateBinaryTree.insertItem(node,4);
		CreateBinaryTree.insertItem(node,5);
		
		
		System.out.println("Tree before mirror Image");
		CreateBinaryTree.displayTree(node);
		System.out.println();
		System.out.println("Tree after mirror Image");
		//mirrorTreeRecursive(node);
		mirrorTree(node);
		CreateBinaryTree.displayTree(node);
		
	}
	
	public static void mirrorTreeRecursive(Node node){
		if(node == null){
			return;
		}
		
		mirrorTreeRecursive(node.left);
		mirrorTreeRecursive(node.right);
		
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
	
	public static void mirrorTree(Node node){
		if(node == null){
			System.out.println("tree is empty");
			return ;
		}
		if(node.left == null && node.right == null){
			System.out.println("Only 1 node in tree");
			return ;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty()){
			Node curr = q.remove();
			Node tmp = curr.left;
			curr.left = curr.right;
			curr.right = tmp;
			if(curr.left != null){
				q.add(curr.left);
			}
			if(curr.right != null){
				q.add(curr.right);
			}
		}
		
	}
	
	
}
