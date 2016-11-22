package org.mohsin.geek.List;

public class Rotate {

	public static ListNode rotateList(ListNode head,int k){
		
		if(k == 0 || head == null)
			return head;
		
		ListNode curr = head;
		int count = 1;
		while(curr != null && count < k){
			curr = curr.getNext();
			++count;
		}
		
		ListNode kth = curr;
		
		while(curr.getNext() != null){
			curr = curr.getNext();
		}
		
		curr.setNext(head);
		
		head = kth.getNext();
		
		kth.setNext(null);
		
		return head;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		head.printList(head);
		System.out.println("after rotation : ");
		head = rotateList(head, 3);
		head.printList(head);

	}

}
