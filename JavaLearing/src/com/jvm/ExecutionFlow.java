package com.jvm;

public class ExecutionFlow {
	
	static{
		System.out.println("Static block");
		main(new String[0]);
		System.out.println("Static block end");
	}
	static int m1(){
		System.out.println("a variable is executing");
		return 10;
	}
	
	static int m2(){
		System.out.println("b variable is executing");
		return 20;
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		m3();
	}
	static int a = m1();
	static{
		System.out.println("SB");
		m3();
	}
	
	
	static void m3(){
		System.out.println("m3");
	}
	static int b = m2();
	
	static void m4(){
		System.out.println("m4");
	}
}
