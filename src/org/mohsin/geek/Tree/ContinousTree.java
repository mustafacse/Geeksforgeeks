package org.mohsin.geek.Tree;

public class ContinousTree {

	public static boolean isContinous(TreeNode root, int prevVal) {

		if (root == null)
			return true;
		if (Math.abs(root.getData() - prevVal) != 1)
			return false;
		return isContinous(root.getLeft(), root.getData()) && isContinous(root.getRight(), root.getData());
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(4));
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(3));
		//root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(5));

		if(isContinous(root, root.getData()-1))
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
