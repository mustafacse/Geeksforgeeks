package org.mohsin.geek.Tree;

public class CountInRange {

	public static int countNodes(TreeNode root,int k1,int k2){
		
		if(root == null)
			return 0;
		if(root.getData() >= k1 && root.getData() <= k2)
			return 1+countNodes(root.getLeft(), k1, k2)+countNodes(root.getRight(), k1, k2);
		if(root.getData() > k1)
			return countNodes(root.getLeft(), k1, k2);
		else
			return countNodes(root.getRight(), k1, k2);
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(5));
		root.setRight(new TreeNode(50));
		root.getLeft().setLeft(new TreeNode(1));
		root.getRight().setLeft(new TreeNode(40));
		root.getRight().setRight(new TreeNode(100));
		
		int k1 = 5;
		int k2 = 45;
		
		System.out.println(countNodes(root, k1, k2));

	}

}
