/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class MinMaxStackConstruction {
	public static void main(String[] args) {

	}

	static class MinMaxStack {
		List<Integer> minList = new ArrayList();
		List<Integer> maxList = new ArrayList();
		List<Integer> stack = new ArrayList();

		public int peek() {
			if (stack.isEmpty()) {
				return -1;
			}
			return stack.get(stack.size() - 1);
		}

		public int pop() {
			if (stack.isEmpty()) {
				return -1;
			}
			minList.remove(minList.size() - 1);
			maxList.remove(maxList.size() - 1);
			return stack.remove(stack.size() - 1);
		}

		public void push(Integer number) {
			stack.add(number);
			if (minList.isEmpty()) {
				minList.add(number);
				maxList.add(number);
				return;
			}
			if (minList.get(minList.size() - 1) > number) {
				minList.add(number);
			} else {
				minList.add(minList.get(minList.size() - 1));
			}

			if (maxList.get(maxList.size() - 1) < number) {
				maxList.add(number);
			} else {
				maxList.add(maxList.get(maxList.size() - 1));
			}
		}

		public int getMin() {
			if (minList.isEmpty()) {
				return -1;
			}
			return minList.get(minList.size() - 1);
		}

		public int getMax() {
			if (maxList.isEmpty()) {
				return -1;
			}
			return maxList.get(maxList.size() - 1);
		}
	}
}
