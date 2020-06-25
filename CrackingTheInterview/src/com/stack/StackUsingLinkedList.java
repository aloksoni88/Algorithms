package com.stack;

import java.util.EmptyStackException;

public class StackUsingLinkedList<T> {
	
	private class Node{
		private T value;
		private Node next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	private Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		Node current = top;
		int index = 0;
		while(current != null) {
			current = current.next;
			index++;
		}
		return index;
	}
	
	public boolean push(T item) {
		if(isEmpty()) {
			top = new Node(item);
		}else {
			Node node = new Node(item);
			node.next = top;
			top = node;
		}
		return true;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		Node tmp = top;
		T poppedValue = tmp.value;
		top = top.next;
		tmp = null;
		return poppedValue;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.value;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}
		Node current = top;
		String str = "[";
		while(current != null) {
			str = str + current.value + ",";
			current = current.next;
		}
		str = str.substring(0,str.length()-1) + "]" ;
		return str;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		
		stack.push(10);
		stack.push(20);
		
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
