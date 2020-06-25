/**
 * 
 */
package com.alok.queue;

import java.util.NoSuchElementException;

/**
 * @author Alok Soni
 *
 */
public class CircularQueue<T> {
	private T[] itemArr = (T[])new Object[5];
	private int size =5;
	private int front=-1,rear =-1;
	

	private boolean isFull() {
		return front == rear+1;
	}
	
	public boolean isEmpty() {
		if(front == -1 && rear == -1) {
			return true;
		}
		return false;
	}
	
	public boolean add(T item) {
		if(isFull()) {
			System.out.println("Queue is full");
			return false;
		}
		if(isEmpty()) {
			front = rear = 0; 
		}else {
			rear = (rear+1)%size;
		}
		itemArr[rear] = item;
		return true;
	}
	
	public boolean enque(T item) {
		return add(item);
	}

	public T remove() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		T value = itemArr[front];
		if(front == rear) {
			front = rear = -1;
		}else {
			front = (front+1)%size;
		}
		return value;
	}
	
	public T deque() {
		return remove();
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return itemArr[front];
	}
	
	public T element() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return itemArr[front];
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else if(front == rear) {
			return "[" + itemArr[front] +"]";
		}else {
			if(front < rear) {
				String str = "[";
				for(int i=front; i<=rear; i++) {
					str = str+itemArr[i] +", ";
				}
				str = str.trim().substring(0, str.length()-2) + "]";
				return str;
			}else {
				String str = "[" + itemArr[front] + ", ";
				while(front != rear) {
					front = (front+1)%size;
					str = str+itemArr[front] +", ";
				}
				str = str.trim().substring(0, str.length()-2) + "]";
				return str;	
			}
		}
	}
	public static void main(String[] args) {
		CircularQueue<Integer>  cq = new CircularQueue<Integer>();
		cq.enque(10);
		cq.enque(20);
		cq.enque(30);
		cq.enque(40);
		
		//System.out.println(cq);
		cq.deque();
		cq.deque();
		cq.deque();
//		System.out.println(cq);
		
		cq.enque(50);
		cq.enque(60);
		cq.enque(70);
		
		cq.deque();
		cq.deque();
		cq.deque();
		cq.deque();
		
		System.out.println(cq);		
	}
}
