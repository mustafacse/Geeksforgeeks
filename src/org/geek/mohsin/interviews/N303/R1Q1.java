package org.geek.mohsin.interviews.N303;

import org.mohsin.geek.List.ListNode;

public class R1Q1 {

	public static ListNode arrange(ListNode head){
		if(head == null || head.getNext() == null){
			return head;
		}
		
		ListNode curr = head;
		ListNode tail = head,end = null;
		ListNode prev = null;
		while(tail.getNext() != null)
			tail = tail.getNext();
		
		end = tail;
		
		boolean flag = true;
		while(curr != end){
			if(curr.getData() == 1){
				ListNode next = curr.getNext();
				tail.setNext(curr);
				tail = tail.getNext();
				if(prev != null)
					prev.setNext(curr.getNext());
				curr.setNext(null);
				curr = next;
			}else{
				if(flag){
					head = curr;
					flag = false;
				}
				prev = curr;
				curr = curr.getNext();
			}
		}
		
		return head;
	}
	
	public static void main(String args[]){
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(0));
		head.getNext().setNext(new ListNode(0));
		head.getNext().getNext().setNext(new ListNode(1));
		head.getNext().getNext().getNext().setNext(new ListNode(0));
		
		head.printList(head);
		System.out.println("After arrangement : ");
		head = arrange(head);
		head.printList(head);
	}
}
