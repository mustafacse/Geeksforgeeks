package org.mohsin.geek.List;

public class RearrangeListAcc2OddEvenPosition {

	public static ListNode arrange(ListNode head){
		
		if(head == null || head.getNext() == null)
			return head;
		
		ListNode odd = head;
		ListNode even = head.getNext();
		ListNode firstEven = even;
		while(true){
			
			if(odd == null || even == null || even.getNext() == null){
				odd.setNext(firstEven);
				break;
			}
			
			odd.setNext(even.getNext());
			odd = even.getNext();
			
			if(odd.getNext() == null){
				even.setNext(null);
				odd.setNext(firstEven);
				break;
			}
			
			even.setNext(odd.getNext());
			even = odd.getNext();
			
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		a.setNext(new ListNode(2));
		a.getNext().setNext(new ListNode(3));
		a.getNext().getNext().setNext(new ListNode(4));
		a.getNext().getNext().getNext().setNext(new ListNode(5));
		
		a = arrange(a);
		a.printList(a);
	}

}
