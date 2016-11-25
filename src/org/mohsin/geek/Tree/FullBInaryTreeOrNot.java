package org.mohsin.geek.Tree;

public class FullBInaryTreeOrNot {

	
	public static boolean isFull(TreeNode root){
		if(root == null)
			return true;
		if(root.isLeaf())
			return true;
		
		if(root.getLeft() != null && root.getRight() != null)
		{
			return isFull(root.getLeft()) && isFull(root.getRight());
		}
		
		return false;
			
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		if(isFull(root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
