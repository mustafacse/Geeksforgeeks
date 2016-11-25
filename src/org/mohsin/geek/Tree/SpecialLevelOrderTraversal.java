package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SpecialLevelOrderTraversal {

	public static void specialTraversal(TreeNode root){
		if(root == null)
			return;
		
		System.out.print(root.getData()+" ");
		if(root.getLeft() == null)
			return;
		System.out.print(root.getLeft().getData()+" "+root.getRight().getData()+" ");
		if(root.getLeft().getLeft() == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root.getLeft());
		q.add(root.getRight());
		
		while(!q.isEmpty()){
			
			TreeNode left = q.remove();
			TreeNode right = q.remove();
			
			System.out.print(left.getLeft().getData()+" "+right.getRight().getData()+" ");
			System.out.print(left.getRight().getData()+" "+right.getLeft().getData()+" ");
			
			if(left.getLeft().getLeft() != null){
				q.add(left.getLeft());
				q.add(right.getRight());
				q.add(left.getRight());
				q.add(right.getLeft());
			}
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		specialTraversal(root);

	}

}
