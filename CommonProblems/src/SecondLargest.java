
public class SecondLargest {
	public static void main(String[] args){
		//int[] arr = {4,6,18,56,2,7,8,2,11};
		int[] arr = {-4,-6,-18,-56,-1,-7,-8,-3,-11,1,6,12,0};
		//int[] arr = {6,8,1};

		if(arr.length == 0){
			System.out.println("array is empty!");
		}else if(arr.length == 1) {
			System.out.println("largest element is : " + arr[0]);
		}else{
			int largest = Integer.MIN_VALUE;
			int secondLargest = Integer.MIN_VALUE;
			for(int i=0; i< arr.length; i++){
				if(arr[i] > largest){
					secondLargest = largest;
					largest = arr[i];
				}else if(arr[i]> secondLargest){
					secondLargest = arr[i];
				}
			}
			System.out.println("Second largest no is : " + secondLargest);
		}
	}
}
