package org.mohsin.geek.Tree;

public class IsBst {

	private static TreeNode prev = null;
	
	public static boolean isBst(TreeNode root)
	{
		if(root == null) return true;
		
		if(isBst(root.getLeft()) == false)
			return false;
		
		if(prev != null && prev.getData() > root.getData())
			return false;
		
		prev = root;
		return isBst(root.getRight());
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		if(isBst(root))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
