package sorting;

import java.util.Stack;

import javax.crypto.spec.IvParameterSpec;

public class QuickSort {
	public static void main(String[] args){
		//int[] arr = {48,29,8,59,72,88,42,65,95,19,62,68};
		//int[] arr = {7,23,0,8,1,8,3,45,9,4,10};
		int[] arr = {8,42,3,1,9,10,5,12,0};
		System.out.println("Array without sorting..");
		
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
		//sort(arr);	//sorting using loop
		//sortUsingRecurrsion(arr, 0, arr.length-1);	//sorting using recurresion
		//sort2(arr, 0, arr.length-1);
		//sort3(arr, 0, arr.length-1);
		//sort4(arr, 0, arr.length-1);
		quickSort(arr, 0, arr.length-1);
		System.out.println("Array after sorting...");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		//if pivot is selected is right
		/*
		int pivot = arr[high];
		int pIndex = low;
		
		for(int i=low; i<high; i++) {
			if(arr[i] < pivot) {
				if(arr[i] != arr[pIndex]) {
					swap(arr, i, pIndex);
				}
				pIndex++;
			}
		}
		if(arr[pIndex] != pivot) {
			swap(arr, pIndex, high);
		}
		return pIndex;  */
		
		//if pivot is selected is left
		/*int pivot = low;
		int pIndex = high;
		for(int i=high; i>low; i--) {
			if(arr[i] > arr[pivot]) {
				if(arr[i] != arr[pIndex]) {
					swap(arr, i, pIndex);
				}
				pIndex--;
			}
		}
		swap(arr, pivot, pIndex);
		return pIndex; */
		
		
		//if pivot is selected is middle element
		int pivot = (low + high)/2;
		boolean pivot_placed = false;
		while(!pivot_placed) {
			while(arr[pivot] > arr[low]) {
				low++;
			}
			if(arr[pivot] < arr[low]) {
				swap(arr, pivot, low);
				pivot = low;
			}
			
			while(arr[pivot] < arr[high]) {
				high--;
			}
			if(arr[pivot] > arr[high]) {
				swap(arr,pivot, high);
				pivot = high;
			}
			if(low >= high) {
				pivot_placed = true;
			}
		}
		return pivot;
	}
	
	private static void quickSort(int[] arr,int low, int high) {
		if(low < high) {
			int pIndex = partition(arr, low, high);
			quickSort(arr, low, pIndex-1);
			quickSort(arr, pIndex+1, high);
		}
	}
	
	
	
	/**
	 * When pivot is middle element
	 * @param arr - array
	 * @param low - first index
	 * @param high - last index
	 */
	private static void sort4(int[] arr, int low, int high){
		int left = low;
		int right = high;
		int piv = (low+high)/2;
		
		if(left >= right){
			return;
		}
		boolean pivot_placed = false;
		
		while(!pivot_placed){
			while(arr[piv] > arr[left] && piv != left){
				left = left +1;
			}
			if(piv == left){
				pivot_placed = true;
			}
			if(arr[piv] < arr[left]){
				int tmp = arr[piv];
				arr[piv] = arr[left];
				arr[left] = tmp;
				piv = left;
			}
			
			while(arr[piv] < arr[right] && piv != right){
				right = right-1;
			}
			if(piv == right){
				pivot_placed = true;
			}
			if(arr[piv] > arr[right]){
				int tmp = arr[piv];
				arr[piv] = arr[right];
				arr[right] = tmp;
				piv = right;
			}
		}
		
		display(arr);
		sort4(arr, low, piv-1);
		sort4(arr,piv+1,high);
	}
	
	/**
	 * When piv is last index
	 * @param arr - array
	 * @param low - first index
	 * @param hight - last index
	 */
	private static void sort3(int[] arr, int low, int high){
		int left = low;
		int right = high;
		int piv = right;
		boolean pivot_places = false;
		
		if(left >= right){
			return;
		}
		
		while(!pivot_places){
			while(arr[piv] > arr[left] && piv != left){
				left = left +1;
			}
			if(piv==left){
				pivot_places = true;
			}
			if(arr[left] > arr[piv]){
				int tmp = arr[piv];
				arr[piv] = arr[left];
				arr[left] = tmp;
				piv = left;
			}
			
			while(arr[piv] < arr[right] && piv != right){
				right = right -1;
			}
			if(piv == right){
				pivot_places = true;
			}
			if(arr[right] < arr[piv]){
				int tmp = arr[piv];
				arr[piv] = arr[right];
				arr[right] = tmp;
				piv = right;
			}
			
			display(arr);
			sort3(arr, low, piv-1);
			sort3(arr, piv+1, high);
		}
		
	}
	
	/**
	 * When pivot is the first index
	 * @param arr - array 
	 * @param low - first index 
	 * @param high - last index
	 */
	private static void sort2(int[] arr,int low, int high){
		int left = low;
		int right = high;
		int piv = low;
		if(left >= right){
			return;
		}
		boolean pivot_placed = false;
		while(!pivot_placed){
			while(arr[piv] < arr[right] && piv != right){
				right = right -1;
			}
			if(piv == right){
				pivot_placed = true;
			}
			if(arr[piv] > arr[right]){
				int tmp = arr[piv];
				arr[piv] = arr[right];
				arr[right] = tmp;
				piv  = right;
			}
			
			while(arr[piv] > arr[left] && left != piv){
				left = left+1;
			}
			if(piv == left){
				pivot_placed = true;
			}
			if(arr[piv] < arr[left]){
				int tmp = arr[piv];
				arr[piv] = arr[left];
				arr[left] = tmp;
				piv = left;
			}
		}
		
		display(arr);
		sort2(arr, low, piv-1);
		sort2(arr, piv+1, high);
	}
	
	private static void display(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void sort(int[] arr){
		Stack<Integer> stack = new Stack<Integer>();
		int left = 0;
		int right = arr.length-1;
		int pivot = left;
	
		stack.push(left);
		stack.push(right);
	
		while(!stack.isEmpty()){
			right = stack.pop();
			left = stack.pop();
			pivot = left;	
			
			//these index needed to push element in stack
			int leftIndex = left;
			int rightIndex = right;
		
			
			//If there are only 2 items in array so we dont need to sort as its already sorted
			if(right - left < 2){
				continue;
			}
		
			while(left < right){
				while(arr[pivot] <= arr[right] && pivot != right){
					right = right -1;
				}
				swap(arr, pivot, right);
				pivot = right;
				
				while(arr[pivot] >= arr[left] && pivot != left){
					left = left +1;
				}
			
				swap(arr, pivot, left);
				pivot = left;
			
			}	
		
			/*System.out.println("Pivot " + pivot);
			System.out.println("LeftIndex " + leftIndex);
			System.out.println("RigthIndex " + rightIndex);*/
			
			stack.push(pivot+1);
			stack.push(rightIndex);
	
			stack.push(leftIndex);
			stack.push(pivot-1);
		
		}
	}
	
	public static void swap(int[] arr, int left, int right){
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp; 
	}
	
	public static void sortUsingRecurrsion(int[] arr, int left, int right){
		
		int low = left;
		int high = right;
		
		int pivot = left;
		if(left >= right){
			return;
		}
		
		while(left < right){
			while(arr[pivot] <= arr[right] && pivot != right){
				right--;
			}
			swap(arr, pivot, right);
			pivot = right;
			
			while(arr[pivot] >= arr[left] && pivot != left){
				left++;
			}
			swap(arr, pivot, left);
			pivot = left;
		}
		sortUsingRecurrsion(arr, low, pivot-1);
		sortUsingRecurrsion(arr, pivot+1, high);
	}
}
