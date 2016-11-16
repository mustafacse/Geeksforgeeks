package org.mohsin.geek.List;

public class RemoveDuplicatesFromUnsortedList {

	public static void removeDuplicatesNode(ListNode head){
		if(head == null) return;
		
		ListNode curr = head, prev = null,next = null;
		while(curr.getNext() != null){
			next = curr.getNext();
			prev = curr;
			
			while(next != null){
				if(next.getData() == curr.getData()){
					prev.setNext(next.getNext());
				}
				else{
					prev = next;
				}
				next = next.getNext();
			}
			curr = curr.getNext();
		}
	}
	
	public static void main(String[] args) {
	
		ListNode head = new ListNode(12);
		head.setNext(new ListNode(11));
		head.getNext().setNext(new ListNode(12));
		head.getNext().getNext().setNext(new ListNode(21));
		head.getNext().getNext().getNext().setNext(new ListNode(41));
		head.getNext().getNext().getNext().getNext().setNext(new ListNode(45));
		head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(21));
		
		head.printList(head);
		removeDuplicatesNode(head);
		System.out.println("After removal of duplicate nodes : ");
		head.printList(head);
		
	}

}
