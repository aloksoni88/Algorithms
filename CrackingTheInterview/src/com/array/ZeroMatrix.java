package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] arr = { {1,1,1,0}, {1,1,1,1}, {1,1,0,0}, {1,0,0,0}};
		int[][] zeroMatrix = findZeroMatrix(arr);
		
		System.out.println("Zero matrix is ");
		for(int[] row : zeroMatrix) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	private static int[][] findZeroMatrix(int[][] input){
		int[][] output = input;
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input.length; j++) {
				if(input[i][j] == 0) {
					list.add(i+","+j);
				}
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			int row = Integer.parseInt(list.get(i).split(",")[0]);
			int column = Integer.parseInt(list.get(i).split(",")[1]);
			for(int k=0; k<output.length; k++) {
				output[row][k] = 0;
				output[k][column] = 0;
			}
		}
		return output;
	}
}
