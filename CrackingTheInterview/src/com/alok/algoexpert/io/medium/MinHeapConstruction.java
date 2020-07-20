/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alok Soni
 * 
 *         Follow the below link for question
 *         file:///Users/unifytechnologies/MyStuff/MyGit/Algorithms/CrackingTheInterview/AlgoExpert.io_problems/medium/MinHeapConstruction.png
 *
 */
public class MinHeapConstruction {
	public static void main(String[] args) {
		int[] arr = { 48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41 };
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		MinHeap minHeap = new MinHeap(list);
		System.out.println(minHeap.heap);

	}

	static class MinHeap {
		List<Integer> heap = new ArrayList<Integer>();

		public MinHeap(List<Integer> array) {
			heap = buildHeap(array);
		}

		public List<Integer> buildHeap(List<Integer> array) {
			// Write your code here.
			if (array == null || array.isEmpty()) {
				return array;
			} else if (array.size() == 1) {
				return array;
			} else {
				int lastRootItem = (array.size() - 1) / 2;
				for (int i = lastRootItem; i >= 0; i--) {
					siftDown(i, array.size() - 1, array);
				}
			}
			return array;
		}

		public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
			while (currentIdx <= (endIdx - 1) / 2) {
				int left = 2 * currentIdx + 1;
				int right = 2 * currentIdx + 2;
				if (right >= heap.size()) {
					if (heap.get(left) < heap.get(currentIdx)) {
						heap = swap(heap, left, currentIdx);
					} else {
						break;
					}
				} else if (heap.get(left) < heap.get(right) && heap.get(currentIdx) > heap.get(left)) {
					heap = swap(heap, left, currentIdx);
					currentIdx = left;
				} else if (heap.get(currentIdx) > heap.get(right)) {
					heap = swap(heap, right, currentIdx);
					currentIdx = right;
				} else {
					break;
				}
			}
		}

		public void siftUp(int currentIdx, List<Integer> heap) {
			// Write your code here.
			while (currentIdx > 0) {
				int root = (currentIdx - 1) / 2;
				if (heap.get(root) > heap.get(currentIdx)) {
					heap = swap(heap, root, currentIdx);
					currentIdx = root;
				} else {
					break;
				}
			}
			this.heap = heap;
		}

		public int peek() {
			// Write your code here.
			if (heap == null || heap.isEmpty()) {
				return -1;
			}
			return heap.get(0);
		}

		public int remove() {
			// Write your code here.
			if (heap == null || heap.isEmpty()) {
				return -1;
			}
			heap = swap(heap, 0, heap.size() - 1);
			int removedItem = heap.remove(heap.size() - 1);
			siftDown(0, heap.size() - 1, heap);
			return removedItem;
		}

		public void insert(int value) {
			// Write your code here.
			heap.add(value);
			int i = heap.size() - 1;
			siftUp(i, heap);
		}

		private List<Integer> swap(List<Integer> heap, int aIdx, int bIdx) {
			int tmp = heap.get(aIdx);
			heap.set(aIdx, heap.get(bIdx));
			heap.set(bIdx, tmp);
			return heap;
		}
	}
}
