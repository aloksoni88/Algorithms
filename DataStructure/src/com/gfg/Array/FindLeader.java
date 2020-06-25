package com.gfg.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class FindLeader {
	public static void main (String[] args)
	 {
		try {
			BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); 
			
			int noTstCase = Integer.parseInt(br.readLine().trim());
			
			for(int i=0; i<noTstCase; i++){
			    int length = Integer.parseInt(br.readLine().trim());
			    
			    int[] arr = new int[length];
			    String[] str= br.readLine().trim().split(" ");
		    	
			    for(int j=0; j<length; j++){
			    	arr[j] = Integer.parseInt(str[j]);
			    }
			    
			    /*for(int j=0; j<length; j++){
			        System.out.println(arr[j] + " ");
			    }*/
			    //findLeader(arr);
			    //findLeaderOptimized(arr);
			    findLeaderRecurrsive(arr,arr.length-2,arr[arr.length-1],(arr[arr.length-1]+ " "));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 }
	
	
	public static void findLeaderRecurrsive(int[] arr, int length, int leader, String str){
		if(length == -1){
			System.out.println(str);
			return;
		}
		if(leader <= arr[length]){
			leader = arr[length];
			str = leader + " " + str;
		}
		findLeaderRecurrsive(arr, length-1, leader,str);
	}
	 
	public static void findLeaderOptimized(int[] arr){
		int len = arr.length;
		int leader = arr[len-1];
		String str = leader + "";
		for(int i=len-2; i>=0; i--){
			if(leader <= arr[i]){
				leader = arr[i];
				str = leader + " " + str;
			}
		}
		System.out.println(str);
	}
	
	 public static void findLeader(int[] arr){
	     StringBuilder builder = new StringBuilder();
	     int leader = -1;
	     int j=0;
	     int length = arr.length;
	     for(int i=0; i<length-1; i++){
	    	 leader = arr[i];
	    	 if(leader < arr[length-1]){
	    		 continue;
	    	 }
	         for(j=i+1; j<length-1; j++){
	             if(leader < arr[j]){
	                 break;
	             }
	         }
	         if(j==length-1){
	             builder.append(leader + " ");
	         }
	     }
	     builder.append(arr[length-1]);
	     
	     System.out.println(builder);
	 }
	 
}
