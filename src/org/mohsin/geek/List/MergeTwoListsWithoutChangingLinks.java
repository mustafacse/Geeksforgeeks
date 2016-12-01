package org.mohsin.geek.List;

public class MergeTwoListsWithoutChangingLinks {

	public static void merge(ListNode a,ListNode b){
		
		if(a == null || b == null)
			return;
		
		while(a != null && b != null){
			if(a.getData() > b.getData()){
				int data = a.getData();
				a.setData(b.getData());
				b.setData(data);
				
				ListNode temp = b;
				if(b.getNext() != null && b.getData() > b.getNext().getData()){
					b = b.getNext();
					ListNode ptr = b;
					ListNode prev = null;
					while(ptr != null && ptr.getData() < temp.getData()){
						prev = ptr;
						ptr = ptr.getNext();
					}
					
					prev.setNext(temp);
					temp.setNext(ptr);
				}
			}
			a = a.getNext();
		}
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(2);
		a.setNext(new ListNode(4));
		a.getNext().setNext(new ListNode(7));
		a.getNext().getNext().setNext(new ListNode(8));
		a.getNext().getNext().getNext().setNext(new ListNode(10));
		
		ListNode b = new ListNode(1);
		b.setNext(new ListNode(3));
		b.getNext().setNext(new ListNode(12));
		
		merge(a, b);
		
		a.printList(a);
		b.printList(b);


	}

}
