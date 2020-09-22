/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */
public class InterweavingStrings {
	public static void main(String[] args) {
		String one = "algoexpert";
		String two = "your-dream-job";
		String three = "your-algodream-expertjob";
		
		boolean result = interweavingStrings(one, two, three);
		System.out.println(result);
	}
	
	//Time - O(mn) when m & n is the length of first string and second string respectively
	//Space - O(mn)
	public static boolean interweavingStrings(String one, String two, String three) {
		if(three.length() != (one.length() + two.length())) {
			return false;
		}
		HashMap<String,Boolean> map= new HashMap<>();
		return interweavingStrings(one, two, three,0,0, map);
	}
	
	private static boolean interweavingStrings(String one, String two, String three, 
													int i, int j,HashMap<String,Boolean> map) {
		if(map.get(i+"_"+j) != null){
			return map.get(i+"_"+j);
		}
		int k = i+j;
		System.out.println("i="+i  + ", j="+ j + ", k=" + k);
		if(k == three.length()) {
			map.put(i+"_"+j, true);
			return true;
		}
		if(i < one.length() && one.charAt(i) == three.charAt(k)) {
			if(interweavingStrings(one, two, three,i+1,j,map)) {
				map.put(i+"_"+j,true);
				return true;
			}
		}
		if(j < two.length() && two.charAt(j) == three.charAt(k)) {
			boolean flag = interweavingStrings(one, two, three,i,j+1,map);
			map.put(i+"_"+j,flag);
			return flag;
		}
		map.put(i+"_"+j,false);
		System.out.println(map.size());
		return false;
	}

	//Time - O(2^(m+n)) when m & n is the length of first string and second string respectively
	//Space - O(m+n)
//	public static boolean interweavingStrings(String one, String two, String three) {
//		if(three.length() != (one.length() + two.length())) {
//			return false;
//		}
//		return interweavingStrings(one, two, three,0,0);
//	}
//	
//	private static boolean interweavingStrings(String one, String two, String three, int i, int j) {
//		int k = i+j;
//		System.out.println("i="+i  + ", j="+ j + ", k=" + k);
//		if(k == three.length()) {
//			return true;
//		}
//		if(i < one.length() && one.charAt(i) == three.charAt(k)) {
//			if(interweavingStrings(one, two, three,i+1,j)) {
//				return true;
//			}
//		}
//		if(j < two.length() && two.charAt(j) == three.charAt(k)) {
//			return interweavingStrings(one, two, three,i,j+1);
//		}
//		return false;
//	}
}
