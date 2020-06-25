package com.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class FacebookProblem1 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine().trim();
			System.out.println(numOfWays(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int numOfWays(String str){
		if(str == null || str.isEmpty()){
			return 1;
		}else{
			int count = 0;
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=0; i<str.length(); i++){
				int val = Integer.parseInt(str.charAt(i)+"");
				char c = getMapping(val);
				if(c != ' '){
					if(i !=0){
						String prevVal = str.charAt(i-1)+"";
						int combinedVal = Integer.parseInt((prevVal + val));
						if(set.contains(combinedVal)) {
							continue;
						}
						set.add(combinedVal);
						c = getMapping(combinedVal);
						if(c != ' '){
							count = count+1;
						}
					}else {
						count =  count +1;
						set.add(val);
					}
				}
			}
			return count;
		}
	}
	
	private static char getMapping(int num){
		switch (num) {
		case 1:
			return 'a';
		case 2:
			return 'b';
		case 3:
			return 'c';
		case 4:
			return 'd';
		case 5:
			return 'e';
		case 6:
			return 'f';
		case 7:
			return 'g';
		case 8:
			return 'h';
		case 9:
			return 'i';
		case 10:
			return 'j';
		case 11:
			return 'k';
		case 12:
			return 'l';
		case 13:
			return 'm';
		case 14:
			return 'n';
		case 15:
			return 'o';
		case 16:
			return 'p';
		case 17:
			return 'q';
		case 18:
			return 'r';
		case 19:
			return 's';
		case 20:
			return 't';
		case 21:
			return 'u';
		case 22:
			return 'v';
		case 23:
			return 'w';
		case 24:
			return 'x';
		case 25:
			return 'y';
		case 26:
			return 'z';
		default:
			return ' ';
		}
	}
}
