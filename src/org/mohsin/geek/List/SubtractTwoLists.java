package org.mohsin.geek.List;

public class SubtractTwoLists {

	private static boolean borrow = false;
	
	public static ListNode addZeroes(ListNode head,int diff){
		
		ListNode temp = new ListNode(0);
		ListNode tail = temp;
		--diff;
		while(diff-- > 0){
			tail.setNext(new ListNode(0));
			tail = tail.getNext();
		}
		tail.setNext(head);
		
		return temp;
	}
	
	public static ListNode subtractHelper(ListNode a,ListNode b){
		
		if(a == null && b == null && !borrow)
			return null;
		
		ListNode prev = subtractHelper(a != null ? a.getNext() : null, b != null ? b.getNext() : null);
		
		int d1 = a.getData();
		int d2 = b.getData();
		
		if(borrow){
			--d1;
			borrow = false;
		}
		
		if(d1 < d2){
			d1 += 10;
			borrow = true;
		}
		
		int sub = d1-d2;
		ListNode curr = new ListNode(sub);
		curr.setNext(prev);
		return curr;
	}
	
	
	public static ListNode subtract(ListNode a,ListNode b){
		
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		int len1 = a.getLength(a);
		int len2 = b.getLength(b);
		
		ListNode temp1 = a;
		ListNode temp2 = b;
		
		ListNode lNode = a,sNode = b;
		if(len1 != len2){
			
			lNode = len1 > len2 ? a : b;
			sNode = len1 < len2 ? a : b;
			
			int diff = Math.abs(len1-len2);
			sNode = addZeroes(sNode, diff);
		}else{
			
			while(a.getData() != b.getData()){
				lNode = a.getData() > b.getData() ? temp1 : temp2;
				sNode = a.getData() < b.getData() ? temp1 : temp2;
				
				a = a.getNext();
				b = b.getNext();
			}
		}
		
		return subtractHelper(lNode, sNode);
	}
	
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		a.setNext(new ListNode(0));
		a.getNext().setNext(new ListNode(0));
		
		ListNode b = new ListNode(1);
		
		ListNode res = subtract(a, b);
		res.printList(res);
	}

}
