package org.mohsin.geek.Tree;

public class MirrorImage {

	public static void mirror(TreeNode root){
		if(root == null) return;
		
		mirror(root.getLeft());
		mirror(root.getRight());
		
		TreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		root.inorder(root);
		
		mirror(root);
		
		System.out.println("-------------------------");
		root.inorder(root);
	}

}
