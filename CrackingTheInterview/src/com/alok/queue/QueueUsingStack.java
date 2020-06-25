/**
 * 
 */
package com.alok.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class QueueUsingStack<T> {
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public boolean enque(T item) {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(item);
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return true;
	}
	
	public T deque() {
		if(stack1.isEmpty()) {
			throw new NoSuchElementException();
		}
		return stack1.pop();
	}
	
	@Override
	public String toString() {
		Stack<T> st = new Stack<T>();
		st.addAll(stack1);
		if(st.isEmpty()) {
			return "[]";
		}
		String str = "[";
		while(!st.isEmpty()) {
			str = str + st.pop() + ", ";
		}
		str = str.trim().substring(0,str.length()-2) + "]";
		return str;
	}
	
	public static void main(String[] args) {
		QueueUsingStack<Integer> queueUsingStack = new QueueUsingStack<Integer>();
		queueUsingStack.enque(1);
		queueUsingStack.enque(2);
		queueUsingStack.enque(3);
		
		System.out.println(queueUsingStack);
		
		queueUsingStack.deque();
		queueUsingStack.deque();
		
		System.out.println(queueUsingStack);
	}
}
