package org.mohsin.geek.Tree;

public class SymmetricTree {

	public static boolean isMirror(TreeNode a,TreeNode b){
		
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		if(a.getData() != b.getData())
			return false;
		return isMirror(a.getLeft(),b.getRight()) && isMirror(a.getRight(),b.getLeft());
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(2));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(5));
		root.getRight().setRight(new TreeNode(4));
		
		if(isMirror(root, root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
