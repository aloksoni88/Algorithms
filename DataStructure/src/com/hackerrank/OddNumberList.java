package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class OddNumberList {
	public static void main(String[] args) {
		int l = 2, r = 5;
		int[] output = findOddNumber(l, r);
		if(output != null && output.length > 0){
			for(int i=0; i<output.length; i++){
				System.out.print(output[i] + " ");
			}
		}
		
	}
	
	private static int[] findOddNumber(int l, int r){
		List<Integer> outputList = new ArrayList();

        for(int i=l ; i<=r; i++){
        	if(i%2 !=0){
        		outputList.add(i);
        	}
        }
        if(outputList != null && outputList.size() > 0){
        	int[] output = new int[outputList.size()];
			for(int j=0; j<outputList.size(); j++){
				output[j] = outputList.get(j);
			}
			return output;
		}
        return null;
	}
}
