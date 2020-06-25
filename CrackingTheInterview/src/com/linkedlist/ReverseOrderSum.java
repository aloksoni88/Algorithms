package com.linkedlist;

public class ReverseOrderSum {
	public static void main(String[] args) {
		MyLinkedList list1 = new MyLinkedList();
		list1.add(7);
		list1.add(1);
		list1.add(6);
		
		MyLinkedList list2 = new MyLinkedList();
		list2.add(5);
		list2.add(9);
		list2.add(2);
		
		
		String sum1 = "",sum2 = "";
		int list1Sum = 0, list2Sum = 0;
		if(list1 != null && !list1.isEmpty()) {
			for(int i=list1.size()-1; i>=0; i--) {
				sum1 = sum1 + list1.get(i);
			}
			list1Sum = Integer.parseInt(sum1);
		}else {
			list1Sum = 0;
		}
		
		if(list2 != null && !list2.isEmpty()) {
			for(int i=list2.size()-1; i>=0; i--) {
				sum2 = sum2 + list2.get(i);
			}
			list2Sum = Integer.parseInt(sum2);
		}else {
			list2Sum = 0;
		}
		
		int listSum = list1Sum + list2Sum;
		String finalSum = String.valueOf(listSum);
		MyLinkedList finalList = new MyLinkedList();
		for(int i= finalSum.length()-1; i>=0 ; i--) {
			int item = Integer.parseInt(""+finalSum.charAt(i));
			finalList.add(item);
		}
		
		System.out.println(finalSum.toString());
	}
}
