package com.alok.java8;

import java.util.function.Function;

public class FuntionProgram {
	public static void main(String[] args) {
		int[] a = new int[8];
		Function<Integer, Integer> f = (i)-> i*i;
		f = f.andThen((i) -> i*5);
		//f  = f.compose(i -> i+2);
		//System.out.println(f);
		
		System.out.println("Square of 5 is : " + f.apply(5));
	}
	
}
