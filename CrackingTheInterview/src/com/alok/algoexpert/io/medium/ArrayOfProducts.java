/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.Arrays;

/**
 * @author Alok Soni
 *
 */
public class ArrayOfProducts {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2 };
		int[] result = arrayOfProductsOptimized(arr);
		System.out.println(Arrays.toString(result));
	}

	// Time - O(n), Space - O(n) - n is the length 0f array
	public static int[] arrayOfProductsOptimized2(int[] array) {
		int[] result = new int[array.length];

		int leftProdcut = 1;
		for (int i = 0; i < array.length; i++) {
			result[i] = leftProdcut;
			leftProdcut = leftProdcut * array[i];
		}
		System.out.println(Arrays.toString(result));

		int rigthProduct = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			result[i] = result[i] * rigthProduct;
			rigthProduct = rigthProduct * array[i];
		}
		return result;
	}

	// Time - O(n), Space - O(n) - n is the length 0f array
	public static int[] arrayOfProductsOptimized(int[] array) {
		int[] result = new int[array.length];
		int[] leftProductArr = new int[array.length];
		int[] rightProductArr = new int[array.length];

		int leftProdcut = 1;
		for (int i = 0; i < array.length; i++) {
			leftProductArr[i] = leftProdcut;
			leftProdcut = leftProdcut * array[i];
		}
		System.out.println(Arrays.toString(leftProductArr));

		int rigthProduct = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			rightProductArr[i] = rigthProduct;
			rigthProduct = rigthProduct * array[i];
		}
		System.out.println(Arrays.toString(rightProductArr));

		for (int i = 0; i < array.length; i++) {
			result[i] = leftProductArr[i] * rightProductArr[i];
		}
		return result;
	}

	// Time - O(n^2), Space - O(n) - n is the length 0f array
	public static int[] arrayOfProducts(int[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int product = 1;
			for (int j = 0; j < array.length; j++) {
				if (j == i) {
					continue;
				}
				product = product * array[j];
			}
			result[i] = product;
		}
		return result;
	}
}
