package org.mohsin.geek.List;

public class ReverseAlternateKNodes {

	public static ListNode reverseAltK(ListNode head,int k){
		if(head == null || head.getNext() == null)
			return head;
		
		ListNode newHead = null, curr = head, prev = null;
		int count = 0;
		while(curr != null && count < k){
			prev = newHead;
			newHead = curr;
			curr = curr.getNext();
			newHead.setNext(prev);
			++count;
		}
		
		head.setNext(curr);
		
		count = 0;
		while(curr != null && count < k-1){
			curr = curr.getNext();
			++count;
		}
		
		if(curr != null)
			curr.setNext(reverseAltK(curr.getNext(), k));
		return newHead;
	}
	
	public static ListNode push(ListNode head,int data){
		ListNode temp = new ListNode(data);
		if(head == null) return temp;
		
		temp.setNext(head);
		head = temp;
		return head;
	}
	
	public static void main(String[] args) {
		
		ListNode head = null;
		for(int i = 1;i <= 10;++i){
			head = push(head,i);
		}
		
		head.printList(head);
		head = reverseAltK(head, 3);
		System.out.println("After reversal : ");
		head.printList(head);
	}

}
