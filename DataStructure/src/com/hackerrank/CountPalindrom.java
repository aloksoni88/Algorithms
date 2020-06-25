package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountPalindrom {
	public static void main(String[] args) {
		int result = countPalindromeSubstrings("abbcdcbbabc");
		//int result = palindromes("abccba");
		System.out.println(result);
	}
	
	public static int countPalindromeSubstrings(String s)
    {
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
	
	
	
	
    public static int count(String a)
    {
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=a.charAt(a.length()-1-i))
                return 0;
        	/*if(a.charAt(i)==a.charAt(a.length()-1-i)){
                return 1;
        	}*/
        }
        return 1;
    }
	
    static int palindromes(final String input) {

        final ArrayList<String> result= new ArrayList();
    	
        for (int i = 0; i < input.length(); i++) {
            expandPalindromes(result,input,i,i+1);
            expandPalindromes(result,input,i,i);
        }
        System.out.println(result);
        return result.size();
        
     }

     static void expandPalindromes(final ArrayList<String> result, final String s, int i, int j) {
         while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
               result.add(s.substring(i,j+1));
        	 	
               i--; j++;
         }
     }
	private static int countPalindromes(String s){
		char str[] = s.toCharArray();
		int n = s.length();
		int dp[][] = new int[n][n];
	      
        // P[i][j] = true if substring str[i..j] is palindrome,
        // else false
        boolean P[][] = new boolean[n][n];
      
        // palindrome of single lenght
        for (int i= 0; i< n; i++)
            P[i][i] = true;
      
        // palindrome of length 2
        for (int i=0; i<n-1; i++)
        {
            if (str[i] == str[i+1])
            {
                P[i][i+1] = true;
                dp[i][i+1] = 1 ;
            }
        }
      
        // Palindromes of length more then 2. This loop is similar
        // to Matrix Chain Multiplication. We start with a gap of
        // length 2 and fill DP table in a way that gap between
        // starting and ending indexes increases one by one by
        // outer loop.
        for (int gap=2 ; gap<n; gap++)
        {
            // Pick starting point for current gap
            for (int i=0; i<n-gap; i++)
            {
                // Set ending point
                int j = gap + i;
      
                // If current string is palindrome
                if (str[i] == str[j] && P[i+1][j-1] )
                    P[i][j] = true;
      
                // Add current palindrome substring ( + 1)
                // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
                // remove common palinrome substrings (- dp[i+1][j-1])
                if (P[i][j] == true)
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }
      
        // return total palindromic substrings
        return dp[0][n-1]+s.length();
	}
	
}
