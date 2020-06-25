package com.oppsprinciple;

public class Example1 {
	
	int x = m1();
	
	{
		System.out.println("NSB");
	}
	
	int m1(){
		System.out.println("m1 : x");
		return 10;
	}

	public Example1() {
		this(10);
		x = 50;
		System.out.println("No-arg constructor");
	}
	
	public Example1(int a) {
		this("abc");
		x = 60;
		System.out.println("int arg constructor");
	}
	
	
	public Example1(String str){
		x =70;
		System.out.println("String arg constructor");
	}

}
