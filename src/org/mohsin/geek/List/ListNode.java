package org.mohsin.geek.List;

public class ListNode {

	private int data;
	private ListNode next;
	
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
}
