/**
 * 
 */
package com.alok.company.coding.problems;

import java.util.ArrayList;

/**
 * @author Alok Soni
 *
 */
public class PrisonBreakProblem {
	public static void main(String[] args) {
		long result = prison(10, 10, new ArrayList<>(), new ArrayList<>());
		System.out.println(result);
	}
	
	private static long prison(int n, int m , ArrayList<Integer> H, ArrayList<Integer> V) {
		boolean[] xs = new boolean[n+1];
		boolean[] ys = new boolean[m+1];
		
		for(int h: H) {
			xs[h] = true;
		}
		for(int v: V) {
			ys[v] = true;
		}
		
		int x=0,y=0;
		for(int i=1, j=0; i<= n; i++) {
			if(!xs[i]) {
				j=0;
			}else {
				x = Math.max(x, ++j);
			}
		}
		
		for(int i=1, j=0; i<= n; i++) {
			if(!ys[i]) {
				j=0;
			}else {
				x = Math.max(y, ++j);
			}
		}
		
		return (long)((x+1)*(y+1));
	}
}
