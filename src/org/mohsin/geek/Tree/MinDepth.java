package org.mohsin.geek.Tree;

public class MinDepth {

	public static int minDepth(TreeNode root){
		if(root == null)
			return 0;
		if(root.isLeaf())
			return 1;
		if(root.getLeft() == null)
			return minDepth(root.getRight())+1;
		if(root.getRight() == null)
			return minDepth(root.getLeft())+1;
		return Math.min(minDepth(root.getLeft()),minDepth(root.getRight()));
	}
	
	public static void main(String[] args) {
		
		

	}

}
