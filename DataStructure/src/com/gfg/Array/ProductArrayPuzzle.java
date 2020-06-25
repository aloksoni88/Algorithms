package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProductArrayPuzzle {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			
			for(int k=0; k<noOfTestCase; k++){
				StringBuilder builder = new StringBuilder();		
				int size = Integer.parseInt(br.readLine().trim());
				String[] values = br.readLine().trim().split("\\s+");
				int[] arr = new int[size];
				arr[0] = Integer.parseInt(values[0]);
				int product = arr[0];
				for(int i=0; i<size-1; i++){
					arr[i+1] = Integer.parseInt(values[i+1]);
					product = product*arr[i+1];
				}
				for(int i=0;i<size; i++){
					arr[i] = product/arr[i];
					builder.append(arr[i] + " ");
				}
				System.out.println(builder );
					
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
