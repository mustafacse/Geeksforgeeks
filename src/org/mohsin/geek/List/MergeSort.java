package org.mohsin.geek.List;

public class MergeSort {

	public static ListNode mergeSort(ListNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}

		ListNode a = new ListNode();
		ListNode b = new ListNode();

		frontBackSplit(head, a, b);
		
		a = mergeSort(a);
		b = mergeSort(b);

		head = merge(a, b);
		return head;
	}

	public static void frontBackSplit(ListNode head, ListNode a, ListNode b) {
		if (head == null || head.getNext() == null) {
			a = head;
			b = null;
		} else {
			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.getNext() != null) {
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}

			a = head;
			b = slow.getNext();
			slow.setNext(null);
		}
	}

	public static ListNode merge(ListNode a, ListNode b) {

		if (a == null)
			return b;
		if (b == null)
			return a;

		ListNode res = null;

		if (a.getData() < b.getData()) {
			res = a;
			res.setNext(merge(a.getNext(), b));
		} else {
			res = b;
			res.setNext(merge(a, b.getNext()));
		}
		return res;
	}

}
