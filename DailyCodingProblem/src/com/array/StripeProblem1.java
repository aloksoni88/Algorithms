package com.array;

public class StripeProblem1 {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10,77,11};
		int ans = findSmallestPositive(arr);
		System.out.println("Smallest positve no is " + ans);
	}
	
	private static int findSmallestPositive(int[] arr){
		boolean[] present = new boolean[arr.length+1];
		for(int i=0; i<arr.length; i++){
			if(arr[i] > 0 && arr[i] <= arr.length){
				present[arr[i]] = true;
			}
		}
		for(int i=1; i<present.length;i++){
			if(!present[i]){
				return i;
			}
		}
		return arr.length+1;
	}
}
