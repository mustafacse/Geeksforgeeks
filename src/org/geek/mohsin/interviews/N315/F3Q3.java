/**
 * 
 */
package org.geek.mohsin.interviews.N315;

import org.mohsin.geek.List.ListNode;

/**
 * @author mohsin
 *
 */
public class F3Q3 {

	public static boolean isMerge(ListNode a,ListNode b){
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		
		int len1 = a.getLength(a);
		int len2 = b.getLength(b);
		
		int diff = 0;
		if(len1 > len2){
			diff = len1-len2;
		}else{
			diff = len2 - len1;
			ListNode temp = a;
			a = b;
			b = temp;
		}
		
		int count = 0;
		while(count < diff){
			a = a.getNext();
			++count;
		}
		
		while(a != null && b != null){
			if(a == b)
				return true;
			a = a.getNext();
			b = b.getNext();
		}
		
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		a.setNext(new ListNode(2));
		a.getNext().setNext(new ListNode(3));
		
		ListNode b = new ListNode(4);
		b.setNext(a.getNext());
		
		if(isMerge(a, b))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
