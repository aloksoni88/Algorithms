package com.queue;

public class QueueUsingLinkedList {
	public static void main(String[] args) {
		QueueLinkedList queue = new QueueLinkedList();
		
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.enque(4);
		queue.enque(5);
		queue.enque(6);
		
		queue.display();
		
		System.out.println();
		
		queue.deque();
		queue.deque();
		
		queue.display();
		
		System.out.println();
		System.out.println("queue.peek() = "+queue.peek());
	}
}

class Node{
	Node next;
	int data;
	Node(int data){
		this.data = data;
	}
}

class QueueLinkedList{
	Node front, rear;
	boolean isEmpty(){
		if(front == null && rear == null){
			return true;
		}
		return false;
	}
	
	void enque(int data){
		Node tmp = new Node(data);
		if(front == null && rear == null){
			front = rear = tmp;
		}else{
			rear.next = tmp;
			rear = tmp;
		}
	}
	
	void deque(){
		if(isEmpty()){
			System.out.println("Underflow");
			return;
		}
		if(front == rear){
			System.out.println("Deleted item is : " + front.data);
			front = rear = null;
		}else {
			System.out.println("Deleted item is : " + front.data);
			front = front.next;
		}
	}
	
	void display(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		Node tmp = front;
		while(tmp != rear){
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.print(rear.data);
	}
	
	int peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		return front.data;
	}
}
