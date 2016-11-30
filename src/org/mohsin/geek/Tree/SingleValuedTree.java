package org.mohsin.geek.Tree;

public class SingleValuedTree {

	private static int count = 0;
	
	public static boolean SVS(TreeNode root){
		
		if(root == null)
			return true;
		
		boolean left = SVS(root.getLeft());
		boolean right = SVS(root.getRight());
		
		if(!left || !right)
			return false;
		
		if(root.getLeft() != null && root.getData() != root.getLeft().getData())
			return false;
		if(root.getRight() != null && root.getData() != root.getRight().getData())
			return false;
		
		++count;
		return true;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(1));
		root.setRight(new TreeNode(5));
		root.getLeft().setLeft(new TreeNode(5));
		root.getLeft().setRight(new TreeNode(5));
		//root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(5));
		
		SVS(root);
		System.out.println(count);
		

	}

}
