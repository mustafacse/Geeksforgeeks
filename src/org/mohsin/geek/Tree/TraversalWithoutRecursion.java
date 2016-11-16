package org.mohsin.geek.Tree;

import java.util.Stack;

public class TraversalWithoutRecursion {

	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				s.push(root);
				root = root.getLeft();
			}

			if (s.empty())
				break;
			root = s.pop();
			System.out.print(root.getData() + " ");
			root = root.getRight();
		}

		System.out.println("********************");
	}

	public static void morrisInorder(TreeNode root) {
		if (root == null)
			return;

		TreeNode curr = root;
		while (curr != null) {
			if (curr.getLeft() == null) {
				System.out.print(curr.getData() + " ");
				curr = curr.getRight();
			} else {
				TreeNode prev = curr.getLeft();
				while (prev.getRight() != null && prev.getRight() != curr)
					prev = prev.getRight();

				if (prev.getRight() == null) {
					prev.setRight(curr);
					curr = curr.getLeft();
				} else {
					prev.setRight(null);
					System.out.print(curr.getData() + " ");
					curr = curr.getRight();
				}
			}
		}
		System.out.println("********************");
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		inorder(root);
		morrisInorder(root);

	}

}
