package org.mohsin.geek.Tree;

public class DensityOfTree {

	private static int size = 0;

	public static int height(TreeNode root) {

		if (root == null)
			return 0;

		int left = height(root.getLeft());
		int right = height(root.getRight());

		++size;

		return left > right ? left + 1 : right + 1;
	}

	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		int ht = height(root);
		System.out.println((float)size/ht);

	}

}
