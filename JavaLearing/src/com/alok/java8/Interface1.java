package com.alok.java8;

public interface Interface1 {
	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}
	
	default void sayHello() {
		System.out.println("say hello");
	}

	static void print(String str) {
		System.out.println("Printing " + str);
	}
	
	
}
