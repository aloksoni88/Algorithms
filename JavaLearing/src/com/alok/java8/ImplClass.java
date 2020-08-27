package com.alok.java8;

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
		Interface2.super.log(str);
	}

}
