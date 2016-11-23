package org.mohsin.geek.Tree;

public class RightView {

	private static int max = Integer.MIN_VALUE;
	
	public static void printRight(TreeNode root,int level){
		
		if(root == null) return;
		
		if(level > max){
			System.out.println(root.getData());
			max = level;
		}
		
		printRight(root.getRight(), level+1);
		printRight(root.getLeft(), level+1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		printRight(root, 0);
	}

}
