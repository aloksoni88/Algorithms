package com.hackerrank;
/**
 * @author alok
 *
 *Identify whether there exists a pair of numbers in an array such that their sum is equal to N.

Input: The first line contains one integer N, which is the sum we are trying to find. 
The second line contains one integer M, which is the length of the array. 
This is followed by M lines each containing one element of the array.

Output: Output 1 if there exists a pair of numbers in the array such that their sum equals N.
 If such a pair does not exist, output 0.
 
 Sample Input:

66
10
18
11
21
28
31
38
40
55
60
62
Sample Output:

1
 **/
public class SumArray {

	public static void main(String[] arg){
		System.out.println(System.currentTimeMillis());
		int[] inputArr = {18,11,21,28,31,38,40,55,60,62};
		int output = findSumPair(66, 10, inputArr);
		System.out.println("Output " + output);
		System.out.println(System.currentTimeMillis());
	}
	
	private static int findSumPair(int number, int length, int[] arr){
		int output =0;
		for(int i=0; i< length; i++){
			for(int j=i+1; j<length-1;j++){
				if(arr[i]+arr[j] == number){
					return 1; 
				}
			}
		}
		return output;
	}
}

