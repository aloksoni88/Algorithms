package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryArraySorting {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			
			for(int k=0; k<noOfTestCase; k++){
				StringBuilder builder = new StringBuilder();		
				int size = Integer.parseInt(br.readLine().trim());
				String[] values = br.readLine().trim().split("\\s+");
				Arrays.sort(values);
				//System.out.println(values);
				for(int i=0; i<size; i++){
					builder.append(values[i] + " ");
				}
//				for(int i=0; i<size/2; i++){
//					String digit1 = values[i];
//					
//					if(digit1.equalsIgnoreCase("0")){
//						output  = 0 + " " + output.trim();
//					}else{
//						output = output.trim() + " " + 1;
//					}
//					String digit2 = values[size-1-i];
//					if(digit2.equalsIgnoreCase("0")){
//						output  = 0 + " " + output.trim();
//					}else{
//						output = output.trim() + " " + 1;
//					}
//				}
//				if(size%2 == 1){
//					if(values[size/2].equalsIgnoreCase("0")){
//						output  = 0 + " " + output.trim();
//					}else{
//						output = output.trim() + " " + 1;
//					}
//				}
				System.out.println(builder+"\n");
				//System.out.println();
			}
			//System.out.println(builder);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
