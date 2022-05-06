package com.alok.algoexpert.io.hard;

import java.util.ArrayList;

import java.util.List;


/**
 * @author Alok Soni
 *
 */
public class ZigzagTraverse {
	public static void main(String[] args) {
		 int[][] arr = {	{1, 3, 4, 10}, 
				 			{2, 5, 9, 11}, 
				 			{6, 8, 12, 15}, 
				 			{7, 13, 14,16}
				 		};
//		int[][] arr = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			List<Integer> innerList = new ArrayList<>();
			for (int j = 0; j < arr[i].length; j++) {
				innerList.add(arr[i][j]);
			}
			list.add(innerList);
		}

		System.out.println(list);
		List<Integer> result = zigzagTraverse(list);
		System.out.println(result);
	}

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		if (array == null || array.isEmpty()) {
			return new ArrayList<>();
		} else if (array.get(0) == null || array.get(0).isEmpty()) {
			return array.get(0);
		} else if (array.size() == 1) {
			return array.get(0);
		}
		List<Integer> list = new ArrayList<>();

		int row = 0, col = 0;
		int rowCount = array.size() - 1;
		int columnCount = array.get(0).size() - 1;

		boolean isGoindDown = true;
		while (!isOutOfRange(row, col, rowCount, columnCount)) {
			list.add(array.get(row).get(col));
			if (isGoindDown) {
				if (col == 0 || row == rowCount) {
					isGoindDown = false;
					if (row != rowCount) {
						row++;
					} else {
						col++;
					}
				} else {
					row++;
					col--;
				}
			} else {
				if (row == 0 || col == columnCount) {
					isGoindDown = true;
					if (col != columnCount) {
						col++;
					} else {
						row++;
					}
				} else {
					col++;
					row--;
				}
			}
		}
		return list;
	}

	private static boolean isOutOfRange(int row, int col, int rowCount, int columnCount) {
		return (row < 0 || row > rowCount || col < 0 || col > columnCount);
	}

	public static List<Integer> zigzagTraverseBk(List<List<Integer>> array) {
		if (array == null || array.isEmpty()) {
			return new ArrayList<>();
		} else if (array.get(0) == null || array.get(0).isEmpty()) {
			return array.get(0);
		} else if (array.size() == 1) {
			return array.get(0);
		}
		List<Integer> list = new ArrayList<>();

		int i = 0, j = 0;
		list.add(array.get(i).get(i));

		while (i != array.size() - 1 || j != array.get(0).size() - 1) {
			if (i != array.size() - 1) {
				i = i + 1;
				list.add(array.get(i).get(j));

				while (i != 0) {
					i = i - 1;
					j = j + 1;
					list.add(array.get(i).get(j));
				}
			} else {
				j = j + 1;
				list.add(array.get(i).get(j));

				while (j != array.get(0).size() - 1) {
					j = j + 1;
					i = i - 1;
					list.add(array.get(i).get(j));
				}
			}

			if (j != array.get(0).size() - 1) {
				j = j + 1;
				list.add(array.get(i).get(j));

				while (j != 0) {
					j = j - 1;
					i = i + 1;
					list.add(array.get(i).get(j));
				}
			} else {
				i = i + 1;
				list.add(array.get(i).get(j));

				while (i != array.size() - 1) {
					j = j - 1;
					i = i + 1;
					list.add(array.get(i).get(j));
				}
			}

		}
		return list;
	}
}
