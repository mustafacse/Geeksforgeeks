/**
 * 
 */
package org.mohsin.geek.List;

import org.mohsin.geek.Tree.TreeNode;

/**
 * @author mohsin
 *
 */
public class ListToBalancedBST {

	private static ListNode head;
	
	public static TreeNode build(int n){
		if(n <= 0)
			return null;
		
		TreeNode left = build(n/2);
		
		TreeNode root = new TreeNode(head.getData());
		root.setLeft(left);
		head = head.getNext();
		
		root.setRight( build(n-n/2-1));
		
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		head = new ListNode(1);
		head.setNext(new ListNode(2));
		head.getNext().setNext(new ListNode(3));
		head.getNext().getNext().setNext(new ListNode(4));
		head.getNext().getNext().getNext().setNext(new ListNode(5));
		
		TreeNode root = build(head.getLength(head));
		root.inorder(root);
		root.levelOrder(root);
	}

}
