package com.binarytree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class GoogleProblem1 {
	private static Node node;
	public static void main(String[] args) {
		node = new Node(1);
		insertItem(node,2);
		insertItem(node,3);
		insertItem(node,4);
		insertItem(node,5);
		insertItem(node,6);
		insertItem(node,7);
		
		displayItem();
		serializeBinaryTree(node);
		deserializeBinaryTree();
		
	}
	
	private static void serializeBinaryTree(Node node){
		try {
			File file = new File("binaryTree");
			if(file.exists()){
				file.delete();
				System.out.println("File deleted");
			}
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream osw = new ObjectOutputStream(fos);
			osw.writeObject((node));
			osw.flush();
			fos.flush();
			osw.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void deserializeBinaryTree(){
		try {
			File file = new File("binaryTree");
			if(!file.exists()){
				System.out.println("File not exist");
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream isr = new ObjectInputStream(fis);
			Node node = (Node)isr.readObject();
			System.out.println("Displaying tree");
			display(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertItem(Node tmp,int data){
		if(tmp == null){
			tmp = new Node(data);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(tmp);
		while(!q.isEmpty()){
			tmp = q.remove();
			if(tmp.left == null){
				tmp.left = new Node(data);
				break;
			}else{
				q.add(tmp.left);
			}
			
			if(tmp.right == null){
				tmp.right = new Node(data);
				break;
			}
		}
	}
	
	public static void displayItem(){
		display(node);
	}
	
	private static void display(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.data);
		display(node.left);
		display(node.right);
	}
}

class Node implements Serializable{
	int data;
	Node left,right;
	Node(int data){
		this.data = data;
	}
}
