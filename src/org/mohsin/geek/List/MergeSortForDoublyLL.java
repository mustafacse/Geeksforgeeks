package org.mohsin.geek.List;

import org.mohsin.geek.Tree.TreeNode;

public class MergeSortForDoublyLL {

	public static TreeNode split(TreeNode head){
		
		if(head == null || head.getRight() == null)
			return head;
		
		
		TreeNode slow = head,fast = head;
		while(fast.getRight() != null && fast.getRight().getRight() != null){
			slow = slow.getRight();
			fast = fast.getRight().getRight();
		}
		
		TreeNode temp = slow.getRight();
		slow.setRight(null);
		return temp;
	}
	
	public static TreeNode merge(TreeNode a,TreeNode b){
		
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		if(a.getData() < b.getData()){
			a.setRight(merge(a.getRight(),b));
			a.getRight().setLeft(a);
			a.setLeft(null);
			return a;
		}
		else{
			b.setRight(merge(a,b.getRight()));
			b.getRight().setLeft(b);
			b.setLeft(null);
			return b;
		}
	}
	
	public static TreeNode mergeSort(TreeNode head){
		if(head == null || head.getRight() == null)
			return head;
		
		TreeNode second = split(head);
		head = mergeSort(head);
		second = mergeSort(second);
		
		return merge(head,second);
	}
	
	public static TreeNode push(TreeNode head,int data){
		
		TreeNode newNode = new TreeNode(data);
		newNode.setRight(head);
		if(head != null)
			head.setLeft(newNode);
		head = newNode;
		return head;
	}
	
	public static void print(TreeNode head){
		while(head != null){
			System.out.print(head.getData()+" ");
			head = head.getRight();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int arr[] = {5,4,1,3,8,5,2};
		
		TreeNode head = null;
		for(int i = 0;i < arr.length;++i)
			head = push(head,arr[i]);
		
		print(head);
		
		head = mergeSort(head);
		print(head);
	}

}
