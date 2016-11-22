package org.mohsin.geek.List;

import java.util.ArrayList;

public class QuickSortForSinglyLL {

	public static ArrayList<ListNode> partition(ListNode left,ListNode right){
		
		ListNode curr = left,tail = right,pivot = right;
		ListNode prev = null;
		ListNode newHEad = null,newEnd = null;
		
		while(curr != pivot){
			
			if(curr.getData() < pivot.getData()){
				if(newHEad == null)
					newHEad = curr;
				prev = curr;
				curr = curr.getNext();
			}else{
				
				ListNode next = curr.getNext();
				tail.setNext(curr);
				curr.setNext(null);
				tail = curr;
				if(prev != null)
					prev.setNext(next);
				curr = next;
			}
		}
		
		if(newHEad == null)
			newHEad = pivot;
		newEnd = tail;
		
		ArrayList<ListNode> res = new ArrayList<>();
		res.add(newHEad);
		res.add(newEnd);
		res.add(pivot);
		
		return res;
	}
	
	public static ListNode quickSort(ListNode head,ListNode end){
		
		if(head == null || head == end)
			return head;
		
		ArrayList<ListNode> res = partition(head, end);
		ListNode newHead = res.get(0);
		ListNode newEnd = res.get(1);
		ListNode pivot = res.get(2);
		
		if(newHead != pivot){
			
			ListNode temp = newHead;
			while(temp.getNext() != pivot)
				temp = temp.getNext();
			
			temp.setNext(null);
			
			newHead = quickSort(newHead, temp);
			
			temp = newHead;
			while(temp.getNext() != null)
				temp = temp.getNext();
			
			temp.setNext(pivot);
		}
		
		pivot.setNext(quickSort(pivot.getNext(), newEnd));
		
		return newHead;
	}
	
	public static ListNode getTail(ListNode head)
	{
		if(head == null || head.getNext() == null)
			return head;
		
		ListNode curr = head;
		while(curr.getNext() != null)
			curr = curr.getNext();
		
		return curr;
	}
	
	public static ListNode push(ListNode head,int data){
		
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head = newNode;
		return head;
	}
	
	public static void main(String[] args) {
		
		int ar[] = {3,1,2,5,9,7,5,4};
		ListNode head = null;
		
		for(int i = 0;i < ar.length;++i)
			head = push(head,ar[i]);

		head.printList(head);
		
		System.out.println("After Sorting : ");
		head = quickSort(head, getTail(head));
		head.printList(head);
	}

}
