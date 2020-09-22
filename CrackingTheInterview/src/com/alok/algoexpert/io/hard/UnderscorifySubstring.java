/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class UnderscorifySubstring {
	public static void main(String[] args) {
		//String str = "testthis is a testtest to see if testestest it works";
		String str = "this is a test to see if it works and test";
		String substring = "test";
		
		String result = underscorifySubstring(str, substring);
		System.out.println(result);
		
	}
	
	private static void displayLocations(List<Integer[]> locations) {
		for(int i=0; i<locations.size(); i++) {
			System.out.print(Arrays.toString(locations.get(i)));
		}
		System.out.println();
	}

	/*
	 * Time Complexity
	 * 		Average Case - O(n+m) 
	 * 		Worst Case - O(n^2 + nm)
	 * 		Best case - O(n) 
	 * Space Complexity - O(n)
	 * 		n - length of Main string
	 * 		m - length of the substring
	 */
	
	public static String underscorifySubstring(String str, String substring) {	
		if(str == null || str.length() == 0) {
			return "";
		}else if(substring == null || substring.length() == 0) {
			return str;
		}else if(!str.contains(substring)) {
			return str;
		}		
		List<Integer[]> locations = getLocations(str, substring);
		displayLocations(locations);
		List<Integer[]> collapseLocations = getCollapseLocations(locations);
		displayLocations(collapseLocations);
		String result = underScorifyString(str, collapseLocations);
		return result;
	}
	
	private static List<Integer[]> getLocations(String str, String substring){
		List<Integer[]> locations = new ArrayList<>();
		int startIndex = 0;
		while(startIndex < str.length()) {
			int index = str.indexOf(substring, startIndex);
			if(index != -1) {
				locations.add(new Integer[] {index, index+substring.length()});
				startIndex = index +1;
			}else {
				break;
			}
		}
		return locations;
	}
	
	private static List<Integer[]> getCollapseLocations(List<Integer[]> locations){
		List<Integer[]> collapseLocations = new ArrayList<>();
		for(int i=0; i<locations.size(); i++) {
			Integer[] locationArr = locations.get(i);
			if(collapseLocations.isEmpty()) {
				collapseLocations.add(locationArr);
			}else {
				Integer[] collapseLocArr = collapseLocations.get(collapseLocations.size()-1);
				if(locationArr[0] <= collapseLocArr[1]) {
					collapseLocArr[1] = locationArr[1];
				}else {
					collapseLocations.add(locationArr);
				}
			}
		}
		return collapseLocations;
	}
	
	private static String underScorifyString(String str, List<Integer[]> locations) {
		String result = "";
		int locIndex = 0;
		Integer[] locArr = locations.get(0);
		for(int i=0; i< str.length(); i++) {
			if(locArr[0] == i || locArr[1] == i) {
				result = result + "_";
			}
			if(i < locArr[1]) {
				result = result + str.charAt(i);
			}else {
				if(locIndex < locations.size()-1) {
					result = result + str.charAt(i);
					locArr = locations.get(++locIndex);
				}else {
					result = result + str.charAt(i);
				}
			}
		}
		//This is to add the underscore at last position of string
		if(locArr[1] == str.length()) {
			result = result + "_";
		}
		return result;
	}
}
