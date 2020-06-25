package com.array;

public class Rotation {
	public static void main(String[] args) {
		/*int[] arr = {1,2,3,4,5};
		int[][] ranges = { {0,2}, {0,3}};*/
		int[] arr = {7,8,2,5,9,1,3,6,4};
		int[][] ranges = { {1,8}, {2,5},{0,5}};
		int index = 5;
		int elementIndex = findElement(arr, ranges, index);
		System.out.println("Index " + elementIndex);
		
	}
	
	private static int findElement(int[] arr,int[][] ranges, int index){
		for(int i=0; i< ranges.length; i++){
			int j= ranges[i][1];
			int tmp = arr[ranges[i][1]];
			for( ; j>ranges[i][0];j--){
				arr[j] = arr[j-1];
			}
			arr[j] = tmp;
		}
		
		return arr[index];
	}
}
