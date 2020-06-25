/**
 * 
 */
package com.alok.tree;

/**
 * @author Alok Soni
 *
 */
public class RandomNumber {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(1);
		binaryTree.add(2);
		binaryTree.add(3);
		binaryTree.add(4);
		binaryTree.add(5);
		binaryTree.add(6);
		binaryTree.add(7);
		System.out.println(binaryTree);
		
		System.out.println(binaryTree.size());
		binaryTree.getRandomNumber(binaryTree.root);
		
	}
}
