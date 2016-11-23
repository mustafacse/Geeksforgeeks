package org.mohsin.geek.List;

public class ReverseAlternateAndAppendAtTheEnd {

	public static void rearrange(ListNode head) {

		if (head == null || head.getNext() == null || head.getNext().getNext() == null)
			return;

		ListNode odd = head;
		ListNode even = odd.getNext();

		odd.setNext(odd.getNext().getNext());
		even.setNext(null);
		odd = odd.getNext();

		while (odd != null && odd.getNext() != null) {

			ListNode temp = odd.getNext().getNext();

			odd.getNext().setNext(even);
			even = odd.getNext();

			odd.setNext(temp);

			if (temp != null)
				odd = temp;
		}

		odd.setNext(even);

	}

	public static ListNode push(ListNode head, int data) {

		ListNode temp = new ListNode(data);
		temp.setNext(head);
		head = temp;
		return head;
	}

	public static void main(String[] args) {

		int arr[] = {6,5,4,3,2,1};
		ListNode head = null;
		
		for(int i = 0;i < arr.length;++i)
			head = push(head,arr[i]);
		
		head.printList(head);
		System.out.println("After rearrangement : ");
		rearrange(head);
		head.printList(head);
	}

}
