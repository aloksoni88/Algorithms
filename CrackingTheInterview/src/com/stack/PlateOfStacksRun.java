package com.stack;

public class PlateOfStacksRun {
	public static void main(String[] args) {
		PlateOfStackHelper helper =new PlateOfStackHelper(2);
		
		helper.push(1);
		helper.push(2);
		helper.push(3);
		helper.push(4);
		helper.push(5);
		
		helper.popAtStack(0);
	
		
		helper.push(20);
		helper.push(21);
//		
//		System.out.println(helper);
		
		helper.popAtStack(0);
		helper.popAtStack(2);
		
//		System.out.println(helper);
//		
		helper.pop();
//		System.out.println(helper);
		helper.pop();
//		System.out.println(helper);
		helper.pop();
//		System.out.println(helper);
		helper.pop();
		System.out.println(helper);
		helper.pop();
	}
}
