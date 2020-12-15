package com.hackerearth;

public class Problem1 {
	public static void main(String[] args) {
		Problem1 prob = Problem1.set();
		prob.print();
		
//		Base b = new Base();
//		Child c = new Child();
		Base b = new Child();
	}

	private int a;

	private Problem1()
    {
    	this.a=10;
    	
    }

	public void print() {
		//protected int a = 20; //invalid modifier
		System.out.println(a);
	}

	protected static Problem1 set() {
		return new Problem1();
	}
}


class Base {
	Base(){
		System.out.println("base");
	}
}

class Child extends Base{
	Child(){
		System.out.println("child");
	}
	
}

