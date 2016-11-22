package org.mohsin.geek.List;

import org.mohsin.geek.Tree.TreeNode;

public class DLLQuickSort {

	public static TreeNode partition(TreeNode left,TreeNode right){
		
		int x = right.getData();
		TreeNode i = left.getLeft();
		
		for(TreeNode j = left;j != right;j = j.getRight()){
			
			if(j.getData() <= x){
				i = (i == null) ? left : i.getRight();
				int temp = i.getData();
				i.setData(j.getData());
				j.setData(temp);
			}
		}
		
		i = (i == null) ? left : i.getRight();
		int temp = i.getData();
		i.setData(right.getData());
		right.setData(temp);
		
		return i;
	}
	
	public static void quickSort(TreeNode left,TreeNode right){
		
		if(left != null && left != right && left != right.getRight()){
			
			TreeNode pivot = partition(left, right);
			quickSort(left, pivot.getLeft());
			quickSort(pivot.getRight(), right);
		}
	}
	
	public static TreeNode push(TreeNode root,int data){
		
		TreeNode newNode = new TreeNode(data);
		newNode.setRight(root);
		if(root != null)
		root.setLeft(newNode);
		root = newNode;
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = null;
		int arr[] = {2,1,5,8,3,4};
		for(int i = 0;i < arr.length;++i)
			root = push(root,arr[i]);
		
		TreeNode tail = root;
		while(tail.getRight() != null)
			tail = tail.getRight();
		
		quickSort(root, tail);
		
		TreeNode curr = root;
		while(curr != null){
			System.out.println(curr.getData());
			curr = curr.getRight();
		}

	}

}
