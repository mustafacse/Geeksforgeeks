package org.mohsin.geek.List;

public class ReverseList {

	
	public static ListNode reverse(ListNode head)
	{
		ListNode prev = null, newNode = null;
		ListNode curr = head;
		
		while(curr != null)
		{
			prev = newNode;
			newNode = curr;
			curr = curr.getNext();
			newNode.setNext(prev);
		}
		
		return newNode;
		
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));

		head.printList(head);
		head = reverse(head);
		head.printList(head);
	}

}
