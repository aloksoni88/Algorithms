/**
 * 
 */
package com.alok.dp.matrixchainmultiplication;

import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */

/***
 * 	################## Question #####################
 * 
 *  Check if a string is a scrambled form of another string
	Given two strings S1 and S2 of equal length, the task is to determine if S2 is a scrambled form of S1.

	Scrambled string:
	Given string str, we can represent it as a binary tree by partitioning it to two non-empty substrings recursively.

	Note: Srambled string is not same as an Anagram

	Below is one possible representation of str = “coder”:
	
	    coder
	   /    \
	  co    der
	 / \    /  \
	c   o  d   er
	           / \
	          e   r
	To scramble the string, we may choose any non-leaf node and swap its two children.
	Suppose, we choose the node "co" and swap its two children, it produces a scrambled string "ocder".
	
	
	
	
	    ocder
	   /    \
	  oc    der
	 / \    /  \
	o   c  d   er
	           / \
	          e   r
	Thus, “ocder” is a scrambled string of “coder”.
	
	Similarly, if we continue to swap the children of nodes “der” and “er”, it produces a scrambled string “ocred”.
	
	    ocred
	   /    \
	  oc    red
	 / \    /  \
	o   c  re  d
	       / \
	      r   e
	Thus, “ocred” is a scrambled string of “coder”.
	
	Examples:
	
	Input: S1=”coder”, S2=”ocder”
	Output: Yes
	Explanation:
	“ocder” is a scrambled form of “coder”
	
	Input: S1=”abcde”, S2=”caebd”
	Output: No
	Explanation:
	“caebd” is not a scrambled form of “abcde”
 * 
 */
public class ScrambledString {
	private static HashMap<String,Boolean> map;
	public static void main(String[] args) {
		String a = "great";
		String b = "rgeat";
		if( (a == null || a.isEmpty()) &&  (b == null || b.isEmpty())){
			System.out.println("Output : " + true);
		}else if(a.length() != b.length()) {
			System.out.println("Output : " + false);
		}
		//boolean isScrabmledStr = isScramleRecursive(a, b);
		
		map = new HashMap<>();
		boolean isScrabmledStr = isScramleMemoize(a, b);
		System.out.println("Output : " + isScrabmledStr);
	}
	
	private static boolean isScramleMemoize(String a, String b) {
		if(a.equalsIgnoreCase(b)) {
			return true;
		}else if(a.length() <= 1) {
			return false;
		}
		int length = a.length();
		boolean flag = false;
		if(map.containsKey(a+"_"+b)) {
			return map.get(a+"_"+b);
		}
		for(int i=1; i<length; i++) {
			if(isScramleMemoize(a.substring(0,i), b.substring(length-i,length)) 
					&& isScramleMemoize(a.substring(i,length), b.substring(0,length-i))) {
				flag = true;
				break;
			}else if(isScramleMemoize(a.substring(0,i), b.substring(0,i)) 
					&& isScramleMemoize(a.substring(i,length), b.substring(i,length))) {
				flag = true;
				break;
			}
		}
		map.put(a+"_"+b, flag);
		return flag;
	}
	
	private static boolean isScramleRecursive(String a, String b) {
		if(a.equalsIgnoreCase(b)) {
			return true;
		}else if(a.length() <= 1) {
			return false;
		}
		int length = a.length();
		
		boolean flag = false;
		for(int i=1; i<length; i++) {
			if(isScramleRecursive(a.substring(0,i), b.substring(length-i,length)) 
					&& isScramleRecursive(a.substring(i,length), b.substring(0,length-i))) {
				flag = true;
				break;
			}else if(isScramleRecursive(a.substring(0,i), b.substring(0,i)) 
					&& isScramleRecursive(a.substring(i,length), b.substring(i,length))) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
