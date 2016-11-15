package org.mohsin.geek.List;

public class GetMiddleElement {

	public static ListNode getMid(ListNode head)
	{
		ListNode slow = head,fast = head;
		while(fast != null && fast.getNext() != null)
		{
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}
	
	public static void main(String args[])
	{
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		head.printList(head);
		ListNode midNode = getMid(head);
		System.out.println("Middle element is : "+midNode.getData());
	}
}
