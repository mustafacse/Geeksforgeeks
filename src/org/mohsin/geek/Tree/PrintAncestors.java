package org.mohsin.geek.Tree;

public class PrintAncestors {

	public static boolean print(TreeNode root,int data){
		if(root == null) return false;
		
		if(root.getData() == data) return true;
		
		if(print(root.getLeft(),data) || print(root.getRight(),data)){
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		print(root,3);

	}

}
