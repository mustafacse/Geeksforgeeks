package org.mohsin.geek.Tree;

import java.util.HashMap;

public class VerticalSum {

	public static void verticalSum(TreeNode root){
		if(root == null)
			return;
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		verticalSumUtil(root,hm,0);
		
		if(hm.isEmpty() == false)
			System.out.println(hm.entrySet());
	}
	
	public static void verticalSumUtil(TreeNode root, HashMap<Integer,Integer> hm,int level){
		if(root == null) return;
		
		if(hm.get(level) == null)
			hm.put(level, root.getData());
		else{
			int prev = hm.get(level);
			hm.put(level, prev+root.getData());
		}
		verticalSumUtil(root.getLeft(), hm, level-1);
		verticalSumUtil(root.getRight(), hm, level+1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		verticalSum(root);

	}

}
