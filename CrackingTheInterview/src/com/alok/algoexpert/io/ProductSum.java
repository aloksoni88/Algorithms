/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class ProductSum {
	public static void main(String[] args) {
		List<Object> list = new ArrayList();
		list.add(5);
		list.add(2);

		List<Object> list2 = new ArrayList();
		list2.add(7);
		list2.add(-1);

		list.add(list2);
		list.add(3);

		List<Object> list3 = new ArrayList();
		list3.add(6);

		List<Object> list4 = new ArrayList();
		list4.add(-13);
		list4.add(8);

		list3.add(list4);

		list3.add(4);
		list.add(list3);

		System.out.println(list);
		int result = productSum(list);
		System.out.println(result);
	}

	// Tip: You can use `element instanceof ArrayList` to check whether an item
	// is an array or an integer.
	public static int productSum(List<Object> array) {
		if (array == null) {
			return -1;
		}

		return getProductSumOfDepthArray(array, 0, 2);

	}

	private static int getProductSumOfDepthArray(List<Object> objList, int productSum, int mul) {
		for (Object obj : objList) {
			if (obj instanceof Integer) {
				productSum = productSum + (Integer) obj;
			} else {
				productSum = productSum + mul * (getProductSumOfDepthArray((List<Object>) obj, 0, mul + 1));
			}
		}
		return productSum;
	}
}