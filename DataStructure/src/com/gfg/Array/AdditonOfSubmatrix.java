package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdditonOfSubmatrix {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			
			for(int i=0; i<noOfTestCase; i++){
				String[] size = br.readLine().trim().split(" ");
				int row = Integer.parseInt(size[0]);
				int column = Integer.parseInt(size[1]);
				
				int[][] arr = new int[row][column];
				String line = br.readLine().trim();
				String[] str = line.split(" ");
				
				int count =0;
				for(int x=0; x<row; x++){
					for(int y=0; y<column; y++){
						arr[x][y] = Integer.parseInt(str[count++]);
						//System.out.print(arr[x][y] + " ");
					}
					//System.out.println();
				}
				String[] cellInfo = br.readLine().trim().split(" ");				
				additionMatrix(arr, cellInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void additionMatrix(int[][] arr, String[] cellInfo){
		int row = Integer.parseInt(cellInfo[0]);
		int rowSize = Integer.parseInt(cellInfo[2]);
		int column = Integer.parseInt(cellInfo[1]);
		int columnSize = Integer.parseInt(cellInfo[3]);
		int sum = 0;
		for(int i=row-1; i<= rowSize-1 ; i++){
			for(int j=column-1; j<=columnSize-1; j++){
				sum = sum + arr[i][j];
			}
		}
		System.out.println(sum);
	}
}
