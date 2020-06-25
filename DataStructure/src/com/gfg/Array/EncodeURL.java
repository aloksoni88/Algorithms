package com.gfg.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncodeURL {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTestCase = Integer.parseInt(br.readLine().trim());
			for(int k=0; k<noOfTestCase; k++){
				StringBuilder builder = new StringBuilder();		
				String str = br.readLine().trim();
				String encodedStr = encodeBase62(Long.parseLong(str));
				builder.append(encodedStr +"\n");
				String decodedStr = decodeBase62(encodedStr);
				builder.append(decodedStr);
				System.out.println(builder);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String encodeBase62(long num){
		String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String text = "";
		while(num > 0 ){
			text =  code.charAt((int)(num%code.length())) + text;
            num = num/code.length();
		}
        return text;
	}
	
	public static String decodeBase62(String text) throws IOException {
        String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        long num = 0;
        int j = text.length();
        for(int i=0; i<j; i++){
        	num  = num + (long)(code.indexOf(text.charAt(j-i-1))*Math.pow(code.length(), i));
        }
        return ""+num;
    }
}
