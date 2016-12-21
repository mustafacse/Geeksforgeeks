package org.mohsin.geek.Tree;

public class FlipTree {

	public static TreeNode flip(TreeNode root){
		
		if(root == null || root.isLeaf())
			return root;
		
		TreeNode flipped = flip(root.getLeft());
		
		root.getLeft().setLeft(root.getRight());
		root.getLeft().setRight(root);
		root.setLeft(null);
		root.setRight(null);
		
		return flipped;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		TreeNode flipped = flip(root);
		flipped.levelOrder(flipped);
	}

}
