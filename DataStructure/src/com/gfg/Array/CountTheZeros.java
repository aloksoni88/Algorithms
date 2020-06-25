package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountTheZeros {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < noOfTestCase; i++) {
				int size = Integer.parseInt(br.readLine().trim());

				int[] arr = new int[size];
				String str[] = br.readLine().trim().split(" ");
				int count = 0;
				int k=0;
				for (k = size - 1; k >= 0; k--) {
					int value = Integer.parseInt(str[k]);
					if (value == 0) {
						count++;
					} else if (value == 1 && count == 0) {
						builder.append(0 + "\n");
						break;
					}else{
						builder.append(count + "\n");
						break;
					}
				}
				if(k==-1){
					builder.append(count+"\n");
				}
			}
			System.out.println(builder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
