package com.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CheckAnagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		boolean output = isAnagram(a, b);
		if(output){
			System.out.println("Anagrams");
		}else{
			System.out.println("Not Anagrams");
		}
	}
	
	private static boolean isAnagram(String a,String b){
		boolean isAnagram = false;
		HashMap<Character,Integer> hashMap  = new HashMap();
		if(a != null){
			for(char c : a.toLowerCase().toCharArray()){
				if(hashMap.containsKey(c)){
					int count = hashMap.get(c);
					hashMap.put(c, count+1);
				}else{
					hashMap.put(c, 1);
				}
			}
		}
		if(b != null){
			for(char c : b.toLowerCase().toCharArray()){
				if(hashMap.containsKey(c)){
					int count = hashMap.get(c);
					hashMap.put(c, count-1);
				}else{
					hashMap.put(c, -1);
				}
			}
		}
		if(hashMap != null && !hashMap.isEmpty()){
			for(char c: hashMap.keySet()){
				if(hashMap.get(c) != 0){
					return false;
				}
			}
		}else{
			return false;
		}
		return true;
	}
}
