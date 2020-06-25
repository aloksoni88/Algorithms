/**
 * 
 */
package com.alok.queue;

import java.util.NoSuchElementException;

/**
 * @author Alok Soni
 *
 */
public class QueueUsingLinkedList<T> {
	
	private class Node{
		private T value;
		private Node next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	//first = front
	//last = rear;
	private Node front, rear;
	
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}else {
			Node current = front;
			int size =0;
			while(current != null) {
				current = current.next;
				size++;
			}
			return size;
		}
	}
	
	public boolean isEmpty() {
		if(front == null && rear == null) {
			return true;
		}
		return false;
	}
	
	public boolean add(T item) {
		Node node = new Node(item);
		if(isEmpty()) {
			front = rear = node; 
		}else {
			rear.next = node;
			rear = node;
		}
		return true;
	}
	
	public boolean enque(T item) {
		return add(item);
	}

	public T remove() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		T value = front.value;
		if(front == rear) {
			front = rear = null;
		}else {
			front = front.next;
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
		return front.value;
	}
	
	public T element() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return front.value;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else if(front == rear) {
			return "[" + front.value +"]";
		}else {
			String str = "[";
			Node current = front;
			while(current != null) {
				str = str + current.value + ", ";
				current = current.next;
			}
			str = str.trim().substring(0, str.length()-2) + "]";
			return str;
		}
	}
}

