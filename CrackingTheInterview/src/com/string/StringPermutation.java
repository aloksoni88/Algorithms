/**
 * 
 */
package com.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class StringPermutation {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String str = "abc";
		list = permute(str, 0, str.length()-1, list);
		System.out.println(list);
	}
	
	private static List<String> permute(String str, int l, int r, List<String> list) {
		if(l >= r) {
			list.add(str);
			//System.out.println(str);
			return list;
		}
		
		for(int i=l; i<=r; i++) {
			str = i != l ? swap(str,i,l): str;
			permute(str, l+1, r, list);
			str = i != l ? swap(str,i,l) : str;
		}
		return list;
	}
	
	private static String swap(String str, int l, int r) {
		char[] arr = str.toCharArray();
		char tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
		return String.valueOf(arr);
	}
}
