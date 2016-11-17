package org.mohsin.geek.List;

public class PairWiseSwap {

	public static ListNode swapRecursive(ListNode head){
		if(head == null || head.getNext() == null)
			return head;
		
		ListNode newHead = head.getNext();
		ListNode remaining = head.getNext().getNext();
		head.getNext().setNext(head);
		head.setNext(swapRecursive(remaining));
		
		return newHead;
	}
	
	public static ListNode swapNodesIterative(ListNode head){
		if(head == null || head.getNext() == null)
			return head;
		ListNode prev = head;
		ListNode curr = prev.getNext();
		head = head.getNext();
		
		while(true){
			ListNode next = curr.getNext();
			curr.setNext(prev);
			
			if(next == null || next.getNext() == null)
			{
				prev.setNext(next);
				break;
			}
			
			prev.setNext(next.getNext());
			
			prev = next;
			curr = prev.getNext();
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(9));
		a.getNext().getNext().setNext(new ListNode(15));
		a.getNext().getNext().getNext().setNext(new ListNode(30));

		a.printList(a);
		a = swapNodesIterative(a);
		a.printList(a);
		a = swapRecursive(a);
		a.printList(a);
		
	}

}
