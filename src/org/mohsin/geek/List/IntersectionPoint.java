package org.mohsin.geek.List;

public class IntersectionPoint {

	public static ListNode getIntersection(ListNode head1, ListNode head2) {

		if (head1 == head2)
			return head1;
		if (head1 == null || head2 == null)
			return null;

		int len1 = head1.getLength(head1);
		int len2 = head2.getLength(head2);

		int diff = 0;
		ListNode a = null, b = null;
		if (len1 > len2) {
			a = head1;
			b = head2;
			diff = len1 - len2;
		} else {
			a = head2;
			b = head1;
			diff = len2 - len1;
		}

		int count = 0;
		while (count < diff) {
			a = a.getNext();
			++count;
		}

		while (a != null && b != null) {
			if (a == b)
				return a;
			a = a.getNext();
			b = b.getNext();
		}

		return null;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(9));
		a.getNext().getNext().setNext(new ListNode(15));
		a.getNext().getNext().getNext().setNext(new ListNode(30));

		ListNode b = new ListNode(10);
		b.setNext(a.getNext().getNext().getNext());

		ListNode result = getIntersection(a, b);
		System.out.println(result.getData());

	}

}
