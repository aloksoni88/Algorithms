package com.stack;

import java.util.ArrayList;

public class PlateOfStacks<T> {
	
	private T[] itemArr;
	private int top =-1;
	private int stackSize = 0;


	
	public void setSizeOfStack(int size) {
		stackSize = size;
		itemArr = (T[])new Object[size];
	}
	
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isFull() {
		return top == stackSize -1;
	}
	
	public boolean push(T item) {
		itemArr[++top] = item;
		return true;
	}
	
	public T pop() {
		if(isEmpty()) {
			return (T)(new Integer(-1));
		}
		T value = itemArr[top--];
		return value;
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
