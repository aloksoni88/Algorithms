package com.gfg.Array;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[][] arr = {{2,4,6},{10,13,19},{1,3,5}};
		ArrayList<Integer> list = mergeKArrays(arr, 3);
		System.out.println(list);
	}
	
	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int size) 
    {
        ArrayList<Integer> mergeList = new ArrayList<Integer>();

        int[] outputArr = new int[size*size];
        outputArr = arrays[0];
        for(int i=1; i<size; i++){
        	int[] arr = arrays[i];
        	/*for(int k=0; k<arr.length; k++){
        		mergeList.add(arr[k]);
        	}*/
        	outputArr = mergeSortedArray(arr,outputArr,size*(i+1));
        }
        for(int i=0; i<outputArr.length;i++){
        	mergeList.add(outputArr[i]);
        }
        
        //mergeSort(mergeList, 0, mergeList.size()-1);
        return mergeList;
    }
	
	private static int[] mergeSortedArray(int[] arr, int[] outputArr, int size){
		int i=0;
		int j=0;
		int k=0;
		int[] tmp = new int[size];
		while(i<arr.length && j<outputArr.length){
			if(arr[i] < outputArr[j]){
				tmp[k++] = arr[i++];
			}else{
				tmp[k++] = outputArr[j++];
			}
		}
		while(i<arr.length){
			tmp[k++] = arr[i++];
		}
		while(j<outputArr.length && tmp.length <=size){
			tmp[k++] = outputArr[j++];
		}
		return tmp;
	}
	
	private static void mergeSort(ArrayList<Integer> list,int low, int high){
		
		if(low != high){
			int mid = (low+high)/2;
			mergeSort(list, low, mid);
			mergeSort(list, mid+1, high);
			merge(list,low,mid,high);
		}
	}
	
	private static void merge(ArrayList<Integer> list, int low, int mid, int high){
		int i= low;
		int j = mid+1;
		int k =low;
		int tmp[] = new int[list.size()];
		while(i<= mid && j <= high){
			if(list.get(i) < list.get(j)){
				tmp[k++] = list.get(i++);
			}else{
				tmp[k++] = list.get(j++);
			}
		}
		while(i<=mid){
			tmp[k++] = list.get(i++);
		}
		while(j <= high){
			tmp[k++] = list.get(j++);
		}
		for(i = low; i<= high; i++){
			list.set(i,tmp[i]); 
		}
	}
}
