package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rotate2DArray {
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			
			for(int k=0; k<noOfTestCase; k++){
				int arrSize = Integer.parseInt(br.readLine().trim());
				
				String[] str = br.readLine().trim().split(" ");
				int[][] arr = new int[arrSize][arrSize];
				int index = 0;
				//int count = 0;
				//String output = "";
				for(int i=arrSize-1; i>=0; i--){
					//String s = "";
					for(int j=0; j<arrSize; j++){
						arr[j][i] = Integer.parseInt(str[index++]);
						//s = s + arr[i][j] + " ";
					}
					//output = s +" " + output;
					//count++;
				}
				//System.out.println(output);
				
				for(int i=0; i<arrSize; i++){
					for(int j=0; j<arrSize; j++){
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
