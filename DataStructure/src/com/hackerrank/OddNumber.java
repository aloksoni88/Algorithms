package com.hackerrank;

import java.util.ArrayList;

public class OddNumber {
	public static void main(String[] args) {
		int[] oddNumbers = OddNumbers(87, 197);
		for(int i=0; i<oddNumbers.length; i++){
			System.out.print(oddNumbers[i] + " ");
		}
	}
	
	private static int[] OddNumbers(int l, int r){
		if(l > r){
			int[] a = {0};
			return a;
		}
		int[] arr = new int[(r-l)/2+1];
		int counter = 0;
		for(int i=l;i<=r;i++){
			if(i%2 != 0){
				arr[counter++] = i; 
			}
		}
		if(counter != arr.length){
			int[] arr2 = new int[counter];
			for(int i=0;i<counter;i++){
				arr2[i] = arr[i];
			}
			return arr2;
		}
		return arr;
	}
}
