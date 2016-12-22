package org.mohsin.geek.Tree;

public class RemoveBSTKeysInRange {

	public static TreeNode removeNodes(TreeNode root,int k1,int k2){
		
		if(root == null)
			return null;
		
		root.setLeft(removeNodes(root.getLeft(), k1, k2));
		root.setRight(removeNodes(root.getRight(), k1, k2));
		
		if(root.getData() < k1){
			return root.getRight();
		}
		
		if(root.getData() > k2)
			return root.getLeft();
		
		return root;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(6);
		root.setLeft(new TreeNode(-13));
		root.setRight(new TreeNode(14));
		root.getLeft().setRight(new TreeNode(-8));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(15));
		
		root = removeNodes(root, -10, 13);
		
		root.inorder(root);

	}

}
