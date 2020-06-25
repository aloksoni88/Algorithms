
public class FindElement {
	public static void main(String[] args) {
		int[] arr = {3,0,2,9,49,4,8,21,5,11,12,18,28,99,93,31,24,56,111,75};
		System.out.println("index is " + findElement(arr, 100));
	}
	
	private static int findElement(int[] arr, int n){
		for(int i=0; i<(arr.length/2)+1; i++){
			if(arr[i] == n ){
				return i;	
			}else if(arr[arr.length-i-1] == n){
				return (arr.length-i-1);
			}
		}
	
		return -1;
	}
}
