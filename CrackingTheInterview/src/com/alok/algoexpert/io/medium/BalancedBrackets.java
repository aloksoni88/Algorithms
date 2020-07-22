/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class BalancedBrackets {
	public static void main(String[] args) {
		
	}
	
	public static boolean balancedBrackets(String str) {
	    if(str == null || str.isEmpty()){
					return true;
			}
			Stack<Character> stack = new Stack<Character>();
			char[] charArr = str.toCharArray();
			for(int i=0; i<charArr.length; i++){
					char c = charArr[i];
					if(c == '('  || c == '{' || c == '['){
							stack.push(c);
					}else if(c == ')'){
							if(stack.isEmpty() || stack.pop() != '('){
									return false;
							}
					}else if(c == '}'){
							if(stack.isEmpty() || stack.pop() != '{'){
									return false;
							}
					}else if(c == ']'){
							if(stack.isEmpty() || stack.pop() != '['){
								 return false;
							}
					}
			}
	    return stack.isEmpty();
	  }
}
