package org.mohsin.geek.Tree;

public class MaxDiffBetweenNodeAndAncestor {

	private static int diff = Integer.MIN_VALUE;
	
	public static int maxDiff(TreeNode root){
		if(root == null)
			return Integer.MAX_VALUE;
		
		if(root.isLeaf())
			return root.getData();
		
		int val = Math.min(maxDiff(root.getLeft()), maxDiff(root.getRight()));
		
		diff = Math.max(diff, root.getData()-val);
		return Math.min(val, root.getData());
	}
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		maxDiff(root);
		System.out.println(diff);

	}

}
