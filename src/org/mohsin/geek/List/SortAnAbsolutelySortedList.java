package org.mohsin.geek.List;

public class SortAnAbsolutelySortedList {

	
	public static ListNode sort(ListNode head){
		
		ListNode prev = head;
		ListNode curr = head.getNext();
		
		while(curr != null){
			if(curr.getData() < prev.getData()){
				prev.setNext(curr.getNext());
				curr.setNext(head);
				head = curr;
				curr = prev;
			}else{
				prev = curr;
			}
			curr = curr.getNext();
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(-10));
		
		head = sort(head);
		head.printList(head);

	}

}
