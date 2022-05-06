/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class MoveElementToEnd {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		list.add(1);
//		list.add(2);
//		list.add(2);
//		list.add(2);
//		list.add(4);
//		list.add(5);
//		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		int[] arr = {2,1,2,2,2,3,4,7};
//		List<Integer> result = moveElementToEnd(list, 9);
//		System.out.println(result);
		int[] result = moveToEnd2(arr, 2);
		System.out.println(Arrays.toString(result));
	}
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		if (array == null || array.isEmpty()) {
			return array;
		}

		//first implementation
//		int counter = array.get(0) == toMove ? 1 : 0;
//		for (int i = 1; i < array.size(); i++) {
//			if (array.get(i) != toMove) {
//				if (counter != 0) {
//					array.set(i - counter, array.get(i));
//				}
//			} else {
//				counter++;
//			}
//		}
//		for (int i = 0; i < counter; i++) {
//			array.set(array.size() - i-1, toMove);
//		}
		
		//second implementation
		int index = 0;
		for(int i=0; i< array.size(); i++) {
			if(array.get(i) != toMove) {
				if(i != index) {
					int tmp = array.get(i);
					array.set(i, array.get(index));
					array.set(index, tmp);
				}
				index++;
			}
		}
		return array;
	}
	
	private static int[] moveToEnd(int[] arr, int toMove){
		int moveIndex = 0;
		int count =0;
		for(int i=0; i< arr.length; i++){
			if(arr[i] == toMove){
				count++;
			}else{
				arr[moveIndex++] = arr[i];
			}
		}
		for(int i=0; i<count; i++){
			arr[moveIndex+i] = toMove;
		}
		return arr;
	}
	
	private static int[] moveToEnd2(int[] arr, int toMove){
		int moveIndex = 0;
		for(int i=0; i< arr.length; i++){
			if(arr[i] != toMove) {
				int tmp = arr[i];
				arr[i] = arr[moveIndex];
				arr[moveIndex++] = tmp;
			}
		}
		return arr;
	}

}
