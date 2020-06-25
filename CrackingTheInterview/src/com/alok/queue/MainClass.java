package com.alok.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainClass {
	public static void main(String[] args) {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<Integer>();
		queue.add(5);
		queue.add(10);
		queue.add(15);
		
//		System.out.println(queue);
//		queue.remove();
//		queue.remove();
//		queue.remove();
	
		System.out.println(queue.size());
		System.out.println(queue);
		
		System.out.println("====================");
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(5);
		q.add(10);
		q.add(15);
		System.out.println(q.peek());
//		System.out.println(q);
//		q.remove();
//		q.remove();
//		q.remove();
		System.out.println(q);
	}
}
