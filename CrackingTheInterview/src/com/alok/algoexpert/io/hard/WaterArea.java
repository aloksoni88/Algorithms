/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class WaterArea {
	public static void main(String[] args) {
		int[] arr = { 0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3 };
//		int result = waterAreaOptimize(arr);
		int result = waterArea(arr);
		System.out.println("Total surface area covered by wated : " + result);
	}

	// Time - O(n)
	// Space - O(1)
	public static int waterAreaOptimize(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		
		int leftIdx = 0;
		int rightIdx = heights.length-1;
		int leftMax = heights[leftIdx];
		int rightMax = heights[rightIdx];
		int surfaceArea = 0;
		
		while(leftIdx < rightIdx) {
			if(heights[leftIdx] < heights[rightIdx]) {
				leftIdx++;
				leftMax = Math.max(leftMax, heights[leftIdx]);
				surfaceArea = surfaceArea + (leftMax - heights[leftIdx]);
			}else {
				rightIdx--;
				rightMax = Math.max(rightMax, heights[rightIdx]);
				surfaceArea = surfaceArea + (rightMax - heights[rightIdx]);
			}
		}
		return surfaceArea;
	}

	// Time - O(n)
	// Space - O(n)
	public static int waterArea(int[] heights) {
		if (heights == null) {
			return -1;
		}
		int[] leftMax = new int[heights.length];
		int[] rightMax = new int[heights.length];
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			leftMax[i] = max;
			max = heights[i] > max ? heights[i] : max;
		}
		max = 0;
		for (int i = heights.length - 1; i >= 0; i--) {
			rightMax[i] = max;
			max = heights[i] > max ? heights[i] : max;
		}

		System.out.println(Arrays.toString(leftMax));
		System.out.println(Arrays.toString(rightMax));

		int[] area = new int[heights.length];
		int result = 0;
		for (int i = 0; i < heights.length; i++) {
			int minHeight = Math.min(leftMax[i], rightMax[i]);
			if (heights[i] < minHeight) {
				area[i] = minHeight - heights[i];
				result = result + area[i];
			} else {
				area[i] = 0;
			}
		}
		System.out.println(Arrays.toString(area));
		return result;
	}
}
