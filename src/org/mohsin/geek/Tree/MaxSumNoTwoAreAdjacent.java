package org.mohsin.geek.Tree;

import java.util.HashMap;

public class MaxSumNoTwoAreAdjacent {

	public static int getSum(TreeNode root){
		
		if(root == null)
			return 0;
		
		HashMap<TreeNode,Integer> hm = new HashMap<>();
		return getSumUtil(root,hm);
	}
	
	public static int getSumUtil(TreeNode root,HashMap<TreeNode,Integer> hm){
		
		if(root == null) return 0;
		
		if(hm.get(root) != null)
			return hm.get(root);
		
		int incl = root.getData()+grandChildrenSum(root,hm);
		int excl = getSumUtil(root.getLeft(), hm)+getSumUtil(root.getRight(), hm);
		
		hm.put(root, Math.max(incl, excl));
		return hm.get(root);
	}
	
	public static int grandChildrenSum(TreeNode root,HashMap<TreeNode,Integer> hm){
		
		int sum = 0;
		
		if(root.getLeft() != null){
			sum += getSumUtil(root.getLeft().getLeft(), hm)+getSumUtil(root.getLeft().getRight(), hm);
		}
		
		if(root.getRight() != null){
			sum += getSumUtil(root.getRight().getLeft(), hm)+getSumUtil(root.getRight().getRight(), hm);
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		System.out.println(getSum(root));
	}

}
