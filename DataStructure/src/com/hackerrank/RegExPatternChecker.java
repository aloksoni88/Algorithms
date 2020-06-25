package com.hackerrank;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExPatternChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      String result = "";
	      while(testCases>0){
	         String pattern = in.nextLine();
	         boolean isException = false;
	         try{
	        	 Pattern p = Pattern.compile(pattern);	 
	         }catch(Exception e){
	        	 //e.printStackTrace();
	        	 isException = true;
	        	 //System.out.println("Invalid");
	        	 if(result.isEmpty()){
	        		 result = "Invalid";
	        	 }else{
	        		 result = result+"\n"+"Invalid";
	        	 }
	         }
	         if(!isException){
	        	 //System.out.println("Valid");
	        	 if(result.isEmpty()){
	        		 result = "Valid";
	        	 }else{
	        		 result = result+"\n"+"Valid";
	        	 }
	         }
	         testCases--;
	      }
	      System.out.println(result);
	}
}
