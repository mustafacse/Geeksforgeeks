package org.mohsin.geek.List;

public class MergeKLists {

	public static ListNode merge(ListNode a,ListNode b){
		
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		ListNode res = new ListNode();
		if(a.getData() <= b.getData()){
			res = a;
			res.setNext(merge(a.getNext(), b));
		}else{
			res = b;
			res.setNext(merge(a, b.getNext()));
		}
		
		return res;
	}
	
	public static ListNode kMerge(ListNode arr[]){
		
		int i = 0;
		int j = 0,last = arr.length-1;
		while(last != 0){
			
			i = 0;
			j = last;
			
			while(i < j){
				arr[i] = merge(arr[i], arr[j]);
				++i;
				--j;
				if(i >= j)
					last = j;
			}
		}
		
		return arr[0];
	}
	
	public static void main(String[] args) {
		
		ListNode arr[] = new ListNode[3];
		
		arr[0] = new ListNode(1);
		arr[0].setNext(new ListNode(3));
		arr[0].getNext().setNext(new ListNode(5));
		arr[0].getNext().getNext().setNext(new ListNode(7));
		
		arr[1] = new ListNode(2);
		arr[1].setNext(new ListNode(4));
		arr[1].getNext().setNext(new ListNode(6));
		arr[1].getNext().getNext().setNext(new ListNode(8));
		
		arr[2] = new ListNode(0);
		arr[2].setNext(new ListNode(9));
		arr[2].getNext().setNext(new ListNode(10));
		arr[2].getNext().getNext().setNext(new ListNode(11));
		
		ListNode res = kMerge(arr);
		res.printList(res);

	}

}
