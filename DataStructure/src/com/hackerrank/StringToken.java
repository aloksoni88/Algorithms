package com.hackerrank;

import java.util.Scanner;

public class StringToken {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s != null && s.length() > 0){
            String arr[] = s.split("[( )|(')|(!)|(,)|(?)|(.)|(_)|(@)]");
            
            if(arr != null && arr.length > 0){
            	int count = 0;
            	String[] result = new String[arr.length];
            	for(int i=0; i< arr.length; i++){
            		if(!arr[i].trim().isEmpty()){
            			//System.out.println(arr[i] + " - "+ count);		
            			result[count] = arr[i];
            			count++;
            		}
            	}
            	System.out.println(count);
            	for(String res : result){
            		if(res != null && !res.isEmpty()){
            			System.out.println(res);
            		}
            	}
            	
            }else{
            	System.out.println(0);
            }
        }else{
        	System.out.println(0);
        }
        scan.close();
	}
	
	private static String[] getTokens(String s){
		if(s != null && s.length() > 0){
			if(s.contains(" ")){
				return s.split(" ");
			}
			else if(s.contains("!")){
				return s.split("!");
			}
			else if(s.contains(",")){
				return s.split(",");
			}
			else if(s.contains("?")){
				return s.split("?");
			}
			else if(s.contains(".")){
				return s.split(".");
			}
			else if(s.contains("_")){
				return s.split("_");
			}
			else if(s.contains("'")){
				return s.split("'");
			}
			else if(s.contains("@")){
				return s.split("@");
			}
			return new String[0];
		}else{
			return new String[0];
		}
	}
}
