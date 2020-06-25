package com.gfg.Array;

public class ClockwiceRotation {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int[] resultArr = clockwiseRotate(arr,4);
		PrintArray.printArray(resultArr);

	}
	
	private static int[] clockwiseRotate(int[] arr, int rotateBy){
		if(rotateBy > arr.length){
			rotateBy = rotateBy%7;
		}
	
		for(int k=0; k<rotateBy; k++){
			int i=0;
			int tmp = arr[arr.length-1];
			for(i=arr.length-1; i>0; i--){
				arr[i] = arr[i-1];
			}
			arr[i] = tmp;
		}
		return arr;
	}
}
