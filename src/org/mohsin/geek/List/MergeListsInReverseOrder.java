package org.mohsin.geek.List;

public class MergeListsInReverseOrder {

	static ListNode res = new ListNode();
	
	public static ListNode merge(ListNode a,ListNode b){
		
		if(a == null) return b;
		if(b == null) return a;
		
		ListNode res = null;
		while(a != null && b != null){
			if(a.getData() <= b.getData()){
				ListNode temp = a.getNext();
				a.setNext(res);
				res = a;
				a = temp;
			}else{
				ListNode temp = b.getNext();
				b.setNext(res);
				res = b;
				b = temp;
			}
		}
		
		while(a != null){
			ListNode temp = a.getNext();
			a.setNext(res);
			res = a;
			a = temp;
		}
		
		while(b != null){
			ListNode temp = b.getNext();
			b.setNext(res);
			res = b;
			b = temp;
		}
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		a.setNext(new ListNode(2));
		a.getNext().setNext(new ListNode(5));
		
		ListNode b = new ListNode(3);
		b.setNext(new ListNode(6));
		
		 res = merge(a, b);
		res.printList(res);
	}

}
