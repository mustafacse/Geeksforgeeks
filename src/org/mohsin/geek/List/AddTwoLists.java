package org.mohsin.geek.List;

public class AddTwoLists {

	private static int carry = 0;
	private static ListNode head = null;

	public static ListNode addSameLengthLists(ListNode a, ListNode b) {

		if (a == null)
			return null;

		ListNode result = new ListNode();
		result.setNext(addSameLengthLists(a.getNext(), b.getNext()));

		int sum = a.getData() + b.getData() + carry;
		carry = sum / 10;
		sum %= 10;
		result.setData(sum);

		return result;
	}
	
	public static void addCarry2Remaining(ListNode curr,ListNode end){
		if(curr != end){
			
			addCarry2Remaining(curr.getNext(), end);
			int sum = curr.getData()+carry;
			carry = sum/10;
			sum %= 10;
			push(sum);
		}
	}

	public static void push(int data){
		
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head = newNode;
	}
	
	public static void add(ListNode a,ListNode b){
		
		if(a == null)
		{
			head = b;
			return;
		}
		
		if(b == null)
		{
			head = a;
			return;
		}
		
		int len1 = a.getLength(a);
		int len2 = b.getLength(b);
		
		if(len1 == len2)
			head = addSameLengthLists(a, b);
		else{
			int diff= 0 ;
			if(len1 > len2){
				diff = len1-len2;
			}else{
				diff = len2-len1;
				ListNode temp = a;
				a = b;
				b = temp;
			}
			
			ListNode curr = a;
			while(diff > 0){
				curr = curr.getNext();
				--diff;
			}
			
			head = addSameLengthLists(curr, b);
			addCarry2Remaining(curr,a);
		}
		
		if(carry > 0)
			push(carry);
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(5);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(3));
		
		ListNode b = new ListNode(8);
		b.setNext(new ListNode(4));
		b.getNext().setNext(new ListNode(2));
		
		add(a, b);
		
		a.printList(a);
		b.printList(b);
		head.printList(head);

	}

}
