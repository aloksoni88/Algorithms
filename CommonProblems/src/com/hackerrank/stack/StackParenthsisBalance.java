package com.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author mehar
 * 
 * 
In computer science, a stack or LIFO (last in, first out) is an abstract data type that
serves as a collection of elements, with two principal operations: push, 
which adds an element to the collection, and pop, which removes the last element that was added.(Wikipedia)


A string containing only parentheses is balanced if the following is true: 
1. if it is an empty string 
2. if A and B are correct, AB is correct, 
3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})" 

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
 *
 */
public class StackParenthsisBalance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      
	      while (sc.hasNext()) {
	         String input=sc.next();
	         System.out.println();
	         System.out.println(isBalanced(input));
	      }
	}
	
	private static boolean isBalanced(String str){
		if(str != null){
			Stack<Character> stack = new Stack<Character>();
			StringBuffer extraChar = new StringBuffer();
			if(str.contains("(") || str.contains(")") || str.contains("{") || str.contains("}")
					|| str.contains("[") || str.contains("]")){
				char[] charArr = str.toCharArray();
				for(int i=0; i<charArr.length; i++){
					if(charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '['){
						//System.out.println("push " + charArr[i]);
						stack.push(charArr[i]);
					}else if(charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']'){
						if(!stack.isEmpty()){
							/*while(stack.peek() != '[' || stack.peek() != '{' || stack.peek() != '('){
								stack.pop();
								//System.out.println(stack.peek());
							}*/
							if(charArr[i] == ')' && stack.peek() == '('){
								//System.out.println("pop " + stack.pop());
								stack.pop();
							}else if(charArr[i] == '}' && stack.peek() == '{'){
								stack.pop();
								//System.out.println("pop " + stack.pop());
							}else if(charArr[i] == ']' && stack.peek() == '['){
								stack.pop();
								//System.out.println("pop " + stack.pop());
							}else{
								extraChar.append(charArr[i]);
							}
						}
						else{
							extraChar.append(charArr[i]);
						}
					}
				}
				if(stack.isEmpty() && extraChar.toString().isEmpty()){
					return true;
				}else{
					return false;	
				}
			}else if(str.isEmpty()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
