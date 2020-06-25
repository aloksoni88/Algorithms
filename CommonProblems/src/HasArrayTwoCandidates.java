
public class HasArrayTwoCandidates {
	static int[] helper;
	static int[] arr = {5,2,1,4,0,11,8,84,30,16,7};
	public static void main(String[] args){

		int sum = 15;
		int totalPairCount=0;
		
		//sort(arr);
		int length = arr.length;
		helper = new int[length];
		mergeSort(0, length-1);

		System.out.println("Sorted Array is : ");
		for(int i=0; i< length; i++){
			System.out.print(arr[i] + " ");
		}
	
		System.out.println();
		int left = 0;
		int right = arr.length-1;
		while(left < right){
			if( (arr[left] + arr[right]) == sum ){
				System.out.println(" Pair indexes is : " + left + " & " + right);
				left++;
				right--;
				totalPairCount++;
			}else if((arr[left] + arr[right]) < sum){
				left++;
			}else{
				right--;
			}
		}
		System.out.println("Total no of pair count : " + totalPairCount);

	}
	
	private static void mergeSort(int low, int high){
		if(low < high){
			int middle = (low + high)/2;
			
			mergeSort(low, middle);
			mergeSort(middle+1, high);
			merge(low,middle,high);
		}
	}
	
	private static void merge(int low, int middle, int high) {
		for(int i=low; i<= high; i++){
			helper[i] = arr[i];
		}
		
		int i=low;
		int j = middle+1;
		int k = low;
		
		while(i <= middle && j <= high){
			if(helper[i] < helper[j]){
				arr[k] = helper[i];
				i++;
			}else{
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i<= middle){
			arr[k] = helper[i];
			k++;
			i++;
		}
	}
}
