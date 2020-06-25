package com.stack;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		String expression = "a+b*(c^d-e)^(f+g*h)-i + (j*k)";
		String postfix = infixToPostfix(expression);
		System.out.println("Postfix expression is : " + postfix);
	}
	
	private static String infixToPostfix(String expression){
		Stack<Character> operatorStack = new Stack<Character>();
		StringBuffer postfix = new StringBuffer();
		
		for(int i=0; i<expression.length(); i++){
			char c = expression.charAt(i);
			if(Character.isAlphabetic(c)){
				postfix.append(c);
			}else if(c == '('){
				operatorStack.push(c);
			}else if(c == ')'){
				while(!operatorStack.isEmpty() && operatorStack.peek() != '('){
					postfix.append(operatorStack.pop());
				}
				if(!operatorStack.isEmpty()){
					if(operatorStack.peek() != '('){
						System.out.println("Invalid expression");
						break;	
					}else{
						operatorStack.pop();
					}
				}else{
					operatorStack.push(c);
				}
			}else{
				while(!operatorStack.isEmpty() && getPrecedance(c) <= getPrecedance(operatorStack.peek())){
					if(operatorStack.peek() == '(' || operatorStack.peek() == ')'){
						System.out.println("Invalid expression");
						break;
					}
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(c);
			}
		}
		while(!operatorStack.isEmpty()){
			if(operatorStack.peek() == '('){
				System.out.println("Invalid expression");
				break;
			}
			postfix.append(operatorStack.pop());
		}
		return postfix.toString();
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
