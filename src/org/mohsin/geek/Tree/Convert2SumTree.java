package org.mohsin.geek.Tree;

public class Convert2SumTree {

	public static int convert(TreeNode root){
		if(root == null) return 0;
		
		int oldVal = root.getData();
		root.setData(convert(root.getLeft())+convert(root.getRight()));
		return oldVal+root.getData();
		
	}
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(-2));
		root.setRight(new TreeNode(6));
		root.getLeft().setLeft(new TreeNode(8));
		root.getLeft().setRight(new TreeNode(-4));
		root.getRight().setLeft(new TreeNode(7));
		root.getRight().setRight(new TreeNode(5));
		
		convert(root);
		root.inorder(root);

	}

}
