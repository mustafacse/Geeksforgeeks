package org.mohsin.geek.Tree;

public class RemoveNodesFromPathOfLengthLessThanK {

	public static TreeNode remove(TreeNode root,int level,int k){
		
		if(root == null)
			return root;
		
		root.setLeft(remove(root.getLeft(), level+1, k));
		root.setRight(remove(root.getRight(), level+1, k));
		
		if(root.isLeaf() && level < k){
			return null;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setRight(new TreeNode(6));
		root.getLeft().getLeft().setLeft(new TreeNode(7));
		root.getRight().getRight().setLeft(new TreeNode(9));
		
		root.inorder(root);
		
		root = remove(root, 1, 4);
		
		System.out.println(" After removal : ");
		root.inorder(root);
		

	}

}
