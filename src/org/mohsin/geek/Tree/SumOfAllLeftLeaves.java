package org.mohsin.geek.Tree;

public class SumOfAllLeftLeaves {

	public static int getSum(TreeNode root,boolean isLeft){
		
		if(root == null)
			return 0;
		
		if(root.isLeaf() && isLeft)
			return root.getData();
		
		return getSum(root.getLeft(),true) + getSum(root.getRight(), false);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println(getSum(root, false));

	}

}
