package sorting;

public class BubbleSort {
	
	public static void main(String[] args){
		int[] arr = {7,23,0,8,1,8,3,45,9,4,10};
		System.out.println("Array without sorting..");
		
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
		sort(arr);	//sorting using loop
		//sortUsingRecurrsion(arr, arr.length);	//sorting using recurresion
		System.out.println("Array 4after sorting...");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	public static void sort(int[] arr){
		if(arr == null){
			System.out.println("No element in array to sort");
		}else if(arr.length == 1){
			System.out.println("Only 1 element in array " + arr[0]);
		}else{
			//int[] tmpArr = new int[arr.length];
			for(int i=0; i<arr.length; i++){
				for(int j=0; j<arr.length - i-1; j++){
					if(arr[j] > arr[j+1]){
						arr[j] = arr[j] + arr[j+1];
						arr[j+1] = arr[j] - arr[j+1];
						arr[j] = arr[j] - arr[j+1];
					}
				}
			}
		}
	}
	
	public static void sortUsingRecurrsion(int[] arr, int length){
		if(length == 1){
			return;
		}
		
		for(int i=0; i<length-1; i++){
			if(arr[i] > arr[i+1]){
				arr[i] = arr[i] + arr[i+1];
				arr[i+1] = arr[i] - arr[i+1];
				arr[i] = arr[i] - arr[i+1];
			}
		}
		sortUsingRecurrsion(arr, length-1);
	}
}
