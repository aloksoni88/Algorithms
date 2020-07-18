/**
 * 
 */
package com.alok.dp.matrixchainmultiplication;

/**
 * @author Alok Soni
 *
 */

/****
 * #################### Question ####################### 
 * Given an array p[]
 * which represents the chain of matrices such that the ith matrix Ai is of
 * dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that
 * should return the minimum number of multiplications needed to multiply the
 * chain.
 *
 */
public class MatrixChainMultiplication {
	//private static int min = Integer.MAX_VALUE;
	private static int[][] t;
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,3};
		//int[] arr = {1,2,3,4};
		t = new int[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				t[i][j] = -1;
			}
		}
		//int min = getMCMRecursive(arr, 1, arr.length-1);
		int min = getMCMMemoize(arr, 1, arr.length-1);
		System.out.println("Min no of multiplication : " + min);
	}
	
	private static int getMCMRecursive(int[] arr, int i, int j) {
		if(i >= j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k= i; k< j; k++) {
			int temp = getMCMRecursive(arr, i, k) 
						+ getMCMRecursive(arr, k+1, j)
						+ (arr[i-1] * arr[k] * arr[j]);
			if(temp < min) {
				min = temp;
			}
		}
		return min;
	}
	
	private static int getMCMMemoize(int[] arr, int i, int j) {
		if(i >= j) {
			return 0;
		}
		if(t[i][j] != -1) {
			return t[i][j];
		}
		int min = Integer.MAX_VALUE;
		for(int k= i; k< j; k++) {
			int temp = getMCMRecursive(arr, i, k) 
						+ getMCMRecursive(arr, k+1, j)
						+ (arr[i-1] * arr[k] * arr[j]);
			if(temp < min) {
				min = temp;
			}
		}
		return t[i][j] = min;
	}
}
