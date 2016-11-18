package org.mohsin.geek.List;

public class DetectAndRemoceRemove {

	public static ListNode detectLoop(ListNode head){
		
		if(head == null || head.getNext() == null)
			return null;
		
		ListNode slow = head, fast = head;
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast)
				return slow;
		}
		return null;
	}
	
	public static void removeLoop(ListNode head,ListNode loop){
		
		ListNode ptr1 = loop,ptr2 = loop;
		
		int count = 1;
		while(ptr1.getNext() != ptr2){
			ptr1 = ptr1.getNext();
			++count;
		}
		
		ptr1 = head;
		ptr2 = head;
		
		for(int i = 0;i < count;++i){
			ptr1 = ptr1.getNext();
		}
		
		while(ptr1 != ptr2){
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}
		
		while(ptr1.getNext() != ptr2)
			ptr1 = ptr1.getNext();
		
		ptr1.setNext(null);
	}
	
	public static void detectAndRemove(ListNode head){
		
		if(head == null || head.getNext() == null)
			return;
		
		ListNode loopNode = detectLoop(head);
		if(loopNode != null)
			removeLoop(head, loopNode);
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		head.getNext().getNext().getNext().getNext().setNext(head.getNext().getNext());
		
		//head.printList(head); //infinite loop
		detectAndRemove(head);
		head.printList(head);
	}

}
