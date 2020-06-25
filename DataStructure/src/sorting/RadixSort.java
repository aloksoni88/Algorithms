package sorting;

import java.util.ArrayList;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {0,3456,233,14,209,345,8,567,328,163};
		sort(arr);
	}
	
	private static void sort(int[] arr){
		int arrLength = 0;
		for(int i=0; i<arr.length;i++){
			if((arr[i]+"").length() > arrLength){
				arrLength = (arr[i]+"").length();
			}
		}
		
		ArrayList<Integer>[] listArr = new ArrayList[10];
		for(int k=0; k<arrLength; k++){
			for(int i=0; i<arr.length; i++){
				char[] charArr = (arr[i]+"").toCharArray();
				int numLength = charArr.length-1-k;
				int index = 0;
				if(numLength < 0){
					numLength = charArr.length-1;
					index = 0;
				}else{
					index = Integer.parseInt(charArr[numLength]+"");
				}
				if(listArr[index] == null){
					listArr[index] = new ArrayList<Integer>();
				}
				listArr[index].add(arr[i]);
			}	
			int index = 0;
			for(int i=0; i<listArr.length;i++){
				ArrayList<Integer> list = listArr[i];
				if(list != null && !list.isEmpty()){
					for(int num : list){
						arr[index++] = num;
					}
				}
			}
			for(int i=0; i<10; i++){
				listArr[i] = null;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
