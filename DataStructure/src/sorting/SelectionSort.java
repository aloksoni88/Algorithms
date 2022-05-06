package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args){
		int[] arr = {7,23,0,8,1,8,3,45,9,4,10};
		System.out.println("Array without sorting..");
		
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
		sort(arr);	//sorting using loop
		//sortUsingRecurrsion(arr, 0);	//sorting using recurresion
		System.out.println("Array after sorting...");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	public static void sort(int[] arr){
		for(int i=0; i< arr.length; i++){
			int smallest = i;
			for(int j = i+1; j<arr.length-1;j++){
				if(arr[smallest] > arr[j]){
					smallest = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = tmp;
			System.out.println("Pass: " + (i+1) + " " +  Arrays.toString(arr));
		}
	}
	
	public static int getSmallestIndex(int[] arr, int minIndex, int index){
		if(index == arr.length){
			return minIndex;
		}
		if(arr[minIndex] > arr[index]){
			minIndex = index;
		}
		return getSmallestIndex(arr, minIndex, index+1);
	}
	
	public static void sortUsingRecurrsion(int[] arr, int index){
		if(index == arr.length -1){
			return;
		}
		/*int smallest = index;
		for(int j = index+1; j<arr.length-1;j++){
			if(arr[smallest] > arr[j]){
				smallest = j;
			}
		}*/
		int smallest = getSmallestIndex(arr, index, index+1);
		int tmp = arr[index];
		arr[index] = arr[smallest];
		arr[smallest] = tmp;
		sortUsingRecurrsion(arr, index+1);
	}
}
