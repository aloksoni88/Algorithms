package com.stack;

import java.util.Stack;

public class InfixToPrefix {
	public static void main(String[] args) {
		String infixExpression = "(a-b/c)*(a/k-l)";		
		convertInfixToPrefix(infixExpression);
	}
	
	private static void convertInfixToPrefix(String expression){
		Stack<Character> stack = new Stack<Character>();
		String prefix = "";
		for(int i=expression.length()-1; i>=0; i--){
			if(Character.isAlphabetic(expression.charAt(i))){
				prefix = prefix + expression.charAt(i);
			}else if(expression.charAt(i) == ')'){
				stack.push(expression.charAt(i));
			}else if(expression.charAt(i) == '('){
				while(!stack.isEmpty() && stack.peek() != ')'){
					prefix = prefix + stack.pop();
				}
				if(!stack.isEmpty() && stack.peek() == '('){
					System.out.println("Invalid expression");
					return;
				}
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else{
				if(!stack.isEmpty()){
					if(stack.peek() == '('){
						System.out.println("Invalid expression");
						return;
					}
					while(!stack.isEmpty() && getPrecedance(expression.charAt(i)) < getPrecedance(stack.peek())){
						prefix = prefix + stack.pop();
					}
				}
				stack.push(expression.charAt(i));
			}
		}
		
		while(!stack.isEmpty()){
			if(!stack.isEmpty() && stack.peek() == '('){
				System.out.println("Invalid expression");
				return;
			}
			prefix = prefix + stack.pop();
		}
		System.out.println("Prefix Expression is : " + new StringBuilder(prefix).reverse());
	}
	
	private static int getPrecedance(char c){
		if(c == '^'){
			return 3;
		}else if(c == '*' ||  c == '/'){
			return 2;
		}else if(c == '+' || c == '-'){
			return 1;
		}else{
			return 0;
		}
	}
}
