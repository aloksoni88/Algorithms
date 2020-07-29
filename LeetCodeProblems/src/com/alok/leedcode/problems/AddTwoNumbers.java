package com.alok.leedcode.problems;

public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers addNumbers = new AddTwoNumbers();
		ListNode l1 = addNumbers.new ListNode(2);
		ListNode l2 = addNumbers.new ListNode(5);
		
		ListNode secondl1 = addNumbers.new ListNode(4);
		ListNode secondl2 = addNumbers.new ListNode(6);
		l1.next = secondl1;
		l2.next = secondl2;
		l1 = l1.next;
		l2 = l2.next;
		
		ListNode thirdl1 = addNumbers.new ListNode(3);
		ListNode thirdl2 = addNumbers.new ListNode(4);
		l1.next = thirdl1;
		l2.next = thirdl2;
		
		ListNode listNode = addNumbers.addTwoNumbers(l1, l2);
		System.out.println(listNode);
		
	}

	/**
	 * Definition for singly-linked list.
	 */
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        //String input1 = "", input2 = "";
        ListNode node=null,head = null;
        int rem =0;
        while(tmp1 != null && tmp2 != null){
            if(node == null){
                int val = tmp1.val + tmp2.val;
                rem = val/10;
                if(val > 9){
                    val = val%10;
                }
                node = new ListNode(val);
                head = node;
            }else{
                int val = rem + tmp1.val + tmp2.val;
                rem = val/10;
                if(val > 9){
                    val = val%10;
                }
                ListNode newNode = new ListNode(val);
                node.next = newNode;
                node = node.next;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        
        
        while(tmp1 != null){
            int val = rem + tmp1.val;
            rem = val/10;
            if(val > 9){
                val = val%10;
            }
            ListNode newNode = new ListNode(val);
            node.next = newNode;
            node = node.next;
            tmp1 = tmp1.next;
        }
        
        while(tmp2 != null){
            int val = rem + tmp2.val;
            rem = val/10;
            if(val > 9){
                val = val%10;
            }
            ListNode newNode = new ListNode(val);
            node.next = newNode;
            node = node.next;
            tmp2 = tmp2.next;
        }
        if(rem != 0){
            node.next = new ListNode(rem);
        }
        return head;
    }
}
