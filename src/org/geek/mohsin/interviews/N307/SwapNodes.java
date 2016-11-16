package org.geek.mohsin.interviews.N307;

import org.mohsin.geek.List.ListNode;

public class SwapNodes {

	public static ListNode swapNodes(ListNode list,int x,int y){
		if(list == null) return list;
		
		ListNode prevX = null,currX = list;
		ListNode prevY = null,currY = list;
		
		while(currX != null && currX.getData() != x){
			prevX = currX;
			currX = currX.getNext();
		}
		
		while(currY != null && currY.getData() != y){
			prevY = currY;
			currY = currY.getNext();
		}
		
		if(currX == null || currY == null)
			return list;
		
		if(prevX != null)
			prevX.setNext(currY);
		else
			list = currY;
		
		if(prevY != null)
			prevY.setNext(currX);
		else
			list = currX;
		
		ListNode temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);
		
		return list;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		head.printList(head);
		System.out.println("After Swapping : ");
		head = swapNodes(head, 2, 5);
		head.printList(head);

	}

}
