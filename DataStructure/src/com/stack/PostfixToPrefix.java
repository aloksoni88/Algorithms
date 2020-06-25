package com.stack;

import java.util.Stack;

public class PostfixToPrefix {
	public static void main(String[] args) {
		String exp = "ABC/-AK/L-*";
		convetPostfixToPrefix(exp);
	}
	
	private static void convetPostfixToPrefix(String exp){
		Stack<String> stack = new Stack<String>();
		for(int i= 0; i< exp.length(); i++){
			char c = exp.charAt(i);
			if(Utils.isOperatore(c)){
				if(!stack.isEmpty()){
					String a = stack.pop();
					if(stack.isEmpty()){
						System.out.println("Invalid expresion");
						return;
					}
					String b = stack.pop();
					stack.push(c + b + a);
				}else{
					System.out.println("Invalid expression");
					return;
				}
			}else{
				stack.push(c+"");
			}
		}
		
		if(stack.isEmpty()){
			System.out.println("Invalid expression or stack is empty");
			return;
		}
		System.out.println("Prefix expression : " + stack.peek());
	}
}
