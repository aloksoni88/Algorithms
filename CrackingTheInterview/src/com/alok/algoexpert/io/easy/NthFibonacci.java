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
		int result = getNthFibonacci(8);
		System.out.println("fibonacci no " + result);
		//0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610
	}

	private static int getNthFibonacci2(int n) {
		if(n <=0) {
			return n;
		}else if(n == 1) {
			return 1;
		}
		return getNthFibonacci(n-1) + getNthFibonacci(n-2);
	}

	private static int getNthFibonacci(int n) {
		if(n < 1) {
			return n;
		}else if(n == 1) {
			return 0;
		}
		int a = 0;
		int b = 1;
		int c = b + a;
		while (n > 2) {
			c = a + b;
			a = b;
			b = c;
			n--;
		}
		return c;
	}
}
