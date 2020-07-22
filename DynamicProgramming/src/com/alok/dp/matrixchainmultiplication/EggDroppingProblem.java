/**
 * 
 */
package com.alok.dp.matrixchainmultiplication;

/**
 * @author Alok Soni
 *
 */

/**
 * ################# Question ##################
 * 
 * Egg Dropping Puzzle | DP-11 The following is a description of the instance of
 * this famous puzzle involving n=2 eggs and a building with k=36 floors.
 * Suppose that we wish to know which stories in a 36-story building are safe to
 * drop eggs from, and which will cause the eggs to break on landing. We make a
 * few assumptions:
 * 
 * …..An egg that survives a fall can be used again. …..A broken egg must be
 * discarded. …..The effect of a fall is the same for all eggs. …..If an egg
 * breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall. …..It is
 * not ruled out that the first-floor windows break eggs, nor is it ruled out
 * that the 36th-floor do not cause an egg to break.
 * 
 * If only one egg is available and we wish to be sure of obtaining the right
 * result, the experiment can be carried out in only one way. Drop the egg from
 * the first-floor window; if it survives, drop it from the second-floor window.
 * Continue upward until it breaks. In the worst case, this method may require
 * 36 droppings. Suppose 2 eggs are available. What is the least number of
 * egg-droppings that is guaranteed to work in all cases? The problem is not
 * actually to find the critical floor, but merely to decide floors from which
 * eggs should be dropped so that the total number of trials are minimized.
 *
 */
public class EggDroppingProblem {
	private static int[][] t;
	public static void main(String[] args) {
		int f = 36;
		int e = 9;
		
//		int output = solveRecursive(f, e);
		t = new int[f+1][e+1];
		for(int i=0; i<=f; i++) {
			for(int j=0; j<=e; j++) {
				t[i][j] = -1;
			}
		}
		int output = solveMemoize(f, e);
		System.out.println("Output : " + output);
	}
	
	private static int solveMemoize(int f, int e) {
		if(f == 0 || f == 1) {
			return f;
		}else if(e == 1) {
			return f;
		}
		if(t[f][e] != -1) {
			return t[f][e];
		}
		int min = Integer.MAX_VALUE;
		for(int k=1; k<=f; k++) {
			int eggBreakVal = solveMemoize(k-1, e-1);
			t[f][e] = eggBreakVal;
			int eggNotBreakVal = solveMemoize(f-k, e);
			t[f][e] = eggNotBreakVal;
			int tmp = 1 + Math.max(eggBreakVal,eggNotBreakVal);
			if(tmp < min) {
				min = tmp;
			}
		}
		t[f][e] = min;
		return min;
	}
	
	private static int solveRecursive(int f, int e) {
		if(f == 0 || f == 1) {
			return f;
		}else if(e == 1) {
			return f;
		}
		int min = Integer.MAX_VALUE;
		for(int k=1; k<=f; k++) {
			int tmp = 1 + Math.max(solveRecursive(k-1, e-1),solveRecursive(f-k, e));
			if(tmp < min) {
				min = tmp;
			}
		}
		return min;
	}
}
