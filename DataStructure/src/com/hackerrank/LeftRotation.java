package com.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeftRotation {

	private static int[] rotLeft(int[] a, int d) {
		if(a.length == d){
			return a;
		}
		for(int i=0; i<a.length; i++){
			int tmp = a[0];
			if(i<d){
				for(int k=0; k<a.length-1;k++){
					a[k] = a[k+1];	
				}
				a[a.length-1] = tmp;
			}
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Outputs/left_rotation_output.txt"));
		BufferedReader br = new BufferedReader(new FileReader("Inputs/left_rotation_input_1.txt"));
        String sCurrentLine;
        int rotationCount = 0;
        int counter=0;
        int[] numArr = null;
        while( (sCurrentLine = br.readLine()) != null){
        	//System.out.println(sCurrentLine);
        	String[] arr = sCurrentLine.split(" ");
        	if(counter == 0){
        		rotationCount = Integer.parseInt(arr[1]);
        		numArr = new int[Integer.parseInt(arr[0])];
        	}else{
        		String[] strArr = sCurrentLine.split(" ");
        		for(int i=0; i<strArr.length; i++){
        			numArr[i] = Integer.parseInt(strArr[i]);
        		}
        	}
        	counter++;
        }
        /*for(int i=0; i<numArr.length;i++){
			System.out.print(numArr[i] + " ");
		}*/
       

		int[] result = rotLeft(numArr, rotationCount);
		printArray(result);
		for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
	}
	
	private static void printArray(int[] arr){
		for(int i=0; i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
}


/**
 * Check out the resources on the page's right side to learn more about arrays. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.

A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

Function Description

Complete the function rotLeft in the editor below. It should return the resulting array of integers.

rotLeft has the following parameter(s):

An array of integers .
An integer , the number of rotations.
Input Format

The first line contains two space-separated integers  and , the size of  and the number of left rotations you must perform. 
The second line contains  space-separated integers .

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform d=4 left rotations, the array undergoes the following sequence of changes:
[1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]

 * 
 */
