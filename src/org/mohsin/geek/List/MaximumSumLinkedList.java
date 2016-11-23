package org.mohsin.geek.List;

public class MaximumSumLinkedList {

	public static ListNode maxSumList(ListNode a, ListNode b) {

		if (a == null)
			return b;
		if (b == null)
			return a;

		ListNode prev1 = a, prev2 = b;
		ListNode curr1 = a, curr2 = b;
		ListNode result = null;

		while (curr1 != null || curr2 != null) {

			int sum1 = 0, sum2 = 0;
			while (curr1 != null && curr2 != null && curr1.getData() != curr2.getData()) {
				if (curr1.getData() < curr2.getData()) {
					sum1 += curr1.getData();
					curr1 = curr1.getNext();
				} else {
					sum2 += curr2.getData();
					curr2 = curr2.getNext();
				}
			}

			if (curr1 == null) {
				while (curr2 != null) {
					sum2 += curr2.getData();
					curr2 = curr2.getNext();
				}
			}

			if (curr2 == null) {
				while (curr1 != null) {
					sum1 += curr1.getData();
					curr1 = curr1.getNext();
				}
			}

			if (prev1 == a && prev2 == b)
				result = sum1 > sum2 ? prev1 : prev2;
			else {

				if (sum1 > sum2)
					prev2.setNext(prev1.getNext());
				else
					prev1.setNext(prev2.getNext());
			}

			prev1 = curr1;
			prev2 = curr2;

			if (curr1 != null)
				curr1 = curr1.getNext();
			if (curr2 != null)
				curr2 = curr2.getNext();
		}

		return result;

	}

	public static ListNode push(ListNode head, int data) {

		ListNode temp = new ListNode(data);
		temp.setNext(head);
		head = temp;
		return head;
	}

	public static void main(String[] args) {

		int arr1[] = { 511, 240, 120, 90, 30, 3, 1 };
		int arr2[] = { 249, 240, 125, 90, 32, 12, 3, 0 };

		ListNode head1 = null;
		ListNode head2 = null;

		for (int i = 0; i < arr1.length; ++i)
			head1 = push(head1, arr1[i]);

		for (int i = 0; i < arr2.length; ++i)
			head2 = push(head2, arr2[i]);
		
		head2.printList(head2);
		head1.printList(head1);
		
		System.out.println("Max sum List : ");
		ListNode result = maxSumList(head1, head2);
		result.printList(result);

	}

}
