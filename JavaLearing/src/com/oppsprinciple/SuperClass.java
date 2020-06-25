package com.oppsprinciple;

public class SuperClass {
	public SuperClass(){
		this(10);
		System.out.println("super class no-arg constructor");
	}
	
	public SuperClass(int a){
		this("abc");
		System.out.println("super class int-arg constructor");
	}

	public SuperClass(String s){
		System.out.println("super class string-arg constructor");
	}
}

class SubClass extends SuperClass{
	public SubClass(){
		this(10);
		System.out.println("sub class no-arg constructor");
	}
	
	public SubClass(int a){
		this("abc");
		System.out.println("sub class int-arg constructor");
	}

	public SubClass(String s){
		System.out.println("sub class string-arg constructor");
	}
}
