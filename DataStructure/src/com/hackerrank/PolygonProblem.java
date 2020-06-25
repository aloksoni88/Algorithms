package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author alok
 * 
 * Identify whether four sides (given by four integers) can form a square, a rectangle, or neither.

Input: You will receive an list of strings, each containing four space-separated integers, which represent the length of the sides of a polygon. The input lines will follow the 'A B C D' order as in the following representation:

|-----A-----|
|           |
|           |
D           B
|           |
|           |
|-----C-----|
Output: A single line which contains 3 space-separated integers; representing the number of squares, number of rectangles, and number of other polygons with 4 sides. Note that squares shouldn't be counted as rectangles. Invalid polygons should also be counted as 'other polygons'.

Constraints: The four integers representing the sides will be such that: -2000 <=X <= 2000 (Where X represents the integer)

Sample Input:

36 30 36 30
15 15 15 15
46 96 90 100
86 86 86 86
100 200 100 200
-100 200 -100 200

Sample Output: 2 2 2
 *
 */
public class PolygonProblem {
	
	public static void main(String[] args) {
		String[] arr = {"36 30 36 30","15 15 15 15","46 96 90 100","86 86 86 86","100 200 100 200","-100 200 -100 200"};
		/*Scanner sc = new Scanner(System.in);
		//String input = sc.next();
		List<String> input = new ArrayList();
		while(sc.hasNext()){
			//System.out.println(sc.next());
			input.add(sc.next());
		}
		if(input != null && input.size()>0){
			String[] inputArr = new String[input.size()];
			for(int i=0; i<input.size(); i++){
				inputArr[i] = input.get(i);
			}
			String o = checkSide(inputArr);
			System.out.println("Output " + o);
		}*/
		//System.out.println(input);
		String output = checkSide(arr);
		System.out.println("Output " + output);
	}
	
	private static String checkSide(String[] inputStrArr){
		int[] result = new int[3];
		if(inputStrArr != null){
			for(int i=0; i<inputStrArr.length;i++){
				String[] strArr = inputStrArr[i].split(" ");
				int[] intArr = new int[strArr.length];
				for(int j=0; j< strArr.length;j++){
					intArr[j] = Integer.parseInt(strArr[j]);
				}
				String shape = getShape(intArr); 
				if(shape.equalsIgnoreCase("square")){
					result[0] = result[0]+1;
				}else if(shape.equalsIgnoreCase("rectangle")){
					result[1] = result[1]+1;
				}else{
					result[2] = result[2]+1;
				}
			}
		}
		String output = result[0] + " " + result[1] + " " + result[2];
		return output;
	}
	
	private static String getShape(int[] arr){
		//System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
		if((arr[0] ==  arr[1]) && (arr[1] == arr[2]) && (arr[2] == arr[3]) && (arr[3] == arr[0])){
			return "square";
		}else if( (arr[0] == arr[2]) && (arr[1] == arr[3]) ){
			return "rectangle";
		}else{
			return "polygon";
		}
	}
}
