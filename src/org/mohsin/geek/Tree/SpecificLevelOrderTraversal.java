package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpecificLevelOrderTraversal {

	private static Stack<TreeNode> s = new Stack<>();
	
	public static void specificTraversal(TreeNode root){
		
		if(root == null)
			return;
		
		
		s.push(root);
		
		if(root.getLeft() != null){
			s.push(root.getRight());
			s.push(root.getLeft());
		}
		
		if(root.getLeft().getLeft() != null)
			specificTraversalUtil(root);
		
		while(!s.empty()){
			System.out.print(s.pop().getData()+" ");
		}
	}
	
	public static void specificTraversalUtil(TreeNode root){
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root.getLeft());
		q.add(root.getRight());
		
		while(!q.isEmpty()){
			TreeNode first = q.remove();
			TreeNode second = q.remove();
			
			s.push(second.getLeft());
			s.push(first.getRight());
			s.push(second).getRight();
			s.push(first.getLeft());
			
			if(first.getLeft().getLeft() != null){
				q.add(first.getRight());
				q.add(second.getLeft());
				q.add(first.getLeft());
				q.add(second.getRight());
			}
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		
		specificTraversal(root);

	}

}
