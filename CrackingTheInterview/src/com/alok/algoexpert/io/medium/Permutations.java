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
//		System.out.println(result.size());
//		System.out.println(result);
//		
		int[] arr = {1,2,3,4};
		List<int[]> res = permute(arr, 0, arr.length-1, new ArrayList<int[]>());
		System.out.println(res);
		for(int i=0; i<res.size(); i++) {
			System.out.print(Arrays.toString(res.get(i))+", ");	
		}
//		
//		ArrayList<int[]> test = new ArrayList<int[]>();
//		for(int i=0; i<4; i++) {
//			if(i==0) {
//				arr[i] = 10;
//			}else if (i==1) {
//				arr[i] = 20;
//			}else if (i==2) {
//				arr[i] = 30;
//			}else if (i==3) {
//				arr[i] = 40;
//			}
//			test.add(i,arr.clone());
//		}
//		for(int i=0; i<test.size(); i++) {
//			System.out.print(Arrays.toString(test.get(i))+", ");	
//		}
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
	
	private static ArrayList<int[]> permute(int[] arr, int left, int right, ArrayList<int[]> result){
		if(left >= right) {
			result.add(arr.clone());
			return result;
		}
		for(int i=left; i<=right; i++) {
			arr = i != left ? swap(i, left, arr) : arr;
			permute(arr, left+1, right, result);
			arr = i != left ? swap(i, left, arr): arr;
		}
		return result;
	}

	private static int[] swap(int a, int b, int[] arr) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return arr;
	}
}
