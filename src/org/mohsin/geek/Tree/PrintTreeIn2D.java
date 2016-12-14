package org.mohsin.geek.Tree;

public class PrintTreeIn2D {

	public static void print(TreeNode root,int space){
		if(root == null)
			return;
		
		space += 10;
		
		print(root.getRight(),space);
		
		System.out.println();
		
		for(int i = 0;i < space;++i)
			System.out.print(" ");
		
		System.out.println(root.getData());
		
		print(root.getLeft(),space);
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		print(root, 0);

	}

}
