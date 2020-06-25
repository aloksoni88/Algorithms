/**
 * 
 */
package com.alok.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Alok Soni
 *
 */
public class BSTSequence {
	
	public LinkedList<LinkedList<TreeNode>> allSeqs;

	//60=51.5,35=30,28=24,25=21.5,19=16.2
	public BSTSequence(TreeNode root) {
		allSeqs = new LinkedList<>(); // All of the possible sequences
		LinkedList<TreeNode> pre = new LinkedList<>(); // The nodes already visited in the current sequence
		LinkedList<TreeNode> poss = new LinkedList<>(); // All of the possible next steps in the current sequence

		buildSeqs(pre, poss, root);
//		for (LinkedList<TreeNode> ll : allSeqs) {
//			for (TreeNode n : ll) {
//				System.out.print(n.data + " ");
//			}
//			System.out.println();
//		}
	}

	private void buildSeqs(LinkedList<TreeNode> pre, LinkedList<TreeNode> poss, TreeNode root) {
		pre.add(root);
		if (root.left != null) {
			poss.add(root.left);
		}
		if (root.right != null) {
			poss.add(root.right);
		}

		if (poss.isEmpty()) {
			allSeqs.add(pre);
		}

		for (TreeNode n : poss) {
			LinkedList<TreeNode> temp = (LinkedList<TreeNode>) pre.clone();
			LinkedList<TreeNode> ptemp = (LinkedList<TreeNode>) poss.clone();
			ptemp.remove(n);
			System.out.println(temp);
			System.out.println(ptemp);
			System.out.println(n);
			buildSeqs(temp, ptemp, n);
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(9);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(2);

		BSTSequence all = new BSTSequence(root);
		for (LinkedList<TreeNode> ll : all.allSeqs) {
			for (TreeNode n : ll) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}
	}

}

class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int value) {
		data = value;
	}
	
	@Override
	public String toString() {
		return "Value : " + data;
	}
}
