/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class SameBSTs {
	public static void main(String[] args) {
		Integer[] arr1 = { 10, 15, 8, 12, 94, 81, 5, 2,11 };
		Integer[] arr2 = { 10, 8, 5, 15, 2, 12,11, 94, 81 };

		List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));

//		boolean isSame = sameBsts(list1, list2);
		boolean isSame = sameBstsOptimize(list1, list2);
		System.out.println("Is same BST's : " + isSame);
	}

	// Time - O(N^2)
	// Space - O(d) - d is the depth of bst
	public static boolean sameBstsOptimize(List<Integer> arrayOne, List<Integer> arrayTwo) {
		int size1 = (arrayOne == null || arrayOne.isEmpty()) ? 0 : arrayOne.size();
		int size2 = (arrayTwo == null || arrayTwo.isEmpty()) ? 0 : arrayTwo.size();
		if (size1 != size2) {
			return false;
		} else if (size1 == 0 && size2 == 0) {
			return true;
		} 
		return isSameBsts(arrayOne, arrayTwo,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean isSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, 
			int index1, int index2,int minVal, int maxVal) {
		
		if(index1 == -1 || index2 == -1) {
			return index1 == index2;
		}
		
		if (arrayOne.get(index1) != arrayTwo.get(index2)) {
			return false;
		}
		int leftIndex1 = getLeftSubtree(index1, arrayOne, minVal);
		int rightIndex1 = getRightSubtree(index1, arrayOne, maxVal);
		
		int leftIndex2 = getLeftSubtree(index2, arrayTwo, minVal);				
		int rightIndex2 = getRightSubtree(index2, arrayTwo, maxVal);
		
		int currentVal = arrayOne.get(index1);
		boolean isSame = isSameBsts(arrayOne, arrayTwo, leftIndex1, leftIndex2, minVal, currentVal);
		if(isSame) {
			isSame = isSameBsts(arrayOne, arrayTwo, rightIndex1, rightIndex2, currentVal, maxVal);
		}
		return isSame;
	}
	
	private static int getLeftSubtree(int index,List<Integer> arrayOne, int minVal) {
		for(int i=index+1; i<arrayOne.size(); i++) {
			if(arrayOne.get(i) < arrayOne.get(index) 
					&& arrayOne.get(i) >= minVal) {
				return i;
			}
		}
		return -1;
	}
	
	private static int getRightSubtree(int index,List<Integer> arrayTwo, int maxValue) {
		for(int i=index+1; i<arrayTwo.size(); i++) {
			if(arrayTwo.get(i) >= arrayTwo.get(index) 
					&& arrayTwo.get(i) < maxValue) {
				return i;
			}
		}
		return -1;
	}

	// Time - O(N^2)
	// Space - O(N^2)
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		int size1 = (arrayOne == null || arrayOne.isEmpty()) ? 0 : arrayOne.size();
		int size2 = (arrayTwo == null || arrayTwo.isEmpty()) ? 0 : arrayTwo.size();
		if (size1 != size2) {
			return false;
		} else if (size1 == 0 && size2 == 0) {
			return true;
		} else if (arrayOne.get(0) != arrayTwo.get(0)) {
			return false;
		}

		List<Integer> leftSubtree1 = new ArrayList<>();
		List<Integer> rightSubtree1 = new ArrayList<>();
		List<Integer> leftSubtree2 = new ArrayList<>();
		List<Integer> rightSubtree2 = new ArrayList<>();
		for (int i = 1; i < arrayOne.size(); i++) {
			if (arrayOne.get(i) < arrayOne.get(0)) {
				leftSubtree1.add(arrayOne.get(i));
			}
			if (arrayTwo.get(i) < arrayTwo.get(0)) {
				rightSubtree1.add(arrayTwo.get(i));
			}

			if (arrayOne.get(i) >= arrayOne.get(0)) {
				leftSubtree2.add(arrayOne.get(i));
			}
			if (arrayTwo.get(i) >= arrayTwo.get(0)) {
				rightSubtree2.add(arrayTwo.get(i));
			}
		}
		return sameBsts(leftSubtree1, rightSubtree1) && sameBsts(leftSubtree2, rightSubtree2);

	}

}
