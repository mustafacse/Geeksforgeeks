package org.mohsin.geek.Tree;

public class CheckForSumTree {

	public static boolean check(TreeNode root){
		if(root == null || root.isLeaf() == true)
			return true;
		
		int left = 0;
		int right = 0;
		
		if(root.getLeft() == null)
			left = 0;
		else if(root.getLeft().isLeaf())
			left = root.getLeft().getData();
		else 
			left = 2*root.getLeft().getData();
		
		if(root.getRight() == null)
			right = 0;
		else if(root.getRight().isLeaf())
			right = root.getRight().getData();
		else
			right = root.getRight().getData()*2;
		
		if(root.getData() != left+right)
			return false;
		return check(root.getLeft()) && check(root.getRight());
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(26);
		root.setLeft(new TreeNode(10));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(6));
		//root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(3));
		
		if(check(root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
