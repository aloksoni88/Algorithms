package com.hackerrank;

import java.util.ArrayList;

public class CountPalindromSubstring {
	public static void main(String[] args) {
		int result = countPalindromeSubstrings("abbcdcbbabc");
		System.out.println(result);
	}
	
	public static int countPalindromeSubstrings(String s)
    {
		if(s== null || s.isEmpty()){
			return 0;
		}else if(s.length() == 1){
			return 1;
		}
        ArrayList<String> palindromeSubList = new ArrayList();
        for(int i=0;i<s.length();i++)
        {
          for(int j=i+2;j<=s.length();j++)
          {
            String a=s.substring(i,j);
            //countSubs+=count(a);
            String resultStr = isPalindrome(a);
            if(!resultStr.isEmpty()){
            	palindromeSubList.add(resultStr);
            }
          }
        }
        System.out.println(palindromeSubList);
        //return the total no of substring of palindrome and length of string because every signle char of string is a palindrome.
        return palindromeSubList.size()+ s.length();
    }
	
	private static String isPalindrome(String str){
		char[] charArr = str.toCharArray();
		String reverse = "";
		for(int i=charArr.length-1; i>=0; i--){
			reverse = reverse + charArr[i];
		}
		if(str.equals(reverse)){
			return str;
		}else{
			return "";
		}
	}
}
