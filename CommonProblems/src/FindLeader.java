import java.util.Stack;


public class FindLeader {
	//Leader - A leader is called when its all forword element are less than then its called leader
	// {19,25,3,4,5,2};
	//here leaders are : 25,5,2
	//last element always a leader as there is no element after that
	
	public static void main(String[] args) {
		int[] arr = {3,6,7,9,10,11};
		
		for(int i=0; i<arr.length-1; i++){
			int max = arr[i];	
			for(int k = i+1; k<arr.length; k++){
				if(max < arr[k]){
					max = -1;
				}
				if(k == arr.length-1 && max != -1){
					System.out.println(max);
				}
			}
		}
		System.out.println(arr[arr.length-1]);
	}
	
}
