package org.mohsin.geek.Tree;

public class DeepestLeftLeafNode {

	private static TreeNode leaf = null;
	private static int max = 0;
	
	public static void deepestLeftLeaf(TreeNode root,int level,boolean isLeft){
		
		if(root == null)
			return;
		if(root.isLeaf() && isLeft){
			if(level > max){
				max = level;
				leaf = root;
			}
		}
		
		deepestLeftLeaf(root.getLeft(), level+1, true);
		deepestLeftLeaf(root.getRight(), level+1, false);
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		root.getLeft().getLeft().setLeft(new TreeNode(8));
		
		deepestLeftLeaf(root, 0, false);
		System.out.println("Deepest left leaf node is "+leaf.getData());

	}

}
