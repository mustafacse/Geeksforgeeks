package org.mohsin.geek.List;

public class SortedInsert {

	public static ListNode insert(ListNode head,ListNode newNode){
		
		if(head == null || head.getData() >= newNode.getData()){
			newNode.setNext(head);
			head = newNode;
			return head;
		}
		
		ListNode curr = head;
		ListNode prev = null;
		while(curr != null && curr.getData() < newNode.getData()){
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(newNode);
		if(curr != null){
			newNode.setNext(curr);
		}
		return head;
	}
	
	public static void main(String args[]){
		ListNode head = null;
		for(int i = 1;i <= 7;++i)
			head = insert(head,new ListNode(i));
		
		head = insert(head,new ListNode(8));
		head = insert(head,new ListNode(0));
		head = insert(head,new ListNode(5));
		
		head.printList(head);
	}
	
}
