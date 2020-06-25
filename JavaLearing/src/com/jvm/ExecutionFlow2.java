package com.jvm;

public class ExecutionFlow2 {
	int x = m1();
	int m1(){
		System.out.println("x variable is executed");
		return 30;
	}
	
	int m2(){
		System.out.println("y variable is executed");
		return 40;
	}
	
	{
		System.out.println("NSB");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		ExecutionFlow2 flow2 = new ExecutionFlow2();
		flow2.m3();
	}
	
	public ExecutionFlow2() {
		System.out.println("Constructor");
	}
	
	void m3(){
		System.out.println("m3");
	}
	
	int b = m2();
	
	void m4(){
		System.out.println("m4");
	}
}
