package com.clicbrics.locality;

public class Utils {
	public static boolean isEmpty(String s){
		if(s == null || s.trim().isEmpty()){
			return true;
		}
		return false;
	}
}
