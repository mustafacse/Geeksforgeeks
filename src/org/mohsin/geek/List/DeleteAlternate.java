package org.mohsin.geek.List;

public class DeleteAlternate {

	public static void delAltIterative(ListNode head){
		if(head == null || head.getNext() == null)
			return;
		
		ListNode curr = head;
		while(curr.getNext() != null){
			curr.setNext(curr.getNext().getNext());
			curr = curr.getNext();
		}
		
	}
	
	public static void delAltRecur(ListNode head){
		if(head == null || head.getNext() == null)
			return ;
		head.setNext(head.getNext().getNext());
		delAltRecur(head.getNext());
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(9));
		a.getNext().getNext().setNext(new ListNode(15));
		a.getNext().getNext().getNext().setNext(new ListNode(30));

		a.printList(a);
		System.out.println("After alternate deletion : ");
		//delAltIterative(a);
		delAltRecur(a);
		a.printList(a);
	}

}
