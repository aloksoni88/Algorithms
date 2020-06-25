package com.gfg.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindMissingNRepeating {
	public static void main(String[] args) {
		//42
		//4 19 2 41 36 30 27 11 18 24 9 16 34 14 40 23 20 25 22 1 33 15 31 21 5 8 37 29 7 12 32 39 6 34 3 10 26 17 13 42 38 35
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] values = br.readLine().trim().split("\\s+");
			int sum = 0;
			for(int i=1; i<42; i++){
				sum = sum + i;
			}
			System.out.println(sum);
			sum = 0;
			for(int i=0; i<42; i++){
				int value = Integer.parseInt(values[i]);
				sum = sum + value;
			}
			System.out.println(sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			StringBuilder builder = new StringBuilder();
			
			for(int k=0; k<noOfTestCase; k++){
			
				
				int size = Integer.parseInt(br.readLine().trim());
				String[] values = br.readLine().trim().split("\\s+");
				HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
				int valueSum = 0, sum = 0,duplicate = -1;
				for(int i=0; i<size; i++){
					int value = Integer.parseInt(values[i]);
					if(map.get(value) == null){
						map.put(value,true);	
					}else{
						builder.append(value + " ");
						duplicate = value;
					}
					sum = sum + (i+1);
					valueSum = valueSum + value;
				}
				int missingItem;
				if(duplicate > (valueSum-sum)){
					missingItem = duplicate - valueSum - sum;
				}else{
					missingItem = valueSum - sum -duplicate;
				}
				builder.append(missingItem + " ");
				
				/*HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
				for(int i=0; i<size; i++){
					int value = Integer.parseInt(values[i]);
					if(map.get(value) == null){
						map.put(value,true);	
					}else{
						builder.append(value + " ");
					}
				}
				
				for(int i=1; i<=size; i++){
					if(map.get(i) == null){
						builder.append(i);
						break;
					}
				}*/
				builder.append("\n");
			}
			System.out.println(builder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
