package com.stack;

import java.util.Stack;

public class ExpressionEvaluation {
	public static void main(String[] args) {
		String exp = "100 * ( 2 + 26 * 2 ) / 14 ";
		System.out.println("Result is : " + result(exp));
		
		//tokens = 1,0, ,+, ,2, ,*
		//values = 10,2
		//operator = +,
	}
	
	private static int result(String exp){
		char[] tokens = exp.toCharArray();
		Stack<Integer> values = new Stack();
		Stack<Character> operators= new Stack();
		for(int i=0; i<tokens.length; i++){
			if(tokens[i] == ' '){
				continue;
			}
			else if(Utils.isOperatore(tokens[i])){
				while(!operators.isEmpty() && Utils.getPrecedance(operators.peek()) >= Utils.getPrecedance(tokens[i])){
					values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
				}
				operators.push(tokens[i]);
			}
			else if(tokens[i] == '('){
				operators.push(tokens[i]);
			}
			else if(tokens[i] == ')'){
				while(operators.peek() != '('){
					values.push(applyOperator(operators.pop(),values.pop(),values.pop()));
				}
				operators.pop();
			}else if(tokens[i] >= '0' && tokens[i] <= '9'){
				StringBuffer buf = new StringBuffer();
				while(i<tokens.length && tokens[i] >= '0' && tokens[i] <= '9'){
					buf.append(tokens[i++]);
				}
				values.push(Integer.parseInt(buf.toString()));
			}
			
		}
		
		while(!operators.isEmpty()){
			values.push(applyOperator(operators.pop(),values.pop(),values.pop()));	
		}
		return values.peek();
	}

	private static int applyOperator(char op, int val1, int val2){
		if(op == '+'){
			return val2 + val1;
		}
		else if(op == '-'){
			return val2 - val1;
		}
		else if(op == '*'){
			return val2 * val1;
		}
		else if(op == '/'){
			if(val1 == 0){
				throw new UnsupportedOperationException();
			}
			return val2 / val1;
		}
		else if(op == '^'){
			return val2 ^ val1;
		}
		return -1;

	}
}
