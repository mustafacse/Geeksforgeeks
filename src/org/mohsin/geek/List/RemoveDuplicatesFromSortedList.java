package org.mohsin.geek.List;

public class RemoveDuplicatesFromSortedList {

	public static void removeDuplicates(ListNode head){
		if(head == null) return;
		
		ListNode curr = head;
		while(curr.getNext() != null){
			if(curr.getData() == curr.getNext().getData()){
				curr.setNext(curr.getNext().getNext());
			}
			else{
				curr = curr.getNext();
			}
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(1));
		head.getNext().setNext(new ListNode(2));
		head.getNext().getNext().setNext(new ListNode(3));
		head.getNext().getNext().getNext().setNext(new ListNode(3));
		head.getNext().getNext().getNext().getNext().setNext(new ListNode(4));
		
		head.printList(head);
		removeDuplicates(head);
		System.out.println("After removal of duplicate nodes : ");
		head.printList(head);

	}

}
