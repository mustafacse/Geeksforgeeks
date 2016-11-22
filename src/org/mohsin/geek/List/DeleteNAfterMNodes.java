package org.mohsin.geek.List;

public class DeleteNAfterMNodes {

	public static void deleteN(ListNode head,int m,int n){
		
		if(head == null)
			return;
		
		ListNode curr = head;
		while(curr != null){
			
			for(int i = 1;i < m && curr != null;++i)
				curr = curr.getNext();
			
			if(curr == null)
				return;
			
			ListNode temp = curr.getNext();
			for(int i = 1;i <= n && temp != null;++i)
				temp = temp.getNext();
			
			curr.setNext(temp);
			
			curr = temp;
			
		}
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		head.printList(head);
		System.out.println("After delete");
		deleteN(head, 1, 1);
		head.printList(head);
	}

}
