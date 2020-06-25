package com.stack;

import java.util.Stack;

public class PrefixToPostfix {
	public static void main(String[] args) {
		String exp = "*-A/BC-/AKL";
		convertPrefixToPostfix(exp);
	}
	
	private static void convertPrefixToPostfix(String exp){
		Stack<String> stack = new Stack<String>();
		for(int i= exp.length()-1; i>=0; i--){
			char c = exp.charAt(i);
			if(Utils.isOperatore(c)){
				if(!stack.isEmpty()){
					String a = stack.pop();
					if(stack.isEmpty()){
						System.out.println("Invalid expresion");
						return;
					}
					String b = stack.pop();
					stack.push(a + b + c );
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
		System.out.println("Postfix expression : " + stack.peek());
	}
}
