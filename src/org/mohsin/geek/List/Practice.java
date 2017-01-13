package org.mohsin.geek.List;

public class Practice {

	public static ListNode alter(ListNode head){
		
		if(head == null || head.getNext() == null)
			return head;
		
		ListNode curr = head;
		ListNode tail = head;
		while(tail.getNext() != null)
			tail = tail.getNext();
		
		ListNode end = tail;
		ListNode prev = null;
		
		ListNode newHead = null;
		
		while(curr != end){
			if(curr.getData()%2 == 0){
				if(newHead == null)
					newHead = curr;
				prev = curr;
				curr = curr.getNext();
			}else{
				ListNode next = curr.getNext();
				tail.setNext(curr);
				curr.setNext(null);
				tail = tail.getNext();
				if(prev != null)
					prev.setNext(next);
				curr = next;
			}
		}
		return newHead;
	}
	
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(4));
		head.getNext().getNext().setNext(new ListNode(3));
		
		head.printList(head);
		head = alter(head);
		head.printList(head);

	}

}
