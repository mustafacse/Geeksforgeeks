package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

	public static int maxLevel(TreeNode root){
		
		if(root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		q.add(null);
		
		int res = Integer.MIN_VALUE;
		int sum = 0;
		
		while(!q.isEmpty()){
		
			root = q.remove();
			if(root == null){
				if(!q.isEmpty())
					q.add(null);
				res = Math.max(res, sum);
				sum = 0;
			}else{
				sum += root.getData();
				if(root.getLeft() != null)
					q.add(root.getLeft());
				if(root.getRight() != null)
					q.add(root.getRight());
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		System.out.println(maxLevel(root));

	}

}
