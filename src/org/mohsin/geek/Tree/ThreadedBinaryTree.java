package org.mohsin.geek.Tree;

public class ThreadedBinaryTree {

	private static TreeNode prev = null;
	
	public static void threading(TreeNode root){
		
		if(root == null)
			return;
		threading(root.getRight());
		if(root.getRight() == null)
			root.setRight(prev);
		prev = root;
		threading(root.getLeft());
	}
	
	public static TreeNode leftMost(TreeNode root){
		TreeNode curr = root;
		while(curr.getLeft() != null){
			curr = curr.getLeft();
		}
		return curr;
	}
	
	/*public static void inorder(TreeNode root){
		
		if(root == null)
			return;
		
		TreeNode curr = leftMost(root);
		while(curr != null){
			System.out.println(curr.getData());
			if(curr.isThreaded == true)
				curr = curr.getRight();
			else
				curr = leftMost(curr.getRight());
		}
	}*/
	public static void main(String[] args) {
		
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		threading(root);
		
		System.out.println(root.getLeft().getRight().getRight().getData());
	}

}
