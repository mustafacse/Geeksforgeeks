package org.mohsin.geek.Tree;

public class CoveredAndUncoveredNodes {

	public static int unCoverLeft(TreeNode root){
		if(root == null)
			return 0;
		if(root.getLeft() != null)
			return root.getData()+unCoverLeft(root.getLeft());
		else
			return root.getData()+unCoverLeft(root.getRight());
	}
	
	public static int unCoverRight(TreeNode root){
		if(root == null)
			return 0;
		if(root.getRight() != null)
			return root.getData()+unCoverRight(root.getRight());
		else
			return root.getData()+unCoverRight(root.getLeft());
	}
	
	public static int getSum(TreeNode root){
		if(root == null)
			return 0;
		return root.getData()+getSum(root.getLeft())+getSum(root.getRight());
	}
	
	public static boolean isSame(TreeNode root){
		
		if(root == null)
			return true;
		int sum = getSum(root);
		int left = unCoverLeft(root.getLeft());
		int right = unCoverRight(root.getRight());
		
		return sum-(root.getData()+left+right) == root.getData()+left+right;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		root.setLeft(new TreeNode(3));
		root.setRight(new TreeNode(10));
		root.getLeft().setRight(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(6));
		root.getRight().setRight(new TreeNode(14));
		root.getRight().getRight().setLeft(new TreeNode(13));
		root.getLeft().getRight().setLeft(new TreeNode(4));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		if(isSame(root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
