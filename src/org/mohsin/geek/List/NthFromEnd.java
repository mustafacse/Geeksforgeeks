package org.mohsin.geek.List;

public class NthFromEnd {

	public static ListNode getNth(ListNode head,int n)
	{
		ListNode ptr1 = head,ptr2 = head;
		int count = 0;
		while(ptr1 != null && count < n)
		{
			ptr1 = ptr1.getNext();
			++count;
		}
		
		if(ptr1 == null)
			return null;
		while(ptr1 != null)
		{
			ptr2 = ptr2.getNext();
			ptr1 = ptr1.getNext();
		}
		
		return ptr2;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		head.printList(head);
		
		ListNode nth = getNth(head, 3);
		System.out.println(nth.getData());
	}

}
