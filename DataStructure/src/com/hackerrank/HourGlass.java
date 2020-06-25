package com.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HourGlass {

	//private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Outputs/hourglass_output.txt"));

        int[][] arr = new int[6][6];

        BufferedReader br = new BufferedReader(new FileReader("Inputs/hourglass_input_1.txt"));
        String sCurrentLine;
        int counter = 0;
        while ((sCurrentLine = br.readLine()) != null) {
    		System.out.println(sCurrentLine);
    		String[] arrRowItems = sCurrentLine.split(" ");
    		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    		for (int i = 0; i < 6; i++) {
                int arrItem = Integer.parseInt(arrRowItems[i]);
                arr[counter][i] = arrItem;
            }
    		counter++;
    	}

        System.out.println();
        int result = hourglassSum(arr);

        System.out.println("Output is " + result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        //scanner.close();
    }
	
	private static int hourglassSum(int[][] arr) {
		int result =0;
		int maxSum = 0;
		int[][] outputArr = new int[3][3];
		for(int i=0; i<4;i++){
			for(int j=0; j<4; j++){
				int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
									+ arr[i+1][j+1] +
						  arr[i+2][j]+ arr[i+2][j+1]+arr[i+2][j+2];
				if(sum > maxSum){
					maxSum = sum;
					outputArr[0][0] = arr[i][j];
					outputArr[0][1] = arr[i][j+1];
					outputArr[0][2] = arr[i][j+2];
					
					
					outputArr[1][1] = arr[i+1][j+1];
					
					
					outputArr[2][0] = arr[i+2][j];
					outputArr[2][1] = arr[i+2][j+1];
					outputArr[2][2] = arr[i+2][j+2];
				}
			}
			
		}
		result = maxSum;
		for(int i=0; i<3; i++){
			for(int j=0;j<3;j++){
				if((i==1 && j==0) && (i==1 && j==2)){
					continue;
				}
				System.out.print(outputArr[i][j] + " ");
			}
			System.out.println();
		}
		return result;
    }
}


/**


Given a  2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
We calculate the following  hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18
Our highest hourglass value is  from the hourglass:

0 4 3
  1
8 6 6
Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Function Description

Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.

hourglassSum has the following parameter(s):

arr: an array of integers
Input Format

Each of the  lines of inputs  contains  space-separated integers .

Constraints

Output Format

Print the largest (maximum) hourglass sum found in .

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

 contains the following hourglasses:

1 1 1   1 1 0   1 0 0   0 0 0
  1       0       0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1       1       0       0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0       2       4       4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0       0       2       0
0 0 1   0 1 2   1 2 4   2 4 0
The hourglass with the maximum sum () is:

2 4 4
  2
1 2 4



**/