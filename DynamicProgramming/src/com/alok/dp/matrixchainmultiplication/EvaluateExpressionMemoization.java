/**
 * 
 */
package com.alok.dp.matrixchainmultiplication;

import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */

/**
 * ###################### Question #######################
 * 
 * Boolean Parenthesization Problem | DP-37 
 * Given a boolean expression with following symbols.
 * 
 * Symbols 'T' ---> true 
 * 			'F' ---> false And 
 * following operators filled between symbols
 * 
 * Operators 
 * 	& ---> boolean AND 
 * 	| ---> boolean OR 
 * 	^ ---> boolean XOR 
 * Count the number of ways we can parenthesize the expression so that the value of
 * expression evaluates to true.
 * 
 * Let the input be in form of two arrays one contains the symbols (T and F) in
 * order and other contains operators (&, | and ^}
 * 
 * Examples:
 * 
 * Input: symbol[] = {T, F, T} 
 * operator[] = {^, &} 
 * Output: 2 
 * The given expression is "T ^ F & T", it evaluates true in two ways 
 * "((T ^ F) & T)" and "(T ^ (F & T))"
 * 
 * Input: symbol[] = {T, F, F} 
 * operator[] = {^, |} Output: 2 
 * The given expression is "T ^ F | F", it evaluates true in two ways 
 * "( (T ^ F) | F )" and "( T ^ (F | F) )".
 * 
 * Input: symbol[] = {T, T, F, T} 
 * operator[] = {|, &, ^} 
 * Output: 4 The given
 * expression is "T | T & F ^ T", it evaluates true in 4 ways 
 * ((T|T)&(F^T)),(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
 */
public class EvaluateExpressionMemoization {
	//static int ans = 0;
	private static HashMap<String, Integer> map;
	public static void main(String[] args) {
		char[] symbol = "TTFT".toCharArray();
		char[] operator = "|&^".toCharArray();
		String str = "";
		int opCounter = 0;
		for(int i=0; i<symbol.length; i++) {
			str = str + symbol[i];
			if(opCounter < operator.length) {
				str = str + operator[opCounter];
			}
			opCounter++;
			
		}
		
		str = "T^T^T^F|F&F^F|T^F^T";
		System.out.println("String is " + str);
		map = new HashMap<>();
		int output = solveMemoize(str, 0, str.length()-1,true);
		System.out.println("Output : " + output);
		System.out.println("Map size " + map.size());
	}
	
	
	private static int solveMemoize(String str, int i, int j, boolean isTrue) {
		if(i > j) {
			return 0;
		}
		
		if(i == j) {
			if(isTrue == true) {
				if (str.charAt(i) == 'T') {
					map.put(j+"_" + j +"_" + isTrue, 1);
					return 1;
				}else {
					map.put(j+"_" + j +"_" + isTrue, 0);
					return 0;
				}
			}
			else {
				if (str.charAt(i) == 'F') {
					map.put(j+"_" + j +"_" + isTrue, 1);
					return 1;
				}else {
					map.put(j+"_" + j +"_" + isTrue, 0);
					return 0;
				}
			}
		}
		if(map.containsKey(i+"_"+j+"_"+isTrue)) {
			return map.get(i+"_"+j+"_"+isTrue);
		}
		
		int ans = 0;
		for(int k=i+1; k<j ; k = k+2) {
			int leftTrue = solveMemoize(str, i, k - 1, true);
			int leftFalse = solveMemoize(str, i, k - 1, false);
			int rightTrue = solveMemoize(str, k + 1, j, true);
			int rightFalse = solveMemoize(str, k + 1, j, false);

			if(str.charAt(k) == '&') {
				if(isTrue == true) {
					ans = ans + leftTrue * rightTrue;
				}else {
					ans = ans 
							+ leftTrue * rightFalse 
							+ rightTrue * leftFalse 
							+ leftFalse * rightFalse;
				}
			}else if(str.charAt(k) == '|') {
				if(isTrue == true) {
					ans = ans 
							+ leftTrue * rightFalse 
							+ rightTrue * leftFalse 
							+ leftTrue * rightTrue; 
				}else {
					ans = ans + leftFalse * rightFalse;
				}
			}else if(str.charAt(k) == '^') {
				if(isTrue == true) {
					ans = ans 
							+ leftTrue * rightFalse 
							+ rightTrue * leftFalse;
				}else {
					ans = ans 
							+ leftTrue * rightTrue 
							+ leftFalse * rightFalse;
				}
			}
		}
		map.put(i+"_"+j+"_"+isTrue,ans);	
		return ans;
	}
}
