package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NutsNBoltProblem {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			StringBuilder builder = new StringBuilder();
			for(int k=0; k<noOfTestCase; k++){
					
				int size = Integer.parseInt(br.readLine().trim());
				String[] nuts = br.readLine().trim().split("\\s+");
				String[] bolts = br.readLine().trim().split("\\s+");
				nuts = sortArray(nuts);
				bolts = sortArray(bolts);
				String nutsList = "";
				String boltList = "";
				for(int i=0; i<size; i++){
					if(nuts[i].equalsIgnoreCase(bolts[i])){
						nutsList = nutsList + " " + nuts[i];
						boltList = boltList + " " + bolts[i];
					}
				}
				builder.append(nutsList.trim() + "\n");
				builder.append(boltList.trim()+"\n");
			}
			System.out.println(builder);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String[] sortArray(String[] arr){
		Arrays.sort(arr);
		return arr;
	}
}
