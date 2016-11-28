package org.mohsin.geek.Tree;

public class RemoveHalfNodes {

	public static TreeNode removeHalfNodes(TreeNode root){
		
		if(root == null)
			return root;
		
		root.setLeft(removeHalfNodes(root.getLeft()));
		root.setRight(removeHalfNodes(root.getRight()));
		
		if(root.isLeaf())
			return root;
		
		if(root.getLeft() == null)
			return root.getRight();
		
		else if(root.getRight() == null)
			return root.getLeft();
		
		return root;
		
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		root.setLeft(new TreeNode(7));
		root.setRight(new TreeNode(5));
		root.getLeft().setRight(new TreeNode(6));
		root.getRight().setRight(new TreeNode(9));
		root.getLeft().getRight().setLeft(new TreeNode(1));
		root.getLeft().getRight().setRight(new TreeNode(11));
		root.getRight().getRight().setLeft(new TreeNode(4));
		
		root.inorder(root);
		System.out.println("After removal of half nodes : ");
		root = removeHalfNodes(root);
		root.inorder(root);

	}

}
