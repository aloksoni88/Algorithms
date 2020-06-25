package com.stack;

import java.util.Stack;

public class PrefixToInfix {
	public static void main(String[] args) {
		String exp = "*-A/BC-/AKL";
		convertPrefixToInfix(exp);
	}
	
	private static void convertPrefixToInfix(String exp){
		Stack<String> stack = new Stack<String>();
		for(int i=exp.length()-1; i>=0; i--){
			char c = exp.charAt(i);
			if(isOperand(c)){
				if(!stack.isEmpty()){
					String a = stack.pop();
					if(stack.isEmpty()){
						System.out.println("Invalid expresion");
						return;
					}
					String b = stack.pop();
					stack.push("(" + a + c + b + ")");
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
