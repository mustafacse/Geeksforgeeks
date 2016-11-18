package org.mohsin.geek.List;

public class DeleteIfRightIsBigger {

	
	public static ListNode delete(ListNode head){
		
		if(head == null || head.getNext() == null){
			return head;
		}
		
		ListNode curr = head;
		while(curr.getNext() != null && curr.getData() < curr.getNext().getData())
			curr = curr.getNext();
		
		head = curr;
		ListNode prev = curr;
		curr = curr.getNext();
		while(curr.getNext() != null){
			if(curr.getData() < curr.getNext().getData()){
				prev.setNext(curr.getNext());
				curr = prev.getNext();
			}else{
				prev = curr;
				curr = curr.getNext();
			}
		}
		return head;
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
		int arr[] = {3,2,6,5,11,10,15,12};
		for(int i = 0;i < arr.length;++i){
			head = push(head,arr[i]);
		}
		head.printList(head);
		System.out.println("After deletion : ");
		head = delete(head);
		head.printList(head);

	}

}
