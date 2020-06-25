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
public class MoveElementToEnd {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		list.add(1);
//		list.add(2);
//		list.add(2);
//		list.add(2);
//		list.add(4);
//		list.add(5);
//		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		List<Integer> result = moveElementToEnd(list, 9);
		System.out.println(result);
	}
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		if (array == null || array.isEmpty()) {
			return array;
		}

		//first implementation
//		int counter = array.get(0) == toMove ? 1 : 0;
//		for (int i = 1; i < array.size(); i++) {
//			if (array.get(i) != toMove) {
//				if (counter != 0) {
//					array.set(i - counter, array.get(i));
//				}
//			} else {
//				counter++;
//			}
//		}
//		for (int i = 0; i < counter; i++) {
//			array.set(array.size() - i-1, toMove);
//		}
		
		//second implementation
		int index = 0;
		for(int i=0; i< array.size(); i++) {
			if(array.get(i) != toMove) {
				if(i != index) {
					int tmp = array.get(i);
					array.set(i, array.get(index));
					array.set(index, tmp);
				}
				index++;
			}
		}
		return array;
	}
}
