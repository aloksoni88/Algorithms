/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class MergeSortedArrays {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 9, 21)); 
		List<Integer> list2 = new ArrayList<>(Arrays.asList(-1,0));
		List<Integer> list3 = new ArrayList<>(Arrays.asList(-124, 81, 121));
		List<Integer> list4 = new ArrayList<>(Arrays.asList(3, 6, 12, 20, 150));		
		List<List<Integer>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		
		List<Integer> result = mergeSortedArrays(list);
		System.out.println(result);
			
	}
	
	//Time - O(nk), Space - O(n+k)
	//where n is total number of array elements & k is the number of arrays
	public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
		if(arrays == null || arrays.isEmpty()) {
			return new ArrayList<>();
		}
		if(arrays.size() == 1) {
			return arrays.get(0);
		}
		List<Integer> sortedList = new ArrayList<>();				
		int[] indexArr = new int[arrays.size()];
		Arrays.fill(indexArr, 0);		
		while(true) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			int processArrCount = 0;
			for(int i=0; i<indexArr.length; i++) {
				List<Integer> currentList = arrays.get(i);
				if(indexArr[i] < currentList.size()) {
					if(currentList.get(indexArr[i]) < min) {
						min = currentList.get(indexArr[i]);
						minIndex = i;					
					}
				}else {
					processArrCount++;
				}
			}
			if(processArrCount == arrays.size()) {
				break;
			}
			indexArr[minIndex]++;
			sortedList.add(min);
		}
		return sortedList;
	}

	//Time - O(nk), space - O(n+k) 
	//where n is the number element in an array and k is the no of arrays
	public static List<Integer> mergeSortedArrays2(List<List<Integer>> arrays) {
		if(arrays == null || arrays.isEmpty()) {
			return new ArrayList<>();
		}
		if(arrays.size() == 1) {
			return arrays.get(0);
		}
		List<Integer> result = new ArrayList<>();
		result.addAll(arrays.get(0));
		for(int i=1; i<arrays.size(); i++) {
			result = merger(result, arrays.get(i));
			System.out.println(result);
		}
		return result;
	}
	
	private static List<Integer> merger(List<Integer> list1, List<Integer> list2){
		int i=0, j=0;
		List<Integer> mergeList = new ArrayList<>();
		while(i < list1.size() && j < list2.size()) {
			if(list1.get(i) < list2.get(j)) {
				mergeList.add(list1.get(i));				
				i++;
			}else {
				mergeList.add(list2.get(j));				
				j++;
			}
		}
		while(i < list1.size()) {
			mergeList.add(list1.get(i));
			i++;			
		}
		while(j < list2.size()) {
			mergeList.add(list2.get(j));
			j++;		
		}
		return mergeList;
	}
}
