package sorting;

public class InsertionSort {
	public static void main(String[] args){
		int[] arr = {7,23,0,8,1,8,3,45,9,4,10};
		System.out.println("Array without sorting..");
		
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
		sort(arr);	//sorting using loop
		//sortUsingRecurrsion(arr, 1);	//sorting using recurresion
		System.out.println("Array after sorting...");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	public static void sort(int[] arr){
		for(int i=1; i< arr.length; i++){
			for(int j=i; j>0; j--){
				if(arr[j] < arr[j-1]){
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}else {
					break;
				}
			}
		}
	}
	
	public static int[] swap(int[] arr, int index){
		if(index == 0){
			return arr;
		}
		if(arr[index] < arr[index -1 ]){
			int tmp = arr[index];
			arr[index] = arr[index-1];
			arr[index-1] = tmp;
		}
		return swap(arr, index--);
	}
	
	public static void sortUsingRecurrsion(int[] arr, int index){
		if(index == arr.length){
			return;
		}
		for(int j=index; j>0; j--){
			if(arr[j] < arr[j-1]){
				int tmp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = tmp;
			}
		}
		//arr = swap(arr, index);
		sortUsingRecurrsion(arr, index+1);
	}
}
