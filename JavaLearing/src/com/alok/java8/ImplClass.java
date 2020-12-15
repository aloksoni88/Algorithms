package com.alok.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

public class ImplClass implements Interface1, Interface2{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub
		
	}
	

	
	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		//Interface1.super.log(str);
	}

	public static void main(String[] args) {
		ImplClass implClass = new ImplClass();
		implClass.log("hi");
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
			
		});
	}

}
