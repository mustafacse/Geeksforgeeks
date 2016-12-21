package org.mohsin.geek.Tree;

import java.util.HashMap;

public class PairOfRootSum {

	private static HashMap<Integer, Integer> hm = new HashMap<>();

	public static boolean isPath(TreeNode root) {

		if (root == null)
			return false;
		return isPathUtil(root.getLeft(), root.getData()) || isPathUtil(root.getRight(), root.getData());
	}

	public static boolean isPathUtil(TreeNode root, int sum) {

		if (root == null)
			return false;
		int rem = sum - root.getData();
		if (hm.get(rem) != null)
			return true;
		hm.put(root.getData(), 1);
		boolean res = isPathUtil(root.getLeft(), sum) || isPathUtil(root.getRight(), sum);
		hm.remove(root.getData());
		return res;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));

		if (isPath(root))
			System.out.println("yes");
		else
			System.out.println("no");

	}

}
