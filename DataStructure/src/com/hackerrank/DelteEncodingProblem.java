package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author mehar
 * 
 * Given a list of numbers, e.g.:

25626 25757 24367 24267 16 100 2 7277
Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is. 
Each subsequent element is represented as the numeric difference from the element before it. 
E.g. for the sequence above, the delta encoding would be:

25626 131 -1390 -100 -24251 84 -98 7275
However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, 
then, instead of the difference, we would like to use an escape token, printing it.

This will denote that the value following the escape token is a full four-byte difference value,
 rather than a one-byte different value.

For this exercise, we'll declare -128 as the escape token.

Following the same example above, the final result would be:

25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 *
 */
public class DelteEncodingProblem {
	public static void main(String[] args) {
		
		
		//int[] inputArr = {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
		/*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArr = new int[n];
        for(int t = 0; t < n; t++) {
            inputArr[t] = sc.nextInt();
        }
        */
		/*Scanner sc = new Scanner(System.in);
		List<Long> input = new ArrayList();
		
		while(sc.hasNext()){
			//System.out.println(sc.next());
			input.add(sc.nextLong());
			System.out.println(sc.nextInt());
		}
		if(input != null && input.size()>0){
			System.out.println(input);
			int[] inputArr = new int[input.size()];
			for(int i=0; i<input.size(); i++){
				inputArr[i] = input.get(i);
			}
			List<Integer> output = getDeltaChainingList(inputArr);
			System.out.println(output);
		}*/
		
		Scanner scanner = new Scanner(System.in);
		List<Integer> input = new ArrayList<Integer>();
		while (scanner.hasNextInt()){
		  input.add(scanner.nextInt());
		}
			
			//System.out.println(input);
			int[] inputArr = new int[input.size()];
			for(int i=0; i<input.size(); i++){
				inputArr[i] = input.get(i);
			}
			int[] output = getDeltaChainingList(inputArr);
			if(output != null){
				for(int i=0; i<output.length; i++){
					System.out.println(output[i] + " ");
				}
			}
		
        
	}
	
	private static int[] getDeltaChainingList(int[] inputArr){
		List<Integer> output = new ArrayList();
		if(inputArr != null && inputArr.length > 0){
			output.add(inputArr[0]);
			for(int i=1; i<inputArr.length; i++){
				int diff = inputArr[i] - inputArr[i-1];
				if( diff >= -127 && diff <= 127){
					output.add(diff);
				}else{
					output.add(-128);
					output.add(diff);
				}
			}
		}
		if(output != null && output.size() > 0){
			int[] out = new int[output.size()];
			for(int i=0; i< output.size(); i++){
				out[i] = output.get(i);
			}
			return out;
		}
		return null;
	}
}
