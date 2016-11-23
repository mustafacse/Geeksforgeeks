package org.mohsin.geek.List;

import java.util.ArrayList;

public class AlternateMerge {

	public static ArrayList<ListNode> merge(ListNode first,ListNode second){
		
		if(first == null || second == null)
			return null;
		
		ListNode a = first;
		ListNode b = second;
		while(a != null && b != null){
			ListNode aNext = a.getNext();
			ListNode bNext = b.getNext();
			
			a.setNext(b);
			b.setNext(aNext);
			
			a = aNext;
			b = bNext;
		}
		
		ArrayList<ListNode> res = new ArrayList<>();
		res.add(first);
		res.add(b);
		return res;
	}
	
	public static ListNode push(ListNode head,int data){
		
		ListNode temp = new ListNode(data);
		temp.setNext(head);
		head = temp;
		return head;
	}
	
	public static void main(String[] args) {
		
		int arr1[] = {3,2,1};
		int arr2[] = {8,7,6,5,4};
		
		ListNode head1 = null;
		ListNode head2 = null;
		
		for(int i = 0;i < arr1.length;++i)
			head1 = push(head1,arr1[i]);
		
		for(int i = 0;i < arr2.length;++i)
			head2 = push(head2,arr2[i]);
		
		head1.printList(head1);
		head2.printList(head2);
		
		System.out.println("After alternate merge ");
		ArrayList<ListNode> res = merge(head1, head2);
		head1 = res.get(0);
		head2 = res.get(1);
		
		head1.printList(head1);
		head2.printList(head2);

	}

}
