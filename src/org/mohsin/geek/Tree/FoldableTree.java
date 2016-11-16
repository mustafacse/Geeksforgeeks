package org.mohsin.geek.Tree;

public class FoldableTree {

	public static boolean isFoldable(TreeNode root){
		if(root == null) return true;
		
		return isFoldableUtil(root.getLeft(),root.getRight());
	}
	
	public static boolean isFoldableUtil(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		return isFoldableUtil(a.getLeft(), b.getRight()) && isFoldableUtil(a.getRight(), b.getLeft());
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		root.setLeft(new TreeNode(1));
		root.setRight(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		
		if(isFoldable(root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
