package com.hackerrank;

import java.util.Arrays;

public class FindNumber {
	public static void main(String[] args) {
		int[] arr = {3,4,1,2,5};
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
		}
		Arrays.sort(arr);
		System.out.println();
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]);
		}
	}
}
