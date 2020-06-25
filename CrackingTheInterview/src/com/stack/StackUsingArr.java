package com.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackUsingArr<T> {
	private int top = -1;
	private final int MAX = 10;
	private T[] itemArr= (T[]) new Object[MAX];
	private T[] minItems =  (T[]) new Object[MAX];
	private T[] maxItems =  (T[]) new Object[MAX];
	private int minItemIndex=-1, maxItemIndex=-1;
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean add(T item) {
		return push(item);
	}
	
	public boolean push(T item) {
		if(top == MAX-1) {
			System.out.println("Over flow");
			return false;
		}else {
			if(isEmpty()) {
				minItems[++minItemIndex] = item;
				maxItems[++maxItemIndex] = item;
			}else if((int)item <= (int)minItems[minItemIndex]) {
				minItems[++minItemIndex] = item;
			}else if((int) item >= (int) maxItems[maxItemIndex]) {
				maxItems[++maxItemIndex] = item;
			}
			itemArr[++top] = item;
		}
		return false;
	}
	
	public T pop() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		T item = peek();
		if((int)item <= (int)minItems[minItemIndex]) {
			minItemIndex--;
		} 
		if((int)item >= (int)maxItems[maxItemIndex]) {
			maxItemIndex--;
		}
		return itemArr[top--];
	}
	
	public T peek() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		return itemArr[top];
	}
	
	public T min() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return minItems[minItemIndex];
	}
	
	public T max() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return maxItems[maxItemIndex];
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
	
	
	public static void main(String[] args) {
		StackUsingArr<Integer> myStack = new StackUsingArr<Integer>();
		myStack.add(5);
		myStack.add(2);
		myStack.add(6);
		myStack.add(3);
		myStack.add(1);
		myStack.add(8);
		
		System.out.println(myStack);
		System.out.println("Min:"+myStack.min() + ",Max:" + myStack.max());
		
		System.out.println("Item popped: "+myStack.pop());
		System.out.println(myStack);
		System.out.println("Min:"+myStack.min() + ",Max:" + myStack.max());
		
		System.out.println("Item popped: "+myStack.pop());
		System.out.println(myStack);
		System.out.println("Min:"+myStack.min() + ",Max:" + myStack.max());
		
		System.out.println("Item popped: "+myStack.pop());
//		System.out.println(Arrays.toString(myStack.maxItems));
		System.out.println(myStack);
		System.out.println("Min:"+myStack.min() + ",Max:" + myStack.max());
		
		System.out.println("Item popped: "+myStack.pop());
		System.out.println(myStack);
		System.out.println("Min:"+myStack.min() + ",Max:" + myStack.max());
		
		System.out.println("Item popped: "+myStack.pop());
		System.out.println(myStack);
		System.out.println("Min:"+myStack.min() + ",Max:" + myStack.max());
		
		
		System.out.println("Item popped: "+myStack.pop());
		System.out.println(myStack);
		
	
		//boolean add()
		//void add(index, element)
		//void addElement() adding last
		//int size()
		//isEmpty()
		//clear()
		//boolean contains
		//T elementAt(index)
		//Enumeration elements()
		//T firstElement()
		//T lastElement()
		//T get(index)
		//int indexOf(T)
		//int indexOf(T,index)
		//insertElementAt(T,index)
		//Interator<T> iterator()
		//int search(T)
		//T push(T)
		//pop(T)
		//peek(T)
	}
}
