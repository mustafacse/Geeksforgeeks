package org.mohsin.geek.List;

public class DoublyList {

	private int data;
	private DoublyList prev;
	private DoublyList next;
	public DoublyList(int data) {
		super();
		this.data = data;
	}
	public DoublyList(int data, DoublyList prev, DoublyList next) {
		super();
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoublyList getPrev() {
		return prev;
	}
	public void setPrev(DoublyList prev) {
		this.prev = prev;
	}
	public DoublyList getNext() {
		return next;
	}
	public void setNext(DoublyList next) {
		this.next = next;
	}
	
	public void printList(DoublyList head)
	{
		while(head != null){
			System.out.print(head.getData()+" ");
			head = head.getNext();
		}
		System.out.println("-------------------------------");
	}
	
	public DoublyList reverse(DoublyList head)
	{
		if(head == null || head.getNext() == null) return head;
		
		DoublyList curr = head;
		DoublyList temp = null;
		while(curr != null){
			temp = curr.getPrev();
			curr.setPrev(curr.getNext());
			curr.setNext(temp);
			curr = curr.getPrev();
		}
		
		return temp.getPrev();
	}
}
