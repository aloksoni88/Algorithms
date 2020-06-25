package com.stack;

import java.util.Stack;

public class PostfixToInfix {
	public static void main(String[] args) {
		String exp = "ab*c+";
		convertPostfixToInfix(exp);
	}
	
	private static void convertPostfixToInfix(String exp){
		Stack<String> stack = new Stack<String>();
		for(int i=0; i<exp.length(); i++){
			char c = exp.charAt(i);
			if(isOperand(c)){
				if(!stack.isEmpty()){
					String a = stack.pop();
					if(stack.isEmpty()){
						System.out.println("Invalid expresion");
						return;
					}
					String b = stack.pop();
					stack.push("(" + b + c + a + ")");
				}
			}else{
				stack.push(c+"");
			}
		}
		System.out.println("Infix expression is : " + stack.pop());
	}
	
	private static boolean isOperand(char c){
		if(c=='+' || c == '-' || c == '*' || c =='/' || c == '^'){
			return true;
		}
		return false;
	}
}
