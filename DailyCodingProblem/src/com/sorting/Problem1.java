package com.sorting;

import com.sun.scenario.effect.Merge;

public class Problem1 {
	public static void main(String[] args) {
		//int[][] arr = { {10,15,20}, {12,14,16}, {13,19,22}};
		int[][] arr = {{1},{1,3,5},{1,10,20,30,40}};
		
		if(arr == null || arr.length == 0){
			System.out.println("array is empty");
			return;
		}
		int[] arr1 = arr[0];
		for(int i=1; i<arr.length; i++){
			arr1 = merge(arr1, arr[i]);
		}
		if(arr1 != null && arr1.length != 0){
			System.out.println("sorted elements");
			for(int i=0; i<arr1.length; i++){
				System.out.print(arr1[i] + " ");
			}
		}else{
			System.out.println("list is empty");
		}
	}
	
	private static int[] merge(int[] arr1, int[] arr2){
		if(arr1 == null && arr2 == null){
			return null;
		}else if(arr1.length == 0 && arr2.length == 0){
			int[] mergedArr = new int[0];
			return mergedArr;
		}else if(arr1.length == 0 && arr2.length > 0){
			return arr2;
		}else if(arr1.length > 0 && arr2.length == 0){
			return arr1;
		}else{
			int[] mergedArr = new int[arr1.length + arr2.length];
			int i=0,j=0,k=0;
			while(i < arr1.length && j < arr2.length){
				if(arr1[i] < arr2[j]){
					mergedArr[k++] = arr1[i++];
				}else{
					mergedArr[k++] = arr2[j++];
				}
			}
			while(i < arr1.length){
				mergedArr[k++] = arr1[i++];
			}
			while(j < arr2.length){
				mergedArr[k++] = arr2[j++];
			}
			return mergedArr;
		}
	}
}
