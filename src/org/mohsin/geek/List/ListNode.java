package org.mohsin.geek.List;

public class ListNode {

	private int data;
	private ListNode next;
	
	public ListNode(){
		
	}
	
	public ListNode(int data, ListNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	public ListNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public void printList(ListNode head)
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println("--------------------------------");
	}
	
	public int getLength(ListNode head)
	{
		int length = 0;
		
		while(head != null){
			head = head.getNext();
			++length;
		}
		return length;
		
	}
	
	public void printReverse(ListNode head)
	{
		if(head == null)
			return;
		printReverse(head.getNext());
		System.out.println(head.getData());
	}
	
	public boolean isIdentical(ListNode head){
		ListNode curr = this;
		while(curr != null && head != null){
			if(curr.getData() != head.getData())
				return false;
			head = head.getNext();
			curr = curr.getNext();
		}
		if(curr == null && head == null)
			return true;
		return false;
	}
}
