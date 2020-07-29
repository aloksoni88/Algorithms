/**
 * 
 */
package com.alok.algoexpert.io.easy;

/**
 * @author Alok Soni
 *
 */
public class NthFibonacci {
	public static void main(String[] args) {
		int result = getNthFibonacci(6);
		System.out.println("fibonacci no " + result);
	}

//	private static int getNthFibonacci(int n) {
//		if(n <=0) {
//			return n;
//		}else if(n == 1) {
//			return 1;
//		}
//		return getNthFibonacci(n-1) + getNthFibonacci(n-2);
//	}

	private static int getNthFibonacci(int n) {
		if(n==1){
			return 0;
		}
		n = n-1;
		int a = 0;
		int b = 1;
		int c = b + a;
		while (n > 1) {
			c = a + b;
			a = b;
			b = c;
			n--;
		}
		return c;
	}
}
