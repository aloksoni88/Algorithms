import java.util.Scanner;


public class TakeInput {
	public static void main (String[] args)
	 {
   	Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		
		for(int i=0; i<noOfTestCases; i++){
			int length = sc.nextInt();
			int rotationLength = sc.nextInt();
			int[] arr = new int[length];
			for(int k=0; k<length; k++){
				arr[k] = sc.nextInt();
			}
			rotate(arr, rotationLength);
			
		}
	 }
	 
	public static void rotate(int[] arr, int rotateLength){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<(arr.length-rotateLength); i++){
			builder.append(arr[i+rotateLength] + " ");
		}
		for(int i=0; i<rotateLength; i++){
			builder.append(arr[i] + " ");
		}
		System.out.println(builder);
	}
}
