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
		Node current = head;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.displayStack();
		System.out.println(stack.peek());
		
		System.out.println("popped item-> " + stack.pop());
		stack.displayStack();
	}
}
