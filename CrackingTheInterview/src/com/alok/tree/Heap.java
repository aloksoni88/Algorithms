/**
 * 
 */
package com.alok.tree;

import java.util.ArrayList;

/**
 * @author Alok Soni
 *
 */
public class Heap {
	
	private int[] arr;
	private int arrIndex = -1;
	private ArrayList<Integer> maxHeap = new ArrayList<Integer>();
	
	public Heap(int size) {
		arr = new int[size];
	}
	
	public boolean isEmpty() {
		return arrIndex == -1;
	}
	
	public void insert(int item) {
		if(!isEmpty()) {
			arr[++arrIndex] = item;
			heapify();
		}else {
			arr[++arrIndex] = item;
		}
	}
	
	public void heapify() {
		int loc = arrIndex;
		int itemIndex = arrIndex;
		while(loc > 0) {
			if(itemIndex%2 == 0) {
				loc = (loc-2)/2;
			}else {
				loc = (loc-1)/2;
			}
			if(arr[itemIndex] > arr[loc]) {
				int tmp = arr[itemIndex];
				arr[itemIndex] = arr[loc];
				arr[loc] = tmp;
				itemIndex = loc;
			}else {
				break;
			}
		}
	}
	
	private void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	
	private void maxHeapity() {
		int loc = 0;
		while(loc < arrIndex) {
			int left  = 2*loc +1;
			int right = 2*loc +2;
			if(left <= arrIndex && right <= arrIndex) {
				if(arr[left] > arr[right] && arr[loc] < arr[left]) {
					int tmp = arr[left];
					arr[left] = arr[loc];
					arr[loc] = tmp;
					loc = left;
				}else if(arr[right] > arr[left] && arr[loc] < arr[right]) {
					int tmp = arr[right];
					arr[right] = arr[loc];
					arr[loc] = tmp;
					loc = right;
				}else {
					break;
				}
			}else if(arr[loc] < arr[left]) {
				int tmp = arr[left];
				arr[left] = arr[loc];
				arr[loc] = tmp;
				loc = left;
			}else {
				break;
			}
		}
		
	}
	
	public int getMax() {
		if(!isEmpty()) {
			maxHeap.add(arr[0]);
			arr[0] = arr[arrIndex--] ;
			maxHeapity();
			return arr[0];
		}
		return -1;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}else {
			String str = "[";
			for(int i=0; i<=arrIndex; i++) {
				str = str + arr[i] + ", ";
			}
			str = str.substring(0,str.length()-2) +"]";
			return str;
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		
		heap.insert(10);
		heap.insert(12);
		heap.insert(14);
		
		System.out.println(Math.abs(8-5));
//		heap.insert(8);
//		heap.insert(40);
//		heap.insert(20);
//		heap.insert(25);
//		heap.insert(50);
//		heap.insert(60);
//		heap.insert(28);
//		
//		System.out.println(heap);
//		
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		heap.getMax();
//		System.out.println(heap.maxHeap);
		
		System.out.println(heap);
	}
}
