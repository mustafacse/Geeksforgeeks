package org.geek.mohsin.interviews.N301;

import java.util.HashMap;

import org.mohsin.geek.Tree.TreeNode;

public class R1Q2 {

	public static void topView(TreeNode root){
		
		if(root == null)
			return;
		HashMap<Integer,Integer> hm = new HashMap<>();
		topViewUtil(root,hm,0);
		
		if(!hm.isEmpty())
			System.out.println(hm.entrySet());
	}
	
	public static void topViewUtil(TreeNode root,HashMap<Integer,Integer> hm,int vd){
		
		if(root == null)
			return;
		if(hm.get(vd) == null){
			hm.put(vd, root.getData());
		}
		
		topViewUtil(root.getLeft(), hm, vd-1);
		topViewUtil(root.getRight(), hm, vd+1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(-2));
		root.setRight(new TreeNode(6));
		root.getLeft().setLeft(new TreeNode(8));
		root.getLeft().setRight(new TreeNode(-4));
		root.getRight().setLeft(new TreeNode(7));
		root.getRight().setRight(new TreeNode(5));
		
		topView(root);

	}

}
