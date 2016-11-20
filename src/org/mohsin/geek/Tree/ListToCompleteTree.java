/**
 * 
 */
package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

import org.mohsin.geek.List.ListNode;

/**
 * @author mohsin
 *
 */
public class ListToCompleteTree {

	public static TreeNode build(ListNode head){
		
		if(head == null)
			return null;
		
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(head.getData());
		q.add(root);
		head = head.getNext();
		while(head != null){
			
			TreeNode parent = q.remove();
			TreeNode left = new TreeNode(head.getData());
			parent.setLeft(left);
			head = head.getNext();
			if(head != null){
				TreeNode right = new TreeNode(head.getData());
				parent.setRight(right);
				head = head.getNext();
			}
			q.add(parent.getLeft());
			q.add(parent.getRight());
		}
		
		return root;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		TreeNode root = build(head);
		root.levelOrder(root);

	}

}
