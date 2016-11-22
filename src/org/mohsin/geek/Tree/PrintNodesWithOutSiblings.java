package org.mohsin.geek.Tree;

public class PrintNodesWithOutSiblings {

	public static void print(TreeNode root){
		if(root == null)
			return;
		
		if(root.getLeft() != null && root.getRight() != null){
			print(root.getLeft());
			print(root.getRight());
		}
		
		else if(root.getRight() != null){
			System.out.println(root.getRight().getData());
			print(root.getRight());
		}
		
		else if(root.getLeft() != null)
		{
			System.out.println(root.getLeft().getData());
			print(root.getLeft());
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		//root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		print(root);
	}

}
