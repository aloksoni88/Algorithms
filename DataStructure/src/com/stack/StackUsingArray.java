package com.stack;

public class StackUsingArray {
	final int MAX = 100;
	int[] arr = new int[MAX];
	int top = -1;
	
	public boolean isEmpty(){
		if(top < 0){
			return true;
		}
		return false;
	}
	
	public boolean push(int data){
		if(top == (MAX-1)){
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++top] = data;
		System.out.println(data + " pushed into stack");
		return true;
	}
	
	public int pop(){
		if(top <= -1){
			System.out.println("Stack underflow");
			return -1;
		}
		return arr[top--];
	}
	
	public int peek(){
		if(top > -1 && top < (MAX-1)){
			return arr[top];
		}
		System.out.println("Stack is empty");
		return -1;
	}
	
	public void displayStack(){
		System.out.println("Stack is :-");
		while(top > -1){
			System.out.print(pop() + " ");
		}
	}
}
