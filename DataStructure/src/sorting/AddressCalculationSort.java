package sorting;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class AddressCalculationSort {
	public static void main(String[] args) {
		int arr[] = {194,-214,49,115,10,4345,33,89,16,0,66,-1,9456,-35};
		//sort(arr);
		addressCalSort(arr);
	}
	
	private static int getAddressIndex(int value,int maxValue) {
		//int index = floow((value/maximum)*size);
		int index = (int) Math.floor((value/maxValue)*10);
		if(index == 10) {
			return index-1;
		}
		return index;
	}
	
	public static void addressCalSort(int[] arr) {
		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
		int maxValue = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			list.add(new LinkedList<Integer>());
			if(arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		System.out.println("Max value is : " + maxValue);
		
		for(int i=0; i<arr.length; i++) {
			int index = getAddressIndex(arr[i],maxValue);
			LinkedList<Integer> linkedList = list.get(index);
			if(linkedList.isEmpty()) {
				linkedList.add(arr[i]);
			}else {
				int counter =0;
				for(int x : linkedList) {
					if(arr[i] > x) {
						counter++;
					}else {
						break;
					}
				}
				linkedList.add(counter, arr[i]);
			}
		}
		
		for(LinkedList<Integer> linkedList : list) {
			if(!linkedList.isEmpty()) {
				for(int i : linkedList) {
					System.out.print(i + ", ");
				}
			}
		}
	}
}