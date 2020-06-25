package com.stack;

import java.util.Stack;

public class ExpressionEvaluation {
	public static void main(String[] args) {
		String expression = "10 + 2 * 6";
		int result = evaluateExpression(expression);
		System.out.println("Result is : " + result);
	}
	
	private static int evaluateExpression(String input) {
		char[] tokens = input.toCharArray(); 
		  
        // Stack for numbers: 'values' 
       Stack<Integer> values = new Stack<Integer>(); 
 
       // Stack for Operators: 'ops' 
       Stack<Character> ops = new Stack<Character>(); 
 
       for (int i = 0; i < tokens.length; i++) 
       { 
            // Current token is a whitespace, skip it 
           if (tokens[i] == ' ') 
               continue; 
 
           // Current token is a number, push it to stack for numbers 
           if (tokens[i] >= '0' && tokens[i] <= '9') 
           { 
               StringBuffer sbuf = new StringBuffer(); 
               // There may be more than one digits in number 
               while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
                   sbuf.append(tokens[i++]); 
               values.push(Integer.parseInt(sbuf.toString())); 
           } 
 
           // Current token is an opening brace, push it to 'ops' 
           else if (tokens[i] == '(') 
               ops.push(tokens[i]); 
 
           // Closing brace encountered, solve entire brace 
           else if (tokens[i] == ')') 
           { 
               while (ops.peek() != '(') 
                 values.push(applyOperator(values.pop(), values.pop(),ops.pop())); 
               ops.pop(); 
           } 
 
           // Current token is an operator. 
           else if (tokens[i] == '+' || tokens[i] == '-' || 
                    tokens[i] == '*' || tokens[i] == '/') 
           { 
               // While top of 'ops' has same or greater precedence to current 
               // token, which is an operator. Apply operator on top of 'ops' 
               // to top two elements in values stack 
               while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
                 values.push(applyOperator(values.pop(), values.pop(),ops.pop())); 
 
               // Push current token to 'ops'. 
               ops.push(tokens[i]); 
           } 
       } 
 
       // Entire expression has been parsed at this point, apply remaining 
       // ops to remaining values 
       while (!ops.empty()) 
           values.push(applyOperator(values.pop(), values.pop(),ops.pop())); 
 
       // Top of 'values' contains result, return it 
       return values.pop(); 
	}
	
	private static int applyOperator(int value2, int value1, char op) {
		switch (op) {
			case '^':
				return (int)Math.pow(value1, value2);	
			case '*':
				return value1 * value2;
			case '/':
				if(value2 == 0) {
					throw new UnsupportedOperationException();
				}
				return value1 / value2;
			case '+':
				return value1 + value2;
			case '-':
				return value1 - value2;
		}
		return 0;
	}
	
	public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
  
}
