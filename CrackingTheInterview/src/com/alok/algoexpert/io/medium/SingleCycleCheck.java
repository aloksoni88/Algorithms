/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class SingleCycleCheck {
	public static void main(String[] args) {
//		int[] arr = { 10, 11, -6, -23, -2, 3, 88, 908, -26 };
		int[] arr = {1,3,-2,2,-1,3};
//		boolean hasCycle = hasSingleCycle(arr);
		boolean hasCycle = isSingleCyclic(arr);
		System.out.println(hasCycle);
	}

	// optimized space time complexity to constant space
	public static boolean hasSingleCycleOptimized(int[] array) {
		if (array == null || array.length == 0) {
			return false;
		}

		int jumpIndex = 0;
		int count = 1;
		do {
			jumpIndex = (jumpIndex + array[jumpIndex]) % array.length;
			if (jumpIndex >= 0) {
				count++;
			} else {
				jumpIndex = array.length + jumpIndex;
				count++;
			}
		} while (jumpIndex != 0 && count <= array.length);
		if (jumpIndex != 0 || count != array.length + 1) {
			return false;
		}
		return true;
	}

	public static boolean hasSingleCycle(int[] array) {
		if (array == null || array.length == 0) {
			return false;
		}
		boolean[] tmpArr = new boolean[array.length];

		int jumpIndex = 0;
		tmpArr[0] = true;
		do {
			jumpIndex = (jumpIndex + array[jumpIndex]) % array.length;
			if (jumpIndex >= 0) {
				if (tmpArr[jumpIndex]) {
					break;
				}
				tmpArr[jumpIndex] = true;
			} else {
				jumpIndex = array.length + jumpIndex;
				if (tmpArr[jumpIndex]) {
					break;
				}
				tmpArr[jumpIndex] = true;
			}
		} while (jumpIndex != 0);
		if (jumpIndex != 0) {
			return false;
		}
		for (int i = 0; i < tmpArr.length; i++) {
			if (!tmpArr[i]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isSingleCyclic(int[] arr){
		boolean[] isVisited = new boolean[arr.length];
		int index = 0;
		isVisited[index] = true;
		do{
			index = (index + arr[index]) % arr.length;
			if(index >= 0){
				if(isVisited[index]){
					break;
				}
				isVisited[index] = true;
			}else{
				index = arr.length + index;
				if(isVisited[index]){
					break;
				}
				isVisited[index] = true;
			}
		}while(index != 0);
		if(index != 0) {
			return false;
		}
		for(int i=0; i<arr.length; i++) {
			if(!isVisited[i]) {
				return false;
			}
		}
		return true;
	}

}
