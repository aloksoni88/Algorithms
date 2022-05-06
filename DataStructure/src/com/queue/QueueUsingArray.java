package com.queue;

public class QueueUsingArray {
	public static void main(String[] args) {
		CustomQueue queue = new CustomQueue();
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
		
		queue.peek();
	
	}
}

class CustomQueue{
	final int MAX = 5;
	int[] queue = new int[MAX];
	int front =-1,rear =  -1;
	
	boolean isEmpty(){
		if(front == -1 && rear == -1){
			return true;
		}
		return false;
	}
	
	boolean isFull(){
		if(rear == MAX-1){
			return true;
		}
		return false;
	}
	
	void enque(int data){
		if(isFull()){
			System.out.println("Overflow");
			return;
		}
		if(isEmpty()){
			front = rear = 0;
		}else{
			rear++;
		}
		queue[rear] = data;
	}
	
	void deque(){
		if(isEmpty()){
			System.out.println("Underflow");
			return;
		}
		if(front == rear){
			System.out.println("Deleted item is : " + queue[front]);
			front = rear = -1;
		}else{
			System.out.println("Deleted item is : " + queue[front]);
			front++;
		}
	}
	
	void display(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		int tmp = front;
		while(tmp != rear){
			System.out.print(queue[tmp++] + " ");
		}
		System.out.println(queue[rear]);
		System.out.println("front = "+ front + " & rear = "+ rear);
	}
	
	int peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		return queue[front];
	}
	
}
