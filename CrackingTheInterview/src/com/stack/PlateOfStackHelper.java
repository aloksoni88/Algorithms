package com.stack;

import java.util.ArrayList;

public class PlateOfStackHelper<T> extends PlateOfStacks<T> {
	
	private int stackSize = 0;
	private ArrayList<PlateOfStacks<T>> listOfStack = new ArrayList<PlateOfStacks<T>>();

	
	public PlateOfStackHelper(int size) {
		this.stackSize = size;
		PlateOfStacks<T> platOfStacks = new PlateOfStacks<T>();
		platOfStacks.setSizeOfStack(stackSize);
		listOfStack.add(platOfStacks);
	}
	
	public boolean push(T item) {
		for(int i=0; i<listOfStack.size(); i++) {
			PlateOfStacks<T> plateOfStacks = listOfStack.get(i);
			if(!plateOfStacks.isFull()) {
				plateOfStacks.push(item);
				return true;
			}
		}
		PlateOfStacks<T> stack = new PlateOfStacks<T>();
		stack.setSizeOfStack(stackSize);
		listOfStack.add(stack);
		stack.push(item);		
		return true;
	}
	
	public T pop() {
		for(int i=listOfStack.size()-1; i>=0; i--) {
			PlateOfStacks<T> stack = listOfStack.get(i);
			if(stack.isEmpty()) {
				if(i==0) {
					System.out.println("Stack is empty");
					return (T)new Integer(-1);
				}
			}else {
				return stack.pop();
			}
		}
		
		return null;
	}
	
	public T popAtStack(int stackNo) {
		if(stackNo < 0 || stackNo >= listOfStack.size()) {
			System.out.println("wrong stack index");
			return (T)new Integer(-1);
		}
		PlateOfStacks<T> stack = listOfStack.get(stackNo);
		if(stack.isEmpty()) {
			System.out.println("There are no stack");
			return (T)new Integer(-1);
		}else {
			return stack.pop();
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i= listOfStack.size()-1; i>= 0; i--) {
			PlateOfStacks<T> stack = listOfStack.get(i);
			if(!stack.isEmpty()) {
				str = str + "Stack " + i +  " : " + stack + "\n";
			}
		}
		return str;
	}
}
