package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class GetLevelOfANode {

	public static int getLevel(TreeNode root,int data){
		if(root == null) return -1;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int level = 0;
		while(!q.isEmpty()){
			root = q.remove();
			if(root == null){
				if(!q.isEmpty())
					q.add(null);
				++level;
			}
			else{
				if(root.getData() == data)
					return level;
				if(root.getLeft() != null) q.add(root.getLeft());
				if(root.getRight() != null) q.add(root.getRight());
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println("Level = "+getLevel(root, 7));

	}

}
