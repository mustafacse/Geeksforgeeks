package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST2MinHeap {

	private static TreeNode head = null;
	
	public static void BST2Dll(TreeNode root){
		
		if(root == null)
			return;
		BST2Dll(root.getRight());
		
		root.setRight(head);
		
		if(head != null)
			head.setLeft(null);
		
		head = root;
		
		BST2Dll(root.getLeft());
	}
	
	public static TreeNode minHeap(TreeNode root){
		
		if(head == null)
			return root;
		
		root = head;
		
		head = head.getRight();
		root.setRight(null);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(head != null){
			
			TreeNode left = head;
			head = head.getRight();
			left.setRight(null);
			
			TreeNode parent = q.remove();
			parent.setLeft(left);
			q.add(left);
			if(head != null){
				TreeNode right = head;
				head = head.getRight();
				right.setRight(null);
				
				parent.setRight(right);
				q.add(right);
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(5));
		root.setRight(new TreeNode(50));
		root.getLeft().setLeft(new TreeNode(1));
		root.getRight().setLeft(new TreeNode(40));
		root.getRight().setRight(new TreeNode(100));
		
		root.levelOrder(root);
		BST2Dll(root);
		
		root = null;
		root = minHeap(root);
		
		root.levelOrder(root);

	}

}
