package com.stack;

public class StackUsingLinkedList {
	Node head;
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	public boolean push(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return true;
		}
		Node tmp = head;
		newNode.next = tmp;
		head = newNode;
		return true;
	}
	
	public int pop(){
		if(head == null){
			System.out.println("Stack is empty");
			return -1;
		}
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public int peek(){
		if(head == null){
			System.out.println("Stack is empty");
			return -1;
		}
		return head.data;
	}
	
	public void displayStack(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Stack is:-");
		while(head != null){
			System.out.print(pop() + " ");
		}
	}
	
	class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
}
