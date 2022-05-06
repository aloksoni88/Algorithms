package sorting;

public class MergeSort {
	public static void main(String[] args){
		int[] arr = {7,23,0,8,1,8,3,45,9,4,10};
		//int[] arr = {5,7,2,4,3,9};
		System.out.println("Array without sorting..");
		
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
		//sort2(arr);	//sorting using loop
		sortUsingRecurrsion(arr, 0,arr.length-1);	//sorting using recurresion
		//mergeSort(arr);
		//mergeSort2(arr);
		System.out.println("Array after sorting...");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	private static void mergeSort2(int[] arr){
		int l1=0,l2=0,h1=0,h2 =0, i=0,j=0;
		int[] tmp = new int[arr.length];
		int k=0;
		for(int size = 1; size<arr.length; size = size*2){
			l1 = 0;
			k=0;
			while((l1+size) <arr.length){
				h1 = l1 + size-1;
				l2 = h1 +1;
				h2 = l2+size-1;
				if(h2 >= arr.length){
					h2 = arr.length-1;
				}
				i=l1;
				j=l2;
				while(i<=h1 && j<=h2){
					if(arr[i] < arr[j]){
						tmp[k++] = arr[i++]; 
					}else{
						tmp[k++] = arr[j++];
					}
				}
				//for any pair left so we have to just copy the elements
				while(i<=h1){
					tmp[k++] = arr[i++];
				}
				while(j<=h2){
					tmp[k++] = arr[j++];
				}
				l1 = h2+1;
			}
			
			for(i=l1; k<arr.length; i++){
				tmp[k++] = arr[i];
			}
			for(i=0; i<tmp.length; i++){
				arr[i] = tmp[i];
			}
		}
		
		System.out.println("Sorted array using iteration:");
		for(i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void mergeSort(int[] arr){
		if(arr == null){
			return;
		}
		if(arr.length > 1){
			int mid = arr.length/2;
			int[] left = new int[mid];
			int[] right = new int[arr.length-mid];
			
			for(int i=0; i<mid; i++){
				left[i] = arr[i];
			}
			for(int i=mid; i<arr.length; i++){
				right[i-mid] = arr[i];
			}
			
			mergeSort(left);
			mergeSort(right);
			int i=0;
			int j=0; 
			int k=0;
			
			while(i<left.length && j<right.length){
				if(left[i] < right[j]){
					arr[k++] = left[i++];
				}else{
					arr[k++] = right[j++];
				}
			}
			while(i<left.length){
				arr[k++] = left[i++];
			}
			while(j<right.length){
				arr[k++] = right[j++];
			}
		}
		/*for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}*/
	}
	
	//One method to sort
	public static void sort(int[] arr){
		int n= arr.length;
		int l1,l2,h1,h2,i=0,j=0,k=0;
		int[] tmp = new int[n];
		for(int size=1; size<n; size=size*2){
			l1 = 0;
			k =0;
		
			while(l1+size < n){
				h1 = l1 + size-1;
				l2 = h1 + 1;
				h2 = l2 + size-1;
				
				if(h2 >= n){
					h2 = n-1;
				}
				
				i = l1;
				j = l2;
				while(i <= h1 && j <= h2){
					if(arr[i] < arr[j]){
						tmp[k++] = arr[i++];
					}else{
						tmp[k++] = arr[j++];
					}
				}
				while(i <= h1){
					tmp[k++] = arr[i++];
				}
				while(j <= h2){
					tmp[k++] = arr[j++];
				}
				
				l1 = h2+1;
			}
			
			for(i = l1; k<n; i++){
				tmp[k++] = arr[i];
			}
			
			for(int x=0; x<n; x++){
				arr[x] = tmp[x];
			}
		}
	}
	
	public static void sort2(int[] arr){
		int n = arr.length;
		
		for(int size = 1; size < n; size = 2*size){
			for(int low = 0; low < n-1; low = low + 2*size){
				int mid = Math.min(low + size-1, n-1);
				int high = Math.min(low + 2*size-1, n-1);
				merge(arr, low, mid, high);
			}
		}
	}
	
	private static void merge(int[] arr, int low, int mid, int high){
		int i= low;
		int j = mid +1;
		int k = low;
		int[] tmp = new int[arr.length];
		
		while(i <= mid && j<= high){
			if(arr[i] < arr[j]){
				tmp[k++] = arr[i++];
			}else{
				tmp[k++] = arr[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = arr[i++];
		}
		while(j <= high){
			tmp[k++] = arr[j++];
		}
		
		for(i = low; i<= high; i++){
			arr[i] = tmp[i]; 
		}
	}
	
	public static void sortUsingRecurrsion(int[] arr, int low, int high){
		//System.out.println(low + "," + high);
		int mid;
		if(low != high){
			mid= (low+high)/2;
			//System.out.println(low + ","+ mid + "," + high);
			sortUsingRecurrsion(arr, low, mid);
			sortUsingRecurrsion(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
}
