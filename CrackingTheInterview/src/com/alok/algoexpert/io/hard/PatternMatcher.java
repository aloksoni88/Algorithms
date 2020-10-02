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
public class PatternMatcher {
	public static void main(String[] args) {
		String pattern = "yxx";
		String str = "yomama";
		String[] matchedPattern = patternMatcher(pattern, str);
		System.out.println(Arrays.toString(matchedPattern));
	}

	//Time - O(n^2 + m)
	//Space - O(n + m) 
	//where n is the length of String and m is the length of pattern
	public static String[] patternMatcher(String pattern, String str) {
		if(pattern.length() > str.length()) {
			return new String[] {};
		}
		boolean isSwitch = false;
		List<String> patternList = getNewPattern(pattern);
		if(!String.valueOf(pattern.charAt(0)).equals(patternList.get(0))) {
			isSwitch = true;
		}
		System.out.println(patternList);
		
		int xCount = (int) patternList.stream().filter(x -> x.equals("x")).count();
		int yCount = (int) patternList.stream().filter(y -> y.equals("y")).count();
		System.out.println("x=" +xCount + ", y=" + yCount);
		
		int firstYPosition = patternList.indexOf("y");
		
		int stringLength = str.length();
		
		if(firstYPosition != -1 ) {
			for(int i=0; i<stringLength; i++) {
				int xLength = i+1;
				int yLength = (stringLength - (xCount * xLength))/yCount;
				if(yLength % 1 != 0) {
					continue;
				}
				
				String xStr = str.substring(0,xLength);
				int yIndex = firstYPosition * xLength;
				if( (yIndex + (int)yLength) > str.length() || yIndex > (yIndex + (int)yLength)) {
					return new String[] {};
				}
				String yStr = str.substring(yIndex,yIndex + yLength);
				
				String matchingStr =  getMatchingString(patternList, xStr, yStr);
				System.out.println(" current str : " + matchingStr);
				if(matchingStr.equals(str)) {
					return isSwitch ? new String[] {yStr, xStr} : new String[] {xStr, yStr};
				}
			}
		}else {
			int xLength = str.length()/pattern.length();
			if(xLength % 1 == 0) {
				String xStr = str.substring(0, xLength);
				String matchingStr =  getMatchingString(patternList, xStr, "");
				if(matchingStr.equals(str)) {
					return isSwitch ? new String[] {"", xStr} : new String[] {xStr, ""};
				}
			}
		}
		
		return new String[] {};
	}
	
	private static String getMatchingString(List<String> pattern, String x, String y) {
		StringBuilder builder = new StringBuilder();
		for(String s : pattern) {
			if(s.equals("x")) {
				builder.append(x);
			}else {
				builder.append(y);
			}
		}
		return builder.toString();
	}
	
	private static List<String> getNewPattern(String pattern) {
		List<String> patternList = new ArrayList<>();
		if(pattern.charAt(0) == 'x') {
			for(int i=0; i<pattern.length(); i++) {
				patternList.add(pattern.charAt(i)+"");
			}	
		}else {
			for(int i=0; i<pattern.length(); i++) {
				if(pattern.charAt(i) == 'x') {
					patternList.add("y");
				}else {
					patternList.add("x");
				}
			}
		}
		return patternList;
	}
}
