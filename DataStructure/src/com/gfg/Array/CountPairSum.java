package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountPairSum {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			StringBuilder builder = new StringBuilder();
			for(int k=0; k<noOfTestCase; k++){
				String[] str = br.readLine().trim().split("\\s+");
				int size = Integer.parseInt(str[0]);
				int sum = Integer.parseInt(str[1]);
				int sumCount = 0;
				
				String[] values = br.readLine().trim().split("\\s+");
				for(int i=0; i<size; i++){
					for(int j=i+1; j<size; j++){
						int s = Integer.parseInt(values[i]) + Integer.parseInt(values[j]);
						if(s == sum){
							sumCount++;
						}
					}
				}
				builder.append(sumCount+"\n");
			}
			System.out.println(builder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
