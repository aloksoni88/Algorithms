/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;

/**
 * @author Alok Soni
 *
 */
public class ValidIPAddress {
	public static void main(String[] args) {
		String input = "1921680";
		ArrayList<String> ipAddress = validIPAddresses(input);
		System.out.println(ipAddress);
	}

	//Time - O(1), Space- O(1)
	//Because at max we can generate 2^32 bit ip address 
	// 0 -255 i.e 2^8 and we have 2 sectrion which becomes 2^32 i.e why constant time and space comlexity
	public static ArrayList<String> validIPAddresses(String string) {
		if(string == null || string.isEmpty() || string.length() < 4 || string.length() > 12) {
			return new ArrayList<String>();
		}
		String[] currIPAddress = new String[] {"","","",""};	
		ArrayList<String> result = new ArrayList<>();
		for(int i=1; i< Math.min(string.length(), 4); i++) {
			currIPAddress[0] = string.substring(0,i);
			if(!isValid(currIPAddress[0])) {
				continue;
			}
			for(int j= i+1; j< i + Math.min(string.length()-i, 4); j++) {
				currIPAddress[1] = string.substring(i,j);
				if(!isValid(currIPAddress[1])) {
					continue;
				}
				
				for(int k= j+1; k < j+ Math.min(string.length()-j, 4); k++) {
					currIPAddress[2] =string.substring(j,k);
					currIPAddress[3] = string.substring(k);
					if(isValid(currIPAddress[2]) && isValid(currIPAddress[3])) {
						String ipAddress = currIPAddress[0] + "." + currIPAddress[1] 
								+ "." + currIPAddress[2] + "." + currIPAddress[3];
						result.add(ipAddress);
					}
				}
			}
		}
		return result;
	}
	
	private static boolean isValid(String str) {
		int strToInt = Integer.parseInt(str);
		if(strToInt > 255) {
			return false;
		}
		return str.length() == Integer.toString(strToInt).length();
	}
}
