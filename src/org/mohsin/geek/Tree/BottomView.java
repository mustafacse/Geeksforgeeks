package org.mohsin.geek.Tree;

import java.util.HashMap;

public class BottomView {

	private static HashMap<Integer,Integer> hm = new HashMap<>();
	
	public static void bottomPrint(TreeNode root,int vd){
		
		if(root == null)
			return;
		hm.put(vd, root.getData());
		bottomPrint(root.getLeft(), vd-1);
		bottomPrint(root.getRight(), vd+1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		bottomPrint(root, 0);
		System.out.println(hm.entrySet());
	}

}
