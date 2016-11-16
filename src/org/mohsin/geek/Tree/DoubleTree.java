package org.mohsin.geek.Tree;

public class DoubleTree {

	public static void doubleTree(TreeNode root){
		if(root == null) return;
		
		doubleTree(root.getLeft());
		doubleTree(root.getRight());
		
		TreeNode left = root.getLeft();
		root.setLeft(new TreeNode(root.getData()));
		root.getLeft().setLeft(left);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		root.setLeft(new TreeNode(1));
		root.setRight(new TreeNode(3));

		doubleTree(root);
		
		root.inorder(root);
	}

}
