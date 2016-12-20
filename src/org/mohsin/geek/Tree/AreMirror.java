package org.mohsin.geek.Tree;

public class AreMirror {

	public static boolean isMirror(TreeNode a,TreeNode b){
		
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		if(a.getData() != b.getData())
			return false;
		return isMirror(a.getLeft(), b.getRight()) && isMirror(a.getRight(), b.getLeft());
	}
	
	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		a.setLeft(new TreeNode(2));
		a.setRight(new TreeNode(3));
		a.getRight().setLeft(new TreeNode(4));
		a.getRight().setRight(new TreeNode(5));
		
		
		TreeNode b = new TreeNode(1);
		b.setLeft(new TreeNode(2));
		b.setRight(new TreeNode(3));
		b.getRight().setLeft(new TreeNode(4));
		b.getRight().setRight(new TreeNode(5));
		
		if(isMirror(a, b))
			System.out.println("yes");
		else
			System.out.println("no");

	}

}
