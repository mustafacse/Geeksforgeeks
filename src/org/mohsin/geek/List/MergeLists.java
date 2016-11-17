package org.mohsin.geek.List;

public class MergeLists {

	public static ListNode  merge(ListNode a,ListNode b){
		
		if(a == null) return b;
		if(b == null) return a;
		
		ListNode res = null;
		
		if(a.getData() < b.getData()){
			res = a;
			res.setNext(merge(a.getNext(),b));
		}else{
			res = b;
			res.setNext(merge(a,b.getNext()));
		}
		return res;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(9));
		a.getNext().getNext().setNext(new ListNode(15));
		a.getNext().getNext().getNext().setNext(new ListNode(30));

		ListNode b = new ListNode(3);
		b.setNext(new ListNode(6));
		b.getNext().setNext(new ListNode(9));
		b.getNext().getNext().setNext(new ListNode(15));
		b.getNext().getNext().getNext().setNext(new ListNode(30));

		
		a.printList(a);
		b.printList(b);
		
		System.out.println("After Merging : ");
		ListNode res = merge(a, b);
		
		res.printList(res);
	}

}
