package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GreaterOnRightSide {
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			StringBuilder builder = new StringBuilder();
			for(int k=0; k<noOfTestCase; k++){
				int size = Integer.parseInt(br.readLine().trim());
				String[] str = br.readLine().trim().split(" ");
				int[] arr = new int[size];
				for(int i=0; i<size; i++){
					arr[i] = Integer.parseInt(str[i]);
				}
				String output = nextGreatestElement(arr, size);
				builder.append(output + "\n");
			}
			
			System.out.println(builder);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String nextGreatestElement(int[] arr, int size){
		int greatestElement = arr[size-1];
		StringBuilder builder = new StringBuilder();
		String output = "-1";
		for(int i=size-2; i>=0; i--){
			if(arr[i] < greatestElement){
				output = greatestElement + " " + output;
			}else{
				output = greatestElement + " " + output;
				greatestElement = arr[i];
			}
		}
		return output;
	}
	
}
