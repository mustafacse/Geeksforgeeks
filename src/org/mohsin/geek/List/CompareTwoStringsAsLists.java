package org.mohsin.geek.List;

public class CompareTwoStringsAsLists {

	public static boolean compare(ListNode a,ListNode b){
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		if(a.getData() != b.getData())
			return false;
		return compare(a.getNext(), b.getNext());
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		a.setNext(new ListNode(2));
		a.getNext().setNext(new ListNode(3));
		
		ListNode b = new ListNode(1);
		b.setNext(new ListNode(2));
		b.getNext().setNext(new ListNode(3));
		
		if(compare(a, b))
			System.out.println("YES");
		else
			System.out.println("NO");

	}
	

}
