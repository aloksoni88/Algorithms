/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class MinRewards {
	public static void main(String[] args) {
		int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};
		int minRewards = minRewards(scores);
		System.out.println("Min number of rewards are : " + minRewards);
	}
	
	//Time - O(N)
	//Space - O(N)
	public static int minRewards(int[] scores) {
		if(scores == null || scores.length == 0) {
			return -1;
		}else if(scores.length == 1) {
			return 1;
		}
		int[] rewards = new int[scores.length];
		
		Arrays.fill(rewards, 1);
		for(int i=1;i<scores.length; i++) {
			if(scores[i] > scores[i-1]) {
				rewards[i] = rewards[i-1] + 1;
			}
		}
		
		for(int i=scores.length-2; i>=0; i--) {
			if(scores[i] > scores[i+1]) {
				rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
			}
		}
		
		int minRewards = 0;
		for(int i=0; i<rewards.length; i++) {
			minRewards = minRewards + rewards[i];
		}
	    return minRewards;
	}
	
	//Time - O(N^2)
	//Space - O(N)
	public static int minRewards2(int[] scores) {
		if(scores == null || scores.length == 0) {
			return -1;
		}else if(scores.length == 1) {
			return 1;
		}
		int[] rewards = new int[scores.length];
		rewards[0] = 1;
		for(int i=1; i<scores.length; i++) {
			if(scores[i] < scores[i-1]) {
				rewards[i] = 1;
				int j = i;
				while(j > 0 && scores[j] < scores[j-1]) {
					rewards[j-1] =  Math.max(rewards[j-1], rewards[j] +1);
					j--;
				}
			}else {
				rewards[i]  = rewards[i-1] +1;
			}
		}
		
		int minRewards = 0;
		for(int i=0; i<rewards.length; i++) {
			minRewards = minRewards + rewards[i];
		}
	    return minRewards;
	  }
}
