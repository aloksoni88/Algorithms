package com.stack;

import java.util.Arrays;

public class ThreeInOneStack<T> {
	
	static class KStack  
    { 
        int arr[];   // Array of size n to store actual content to be stored in stacks 
        int top[];   // Array of size k to store indexes of top elements of stacks 
        int next[];  // Array of size n to store next entry in all stacks 
                     // and free list 
        int n, k; 
        int free; // To store beginning index of free list 
  
        //constructor to create k stacks in an array of size n 
        KStack(int k1, int n1)  
        { 
            // Initialize n and k, and allocate memory for all arrays 
            k = k1; 
            n = n1; 
            arr = new int[n]; 
            top = new int[k]; 
            next = new int[n]; 
  
            // Initialize all stacks as empty 
            for (int i = 0; i < k; i++) 
                top[i] = -1; 
  
            // Initialize all spaces as free 
            free = 0; 
            for (int i = 0; i < n - 1; i++) 
                next[i] = i + 1; 
            next[n - 1] = -1; // -1 is used to indicate end of free list 
        } 
  
        // A utility function to check if there is space available 
        boolean isFull()  
        { 
            return (free == -1); 
        } 
  
        // To push an item in stack number 'sn' where sn is from 0 to k-1 
        void push(int item, int sn)  
        { 
            // Overflow check 
            if (isFull())  
            { 
                System.out.println("Stack Overflow"); 
                return; 
            } 
  
            int i = free; // Store index of first free slot 
  
            // Update index of free slot to index of next slot in free list 
            free = next[i]; 
  
            // Update next of top and then top for stack number 'sn' 
            next[i] = top[sn]; 
            top[sn] = i; 
  
            // Put the item in array 
            arr[i] = item; 
        } 
  
        // To pop an from stack number 'sn' where sn is from 0 to k-1 
        int pop(int sn)  
        { 
            // Underflow check 
            if (isEmpty(sn))  
            { 
                System.out.println("Stack Underflow"); 
                return Integer.MAX_VALUE; 
            } 
  
            // Find index of top item in stack number 'sn' 
            int i = top[sn]; 
  
            top[sn] = next[i]; // Change top to store next of previous top 
  
            // Attach the previous top to the beginning of free list 
            next[i] = free; 
            free = i; 
  
            // Return the previous top item 
            return arr[i]; 
        } 
  
        // To check whether stack number 'sn' is empty or not 
        boolean isEmpty(int sn)  
        { 
            return (top[sn] == -1); 
        } 
  
    } 
  
    // Driver program 
    public static void main(String[] args)  
    { 
        // Let us create 3 stacks in an array of size 10 
        int k = 3, n = 10; 
          
        KStack ks = new KStack(k, n); 
  
        ks.push(15, 2); 
        ks.push(45, 2); 
  
        // Let us put some items in stack number 1 
        ks.push(17, 1); 
        ks.push(49, 1); 
  
        // Let us put some items in stack number 0 
        ks.push(11, 0); 
        ks.push(9, 0); 
        ks.push(7, 0); 
        
        ks.push(111, 1);
        ks.push(32334, 0);
        ks.push(3333, 2);
        
        System.out.println(Arrays.toString(ks.next));
        System.out.println(Arrays.toString(ks.arr));
        System.out.println(Arrays.toString(ks.top));
        System.out.println(ks.free);
        
//        System.out.println(ks);
//  
//        System.out.println("Popped element from stack 2 is " + ks.pop(2)); 
//        System.out.println("Popped element from stack 1 is " + ks.pop(1)); 
//        System.out.println("Popped element from stack 0 is " + ks.pop(0)); 
    } 
	
//	private int SIZE = 10;
//	private int STACK_COUNT = 3;
//	private int[] topArr;  
//	private T[] itemArr;
//
//	
//	private void setSizeAndStackCount(int noOfStack,int size) {
//		STACK_COUNT = noOfStack;
//		SIZE = size;
//		topArr = new int[STACK_COUNT];
//		itemArr = (T[]) new Object[SIZE*STACK_COUNT];
//		for(int i=0; i<STACK_COUNT;i++) {
//			topArr[i] = -1;
//		}
//	}
//	
//	public boolean isEmpty(int stackNo) {
//		return topArr[stackNo] == -1;
//	}
//	
//	public int size(int stackNo) {
//		if(isEmpty(stackNo)) {
//			return 0;
//		}
//		return topArr[stackNo]+1;
//	}
//	
//	public boolean add(T item,int stackNo) {
//		if(topArr[stackNo] == SIZE-1) {
//			System.out.println("Over flow");
//			return false;
//		}else {
//			int top = topArr[stackNo];
//			if(top == 0) {
//				itemArr[++top] = item;	
//			}else if(top ==1) {
//				
//			}else{
//				
//			}
//		}
//		return false;
//	}
//	
//	public boolean push(T item,int stackNo) {
//		return add(item,stackNo);
//	}
//	
//	public T pop(int stackNO) {
//		if(topArr[stackNO] == -1) {
//			throw new EmptyStackException();
//		}
//		return itemArr[topArr[stackNO]--];
//	}
//	
//	public T peek(int stackNO) {
//		if(topArr[stackNO] == -1) {
//			throw new EmptyStackException();
//		}
//		return itemArr[topArr[stackNO]];
//	}
//	
//	private String display(int stackNo) {
//		if(isEmpty(stackNo)) {
//			return "[]";
//		}else {
//			String str = "[";
//			for(int i=topArr[stackNo]; i>=0; i--) {
//				str = str + itemArr[i] +",";
//			}
//			str = str.substring(0, str.length()-1) +"]";
//			return str;
//		}
//		
//	}
//	
//
//	public static void main(String[] args) {
//		ThreeInOneStack<Integer> stack = new ThreeInOneStack<Integer>();
//		stack.setSizeAndStackCount(3, 10);
//		stack.add(10,0);
//		
//		stack.add(100,1);
//		stack.add(200,1);
//	
//		stack.add(1000,2);
//		stack.add(2000,2);
//		stack.add(3000,2);
//		
//		System.out.println(stack.display(0));
//		System.out.println(stack.display(1));
//		System.out.println(stack.display(2));
//	}
}
