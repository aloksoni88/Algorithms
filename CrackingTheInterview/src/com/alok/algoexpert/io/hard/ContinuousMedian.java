/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Alok Soni
 *
 */
public class ContinuousMedian {
	public static void main(String[] args) {
		ContinuousMedianHandler handler = new ContinuousMedianHandler();
		handler.insert(5);

		handler.insert(10);

		handler.insert(100);

		handler.insert(200);

		handler.insert(6);

		handler.insert(13);

		handler.insert(14);
		// System.out.println(handler.getMedianOptimize());
		System.out.println(handler.list);
		System.out.println(handler.getMedian());

	}

	// Time - O(log(n))
	// Space - O(n)
	static class ContinuousMedianHandler {
		double median = 0;
		ArrayList<Integer> list = new ArrayList<>();

		public void insert(int number) {
//			if(true) {
//				insertOptimize(number);
//				return;
//			}
			if (list.isEmpty()) {
				list.add(number);
				median = number;
			} else {
				int index = list.size();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) > number) {
						index = i;
						break;
					}
				}
				if (index == list.size()) {
					list.add(number);
				} else {
					list.add(index, number);
				}

				if (list.size() % 2 == 0) {
					int middleIndex = list.size() / 2;
					median = (list.get(middleIndex) + list.get(middleIndex - 1)) / 2.0;
				} else {
					median = list.get(list.size() / 2);
				}
			}
		}

		public double getMedian() {
			return median;
		}

//		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
//		public void insertOptimize(int number) {
//			minHeap.add(number);
//			maxHeap.add(minHeap.poll());
//			
//			if(minHeap.size() < maxHeap.size()) {
//				minHeap.add(maxHeap.poll());
//			}
//		}
//		
//		public double getMedianOptimize() {
//			if( (minHeap.size() + maxHeap.size())%2 != 0) {
//	            return minHeap.peek();
//	        }else {
//	            return (minHeap.peek()+maxHeap.peek())/2.0;
//	        }
//		}

		public void insertOptimize(int number) {
			if (maxHeap.isEmpty() || number < peekMaxHeap()) {
				insertMaxHeap(number);
			} else {
				insertMinHeap(number);
			}

			if (minHeap.size() - maxHeap.size() > 1) {
				insertMaxHeap(removeMinHeap());
			} else if (maxHeap.size() - minHeap.size() > 1) {
				insertMinHeap(removeMaxHeap());
			}
		}

		public double getMedianOptimize() {
			if (minHeap.size() != maxHeap.size()) {
				if (minHeap.size() > maxHeap.size()) {
					return peekMinHeap();
				} else {
					return peekMaxHeap();
				}
			} else {
				return (peekMinHeap() + peekMaxHeap()) / 2.0;
			}
		}

		List<Integer> minHeap = new ArrayList<>();
		List<Integer> maxHeap = new ArrayList<>();

		private List<Integer> buildMinHeap(List<Integer> minHeap) {
			if (minHeap.isEmpty()) {
				return minHeap;
			}

			int startIdx = ((minHeap.size() - 1) / 2) - 1;
			for (int i = startIdx; i >= 0; i--) {
				shiftDownMinHeap(i, minHeap.size(), minHeap);
			}
			this.minHeap = minHeap;
			return minHeap;
		}

		private void shiftDownMinHeap(int currentIdx, int endIdx, List<Integer> heap) {
			while (currentIdx <= ((endIdx - 1) / 2) - 1) {
				int left = 2 * currentIdx + 1;
				int right = 2 * currentIdx + 2;

				if (right < endIdx) {
					int min = Math.min(heap.get(left), heap.get(right));
					int minIndex = heap.indexOf(min) == left ? left : right;
					if (heap.get(currentIdx) > min) {
						swap(heap.indexOf(min), currentIdx, heap);
						currentIdx = minIndex;
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

		private void shiftUpMinHeap(int endIdx, List<Integer> minHeap) {
			while (endIdx > 0) {
				int currentRoot = (endIdx - 1) / 2;
				if (minHeap.get(currentRoot) > minHeap.get(endIdx)) {
					swap(currentRoot, endIdx, minHeap);
					endIdx = currentRoot;
				} else {
					break;
				}
			}
			this.minHeap = minHeap;
		}

		private void insertMinHeap(int number) {
			if (minHeap.isEmpty()) {
				minHeap.add(number);
			} else {
				minHeap.add(number);
				shiftUpMinHeap(minHeap.size() - 1, minHeap);
			}
		}

		private int removeMinHeap() {
			if (minHeap.isEmpty()) {
				return -1;
			}
			if (minHeap.size() == 1) {
				return minHeap.remove(0);
			} else {
				swap(0, minHeap.size() - 1, minHeap);
				int removedItem = minHeap.remove(minHeap.size() - 1);
				shiftDownMinHeap(0, minHeap.size(), minHeap);
				return removedItem;
			}
		}

		private int peekMinHeap() {
			if (minHeap.isEmpty()) {
				return -1;
			}
			return minHeap.get(0);
		}

		private List<Integer> buildMaxHeap(List<Integer> maxHeap) {
			if (maxHeap.isEmpty()) {
				return maxHeap;
			}

			int startIdx = ((maxHeap.size() - 1) / 2) - 1;
			for (int i = startIdx; i >= 0; i--) {
				shiftDownMaxHeap(i, maxHeap.size(), maxHeap);
			}
			this.maxHeap = maxHeap;
			return maxHeap;
		}

		private void shiftUpMaxHeap(int endIdx, List<Integer> maxHeap) {
			while (endIdx > 0) {
				int currentRoot = (endIdx - 1) / 2;
				if (maxHeap.get(currentRoot) < maxHeap.get(endIdx)) {
					swap(currentRoot, endIdx, maxHeap);
					endIdx = currentRoot;
				} else {
					break;
				}
			}
			this.maxHeap = maxHeap;
		}

		private void shiftDownMaxHeap(int currentIdx, int endIdx, List<Integer> heap) {
			while (currentIdx <= ((endIdx - 1) / 2) - 1) {
				int left = 2 * currentIdx + 1;
				int right = 2 * currentIdx + 2;

				if (right < endIdx) {
					int max = Math.max(heap.get(left), heap.get(right));
					int maxIndex = heap.indexOf(max) == left ? left : right;
					if (heap.get(currentIdx) < max) {
						swap(heap.indexOf(max), currentIdx, heap);
						currentIdx = maxIndex;
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

		private void insertMaxHeap(int number) {
			if (maxHeap.isEmpty()) {
				maxHeap.add(number);
			} else {
				maxHeap.add(number);
				shiftUpMaxHeap(maxHeap.size() - 1, maxHeap);
			}
		}

		private int removeMaxHeap() {
			if (maxHeap.isEmpty()) {
				return -1;
			}
			if (maxHeap.size() == 1) {
				return maxHeap.remove(0);
			} else {
				swap(0, maxHeap.size() - 1, maxHeap);
				int removedItem = maxHeap.remove(maxHeap.size() - 1);
				shiftDownMaxHeap(0, maxHeap.size(), maxHeap);
				return removedItem;
			}
		}

		private int peekMaxHeap() {
			if (maxHeap.isEmpty()) {
				return -1;
			}
			return maxHeap.get(0);
		}

		private void swap(int a, int b, List<Integer> heap) {
			int tmp = heap.get(a);
			heap.set(a, heap.get(b));
			heap.set(b, tmp);
		}
	}
}
