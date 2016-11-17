package org.mohsin.geek.List;

public class ReverseInGroups {

	public static ListNode reverseInGroup(ListNode head,int k){
		if(head == null || head.getNext() == null)
			return head;
		
		ListNode newHead = null,prev = null;
		ListNode curr = head;
		int count = 0;
		while(curr != null && count < k){
			prev = newHead;
			newHead = curr;
			curr = curr.getNext();
			newHead.setNext(prev);
			++count;
		}
		
		head.setNext(reverseInGroup(curr, k));
		return newHead;
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(3);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(9));
		a.getNext().getNext().setNext(new ListNode(15));
		a.getNext().getNext().getNext().setNext(new ListNode(30));

		a.printList(a);
		System.out.println("After reversal ");
		a = reverseInGroup(a, 3);
		a.printList(a);
	}

}
