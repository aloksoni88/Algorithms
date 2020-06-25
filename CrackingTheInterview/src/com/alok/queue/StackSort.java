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
public class StackSort<T> {
	
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public static void main(String[] args) {
		StackSort<Integer> stackSort = new StackSort<Integer>();
		stackSort.push(5);
		stackSort.push(1);
		stackSort.push(2);
		stackSort.push(6);
		stackSort.push(4);
		stackSort.push(0);
		
		System.out.println(stackSort);
	}
	
	public boolean push(T item) {
		if(stack1.isEmpty() || (int)item <= (int)stack1.peek()) {
			stack1.push(item);
			System.out.println(stack1);
			return true;
		}
		while(!stack1.isEmpty()) {
			if((int)item > (int)stack1.peek()) {
				stack2.push(stack1.pop());
			}else {
				stack2.push(item);
				break;
			}		
		}
		if(stack1.isEmpty()) {
			stack2.push(item);
		}else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		System.out.println(stack1);
		return true;
	}
	
	public T pop() {
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

}
