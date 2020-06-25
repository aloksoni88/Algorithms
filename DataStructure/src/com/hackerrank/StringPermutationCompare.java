package com.hackerrank;

import java.util.Scanner;

public class StringPermutationCompare {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String  str=sc.next();
		int noOfChar = sc.nextInt();
        String output = getSubstring(noOfChar,str);
        System.out.println(output);
    }
    
    private static String getSubstring(int numberOfChar, String str){
        if(str != null){
            String[] combinationStr = new String[str.length()-numberOfChar+1];
            for(int i=0; i<str.length(); i++){
                if(i+numberOfChar <= str.length()){
                    combinationStr[i] = str.substring(i, i+numberOfChar);
                }
            }
            String output = "";
            if(combinationStr != null && combinationStr.length > 0){
                String max = combinationStr[0], min = combinationStr[0];
                for(int i=0; i< combinationStr.length-1; i++){
                    if(max.compareTo(combinationStr[i+1]) < 0){
                        String tmp = max;
                        max = combinationStr[i+1];
                        combinationStr[i+1] = tmp;
                    }else if(min.compareTo(combinationStr[i+1]) > 0){
                        String tmp = min;
                        min = combinationStr[i+1];
                        combinationStr[i+1] = tmp;
                    }
                }
                output = min + "\n" + max;
            }
            return output;
        }else{
        	return "";
        }
        
    }
}
