package com.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SumOfElementOfKLength {
	private static ArrayList<String> list = new ArrayList<String>();
	private static HashSet<String> elementList = new HashSet();
	static boolean[] alpha = new boolean[26];
	public static void main(String[] args) {
		try {
			System.out.println("============= Input Instructions ==================");
			System.out.println("Don't use duplicate element in array");
			System.out.println("Please provide array element with space separated in first line");
			System.out.println("Please provide sum of element in second line");
			System.out.println("Please provide no of element for which you want sum in third line");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputArrStr =br.readLine().trim();
			if(inputArrStr == null || inputArrStr.isEmpty()){
				System.out.println("input array is empty");
				return;
			}
			String sumStr = br.readLine().trim();
			if(sumStr == null || sumStr.isEmpty()){
				System.out.println("sum element is empty");
				return;
			}
			String kStr = br.readLine().trim();
			if(kStr == null || kStr.isEmpty()){
				System.out.println("element count value is empty");
				return;
			}
			String[] inputArr = inputArrStr.split(" ");
			int[] arr = new int[inputArr.length];
			for(int i=0; i<inputArr.length; i++){
				arr[i] = Integer.parseInt(inputArr[i]);
			}
			int sum = Integer.parseInt(sumStr);
			int k = Integer.parseInt(kStr);
			printAllKLength(arr, k);
			
			System.out.println("total no of item : " + list.size());
			//System.out.println(list);
			
			if(!list.isEmpty()){
				for(int i=0; i<list.size(); i++){
					String element = list.get(i);
					checkSum(element, sum);
				}
				System.out.println("Total no of group which creates sum of " + sum + " is " + elementList.size());
				System.out.println(elementList);
			}else{
				System.out.println("No elements found which create sum of " + sum);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("input value is wrong");
		}
		//printAllKLengthString(str,"");
	}
	

	static void printAllKLength(int[] arr, int k) 
	{ 
	    int n = arr.length;  
	    printAllKLengthRec(arr, "", n, k); 
	} 
	  
	static void printAllKLengthRec(int[] arr,  String prefix,  int n, int k) 
	{ 
	    if (k == 0){
	    	boolean isDiscarded = discardDuplicatesCharString(prefix);
	    	if(!isDiscarded){
	    		list.add(prefix);
	    	}else{
	    		//System.out.println("discarded : " + prefix);
	    	}
	    	//System.out.println(prefix);
	        return; 
	    } 
	    for (int i = 0; i < n; ++i) 
	    { 
	    	int val = arr[i];
	    	String newPrefix = prefix.isEmpty() ? prefix + val : prefix + "," + val;
	        printAllKLengthRec(arr, newPrefix,  n, k - 1);
	    } 
	} 
	
	static void printAllKLengthString(String str, String ans){
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			String ros = str.substring(0,i) + str.substring(i+1);
			System.out.println(ros);
			/*if(ros.length() == 2){
				System.out.println(ros);
			}else{
				printAllKLengthString(ros, ans+ch);
			}*/
		}
	}
	
	private static String swap(String str){
		char a = str.charAt(0);
		char b = str.charAt(1);
		return ""+b+a;
	}

	private static boolean discardDuplicatesCharString(String prefix){
		HashSet<String> set = new HashSet<String>();
		String[] str = prefix.split(",");
		for(int i=0; i<str.length; i++){
			set.add(str[i]);
		}
		if(set.size() == str.length){
			return false;
		}else{
			return true;
		}
	}
	
	private static boolean checkSum(String prefix, int sum){
		int result = 0;
		String[] str = prefix.split(",");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<str.length; i++){
			result = result  + Integer.parseInt(str[i]);
			list.add(Integer.parseInt(str[i]));
		}
		if(result == sum){
			Collections.sort(list);
			String s = "";
			for(int i=0; i<list.size(); i++){
				s = s + list.get(i) + " ";
			}
			elementList.add(s);
			return true;
		}
		return false;
	}
}
