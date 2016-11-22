/**
 * 
 */
package org.mohsin.geek.List;

/**
 * @author mohsin
 *
 */
public class AddLists {

	public static ListNode add(ListNode a, ListNode b) {

		if (a == null)
			return b;
		if (b == null)
			return a;

		ListNode head = null;
		ListNode tail = null;
		int carry = 0, sum = 0;
		while (a != null || b != null) {

			sum = ((a != null ? a.getData() : 0) + (b != null ? b.getData() : 0));

			sum += carry;
			carry = sum / 10;
			sum %= 10;

			if (head == null) {
				head = tail = new ListNode(sum);
			} else {
				tail.setNext(new ListNode(sum));
				tail = tail.getNext();
			}

			if (a != null)
				a = a.getNext();
			if (b != null)
				b = b.getNext();

		}
		if (carry > 0)
			tail.setNext(new ListNode(carry));

		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode a = new ListNode(5);
		a.setNext(new ListNode(6));
		a.getNext().setNext(new ListNode(3));

		ListNode b = new ListNode(8);
		b.setNext(new ListNode(4));
		b.getNext().setNext(new ListNode(2));

		ListNode head = add(a, b);

		a.printList(a);
		b.printList(b);
		head.printList(head);

	}

}
