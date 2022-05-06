package com.oppsprinciple;

public class Sample {
	
	public static void main(String[] args) {
		Example1 e1 = new Example1();
		System.out.println("e1.x: "+ e1.x);
		
		Example1 e2 = new Example1(10);
		System.out.println("e2.x: "+ e2.x);
//		
//		Example1 e3 = new Example1("abc");
//		System.out.println("e3.x: "+ e3.x);
	}
	
}
