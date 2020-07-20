/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class Permutations {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		List<List<Integer>> result = getPermutations(list);
		
		//int[] arr = {1,2,3};
		//System.out.println(getPermutations(arr));
		System.out.println(result.size());
		System.out.println(result);
	}

	public static List<List<Integer>> getPermutations(List<Integer> array) {
		// Write your code here.
		if(array == null || array.isEmpty()){
			return new ArrayList(array);
		}
		List<List<Integer>> result = new ArrayList<>();
		return permute(array, 0, array.size()-1, result);
	}
	
	public static List<List<Integer>> getPermutations(int[] array) {
		// Write your code here.
		if(array == null || array.length == 0){
			return new ArrayList();
		}
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList();
		for(int i=0; i<array.length; i++) {
			list.add(array[i]);
		}
		return permute(list, 0, list.size()-1, result);
	}
	
	private static List<List<Integer>> permute(List<Integer> list, int l, int r, List<List<Integer>> result){
		if(l >= r) {
			result.add(new ArrayList<>(list));
			return result;
		}
		
		for(int i=l; i<=r; i++) {
			list = i != l ? swap(list,i, l) : list;
			permute(list,l+1,r,result);
			list = i != l ? swap(list,i,l) : list;
		}
		return result;
	}
	
	
	private static List<Integer> swap(List<Integer> list, int l, int r){
		int tmp = list.get(l);
		list.set(l, list.get(r));
		list.set(r, tmp);
		return list;
	}

}
