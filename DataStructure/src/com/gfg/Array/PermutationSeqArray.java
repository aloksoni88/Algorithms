package com.gfg.Array;

import java.util.ArrayList;
import java.util.Arrays;

//find the kth permutation value
//example for {1,2,3} -> {1,2,3}, {1,3,2}, {2,1,3},{2,3,1},{3,1,2},{3,2,1}
//ans -5th permutation value - {3,1,2}
//https://www.youtube.com/watch?v=W9SIlE2jhBQ- please watch video
public class PermutationSeqArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int[] result = getKthPermutation(arr, 14);
		//System.out.println(Arrays.toString(result));
		
		System.out.println(getPermutation(4, 0));
	}
	
	public static int[] getKthPermutation(int[] arr, int k) {	
		int f = fact(arr.length);
		if(k > f) {
			System.out.println(k + "th element is greater than the number of permutations");
			return null;
		}
		int[] result = new int[arr.length];
		
		int i =0;
		ArrayList<Integer> list = new ArrayList();
	
		
		for(int j=0; j<arr.length; j++) {
			list.add(arr[j]);
		}
		
		while(i < arr.length) {
			int index = k/fact(arr.length-1-i);
			if(k%fact(arr.length-1-i) == 0) {
				index = index-1;
			}
			result[i] = list.get(index);
			list.remove(index);
//			if(list.size() == 1) {
//				result[arr.length-1] =  list.get(0);
//				break;
//			}
			k = k - fact(arr.length-1-i) * index;
			i++;
		}
		return result;
	}
	
	private static int fact(int n) {
		int fact = 1;
		while(n > 0) {
			fact = fact * n;
			n--;
		}
		return fact;
	}
	
	static String getPermutation(int n, int k) {
		if(k > fact(n)){
            return "";
        }
        
        int i=0;
        StringBuffer result = new StringBuffer();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int j=1; j<=n; j++){
            list.add(j);
        }
        if(k==0){
            for(int j=1; j<=n; j++){
                result.append(j);
            }
        }
        while(i < n){
            int index = k/fact(n-1-i);
            if(k%fact(n-1-i) == 0){
                index = index-1;
            }
            result.append(list.get(index));
            list.remove(index);
            
            k = k - fact(n-1-i) * index;
            i++;
        }
        return result.toString();
    }
    
}
