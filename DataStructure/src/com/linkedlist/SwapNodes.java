package com.linkedlist;

public class SwapNodes {
	public Node swapNode(Node head,int x, int y){
		if(x == y){
			System.out.println("Both values are same");
			return head;
		}
		Node tmp = head;
		Node prevX = null,currX = null;
		Node prevY = null,currY = null;
		boolean foundX = false, foundY = false;
		while(tmp != null){
			if(tmp!= null && tmp.data == x){
				foundX = true;
				currX = tmp;
			}else if(tmp != null && tmp.data == y){
				foundY = true;
				currY = tmp;
			}
			if(!foundX){
				prevX = tmp;	
			}
			if(!foundY){
				prevY = tmp;	
			}
			tmp= tmp.next;
		}
			
		
		if(currX == null || currY == null){
			System.out.println("Invalid values");
			return head;
		}

		if(prevX == null){
			head = currY;
		}else{
			prevX.next = currY;
		}
		if(prevY == null){
			head = currX;
		}else{
			prevY.next = currX;
		}
		
		
		Node t = currX.next;
		currX.next = currY.next;
		currY.next = t;
		return head;
	}
}
