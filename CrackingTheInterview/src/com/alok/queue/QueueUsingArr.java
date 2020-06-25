package com.alok.queue;

import java.util.NoSuchElementException;

public class QueueUsingArr<T> {
	private T[] itemArr;
	private int size =0;
	private int front=-1,rear =-1;
	
	public QueueUsingArr(int size) {
		this.size = size;
		itemArr = (T[])new Object[size];
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}return (rear-front)+1;
	}
	
	private boolean isFull() {
		return rear == (size-1);
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
			rear++;
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
			front++;
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
			String str = "[";
			for(int i=front; i<=rear; i++) {
				str = str+itemArr[i] +", ";
			}
			str = str.trim().substring(0, str.length()-2) + "]";
			return str;
		}
	}
}
