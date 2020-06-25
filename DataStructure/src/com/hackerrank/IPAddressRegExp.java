package com.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressRegExp {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String ip = sc.next();
		
			System.out.println(ip.matches(new IPAddressValidator().pattern));
		}
	}
}

 class IPAddressValidator{
	private Pattern mPattern;
	private Matcher matcher;
	
	private static final String IP_ADDRESS_PATTER =  "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
	public  final String pattern =  "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	
	public IPAddressValidator(){
		mPattern = Pattern.compile(IP_ADDRESS_PATTER);
	}
	
	public boolean validateIPAddress(final String ipAddress){
		matcher = mPattern.matcher(ipAddress);
		return matcher.matches();
	}
}
