package com.stack;

import java.util.EmptyStackException;

public class MyStack<T> {
	private int top = -1;
	private final int MAX = 10;
	private T[] itemArr= (T[]) new Object[MAX];
	

	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean add(T item) {
		if(top == MAX-1) {
			System.out.println("Over flow");
			return false;
		}else {
			itemArr[++top] = item;
		}
		return false;
	}
	
	public boolean push(T item) {
		return add(item);
	}
	
	public T pop() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		return itemArr[top--];
	}
	
	public T peek() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		return itemArr[top];
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else {
			String str = "[";
			for(int i=top; i>=0; i--) {
				str = str + itemArr[i] +",";
			}
			str = str.substring(0, str.length()-1) +"]";
			return str;
		}
	}
}
