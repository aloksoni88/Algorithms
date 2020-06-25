package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class GoogleProblem1 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] input = br.readLine().trim().split(",");
			String numStr = br.readLine().trim();
			if(numStr == null || numStr.isEmpty()){
				System.out.println(false);
				return;
			}
			int num = Integer.parseInt(numStr);
			boolean isAdd = addUpTo(input, num);
			System.out.println(isAdd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean addUpTo(String[] input, int num){
		if(input == null || input.length == 0){
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<input.length; i++){
			if(input[i].trim().isEmpty()){
				continue;
			}
			int n = Integer.parseInt(input[i].trim());
			if(set.contains(n)){
				return true;
			}else{
				set.add(num - n);
			}
		}
		return false;
	}
}
