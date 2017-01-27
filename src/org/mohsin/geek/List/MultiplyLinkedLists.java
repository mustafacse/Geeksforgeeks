package org.mohsin.geek.List;

public class MultiplyLinkedLists {

	public static ListNode multiply(ListNode first,ListNode second){
		
		if(first == null || second == null)
			return null;

		int num1 = 0,num2 = 0;
		
		while(first != null || second != null){
			if(first != null){
				num1 = num1*10+first.getData();
				first = first.getNext();
			}if(second != null){
				num2 = num2*10+second.getData();
				second = second.getNext();
			}
		}
		
		int res = num1*num2;
		ListNode head = null;
		while(res > 0){
			int rem = res%10;
			res /= 10;
			ListNode newNode = new ListNode(rem);
			newNode.setNext(head);
			head = newNode;
		}
		return head;
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(3);
		a.setNext(new ListNode(2));
		
		ListNode b = new ListNode(2);
		
		ListNode res = multiply(a, b);
		res.printList(res);
		
		
	}

}
