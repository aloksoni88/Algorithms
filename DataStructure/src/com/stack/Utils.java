package com.stack;

public class Utils {
	public static boolean isOperatore(char c){
		if(c=='+' || c == '-' || c == '*' || c =='/' || c == '^'){
			return true;
		}
		return false;
	}
	
	public static int getPrecedance(char c){
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
	
	public static boolean hasPrecedance(char c1,char c2){
		if(c1 == '(' && c1 == ')'){
			return true;
		}else if(c1 == '*' &&  c1 == '/'){
			return true;
		}else if(c1 == '+' && c1 == '-'){
			return true;
		}else{
			return false;
		}
	}
}
