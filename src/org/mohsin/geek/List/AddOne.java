package org.mohsin.geek.List;

public class AddOne {

	private static int carry = 1;
	
	public static void add(ListNode head){
		
		if(head == null)
			return;
		
		add(head.getNext());
		int sum = head.getData()+carry;
		carry = sum/10;
		sum %= 10;
		head.setData(sum);
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		a.setNext(new ListNode(9));
		a.getNext().setNext(new ListNode(9));
		a.getNext().getNext().setNext(new ListNode(9));

		add(a);
		if(carry > 0){
			ListNode newNode = new ListNode(carry);
			newNode.setNext(a);
			a = newNode;
		}
		
		a.printList(a);
	}

}
