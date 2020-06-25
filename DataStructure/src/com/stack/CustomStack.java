package com.stack;

import java.util.Stack;

public class CustomStack {
	
	public static void main(String[] args) {
		/*StackUsingArray stackArr = new StackUsingArray();
		System.out.println("Is stack empty ? " + stackArr.isEmpty());
		
		stackArr.push(1);
		stackArr.push(2);
		stackArr.push(3);
		stackArr.push(4);
		stackArr.push(5);
		
		System.out.println("Is stack empty ? " + stackArr.isEmpty());
		stackArr.displayStack();*/
		
		
		
		StackUsingLinkedList stackList = new StackUsingLinkedList();
		System.out.println("Is stack empty ? " + stackList.isEmpty());
		
		stackList.push(1);
		stackList.push(2);
		stackList.push(3);
		stackList.push(4);
		stackList.push(5);
		
		System.out.println("Is stack empty ? " + stackList.isEmpty());
		stackList.displayStack();
	}
}
