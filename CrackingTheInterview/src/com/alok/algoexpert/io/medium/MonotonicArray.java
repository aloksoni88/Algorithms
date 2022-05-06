/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class MonotonicArray {
	public static void main(String[] args) {
		int[] array = { -1, 1, -10, -1100, -1100, -1101, -1102, -9001 };

		boolean result = isMonotonic2(array);
		System.out.println(result);
	}

	public static boolean isMonotonic(int[] array) {
		if (array == null || array.length <= 2) {
			return true;
		}
		boolean isDec = false;
		boolean isInc = false;
		for (int i = 0; i < array.length - 1; i++) {
			if (!isInc && !isDec) {
				if (array[i] < array[i + 1]) {
					isInc = true;
				} else if (array[i] > array[i + 1]) {
					isDec = true;
				}
			} else {
				if (isInc && array[i] > array[i + 1]) {
					return false;
				} else if (isDec && array[i] < array[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isMonotonic2(int[] arr){
		boolean isDec = false;
		boolean isInc = false;
		
		for(int i=0; i< arr.length-1; i++){
			if(!isDec && !isInc){
				if(arr[i] < arr[i+1]){
					isInc = true;
				}else if(arr[i] > arr[i+1]){
					isDec = true;
				}
			}
			else if(isDec && arr[i] >= arr[i+1]){
				continue;
			}
			else if(isInc && arr[i] <= arr[i+1]){
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

}
