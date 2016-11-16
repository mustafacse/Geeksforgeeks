package org.mohsin.geek.Tree;

class Height{
	int h;
}

public class Diameter {

	public static int diameter(TreeNode root,Height h){
		if(root == null){
			h.h = 0;
			return 0;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		int lDiameter = diameter(root.getLeft(),lh);
		int rDiameter = diameter(root.getRight(), rh);
		
		h.h = Math.max(lh.h, rh.h)+1;
		return Math.max(lh.h+rh.h+1,Math.max(lDiameter, rDiameter));
		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println(diameter(root,new Height()));
	}

}
