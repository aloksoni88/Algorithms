/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class DiskStacking {
	public static void main(String[] args) {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[] {2,1,2});
		list.add(new Integer[] {3,2,3});
		list.add(new Integer[] {2,2,8});
		list.add(new Integer[] {2,3,4});
		list.add(new Integer[] {1,3,1});
		list.add(new Integer[] {4,4,5});
		List<Integer[]> result = diskStacking(list);
		System.out.println();
		for(Integer[] i : result) {
			System.out.println(Arrays.toString(i));
		}
		
	}

	//Time - O(n^2)
	//Space - O(n)
	public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		if(disks == null || disks.isEmpty()) {
			return disks;
		}else if(disks.size() == 1) {
			return disks;
		}
		for(Integer[] disk : disks) {
			System.out.print(Arrays.toString(disk) + " ");
		}
		disks.sort(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] disk1, Integer[] disk2) {
				return disk1[2].compareTo(disk2[2]);
			}
		});
		System.out.println();
		for(Integer[] disk : disks) {
			System.out.print(Arrays.toString(disk) + " ");
		}
		
		int[] heights = new int[disks.size()];
		Integer[] index = new Integer[disks.size()];
		Arrays.fill(index, null);
		
		for(int i=0; i<disks.size(); i++) {
			heights[i] = disks.get(i)[2];
		}
		
		int maxHeightIdx = 0;
		for(int i=1; i<disks.size(); i++) {
			for(int j=0; j<i; j++) {
				
				if(isValidDisk(disks.get(j), disks.get(i)) 
						&& (heights[j] + disks.get(i)[2]) > heights[i]) {
					heights[i] = heights[j] + disks.get(i)[2];
					index[i] = j;
					maxHeightIdx = i;
				}
				if(heights[i] > heights[maxHeightIdx]) {
					maxHeightIdx = i;
				}
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(heights));
		System.out.println();
		System.out.println(Arrays.toString(index));
		System.out.println();
		System.out.println("Max height index " + maxHeightIdx);
		
		ArrayList<Integer[]> result = new ArrayList<>();
		result.add(disks.get(maxHeightIdx));
		while(index[maxHeightIdx] != null) {
			result.add(0,disks.get(index[maxHeightIdx]));
			maxHeightIdx = index[maxHeightIdx];
		}
		
		return result;
	}
	
	private static boolean isValidDisk(Integer[] disk, Integer[] currDisk) {
		if(disk[0] < currDisk[0] && disk[1] < currDisk[1] && disk[2] < currDisk[2]) {
			return true;
		}
		return false;
	}
}
