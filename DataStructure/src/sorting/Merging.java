package sorting;

public class Merging {
	public static void main(String[] args) {
		int[] arr1 = {5,8,22,30,36};
		int[] arr2 = {4,9,25,28,34,40,42};
		merging(arr1, arr2);
	}
	
	private static void merging(int[] arr1, int[] arr2){
		if(arr1 == null && arr2 == null){
			System.out.println("No item to sort");
		}else if(arr1 == null){
			System.out.println(arr2);
		}else if(arr2 == null){
			System.out.println(arr1);
		}
		
		int arr[] = new int[arr1.length + arr2.length];
		int i=0,j=0,k=0;
		while(i< arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				arr[k++] = arr1[i++];
			}else{
				arr[k++] = arr2[j++];
			}
		}
		if(i==arr1.length){
			while(j <arr2.length){
				arr[k++] = arr2[j++];
			}
		}else if(j == arr2.length){
			while(i <arr1.length){
				arr[k++] = arr1[i++];
			}
		}
		
		for(i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
