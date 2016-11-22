package org.mohsin.geek.Tree;

public class LCAInBinaryTree {

	private static boolean v1 = false;
	private static boolean v2 = false;
	
	public static TreeNode lca(TreeNode root, int n1, int n2) {

		if (root == null)
			return null;

		TreeNode lca = lcaUtil(root, n1, n2);

		if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1))
			return lca;

		return null;
	}

	public static boolean find(TreeNode root, int data) {

		if (root == null)
			return false;

		if (root.getData() == data)
			return true;

		return find(root.getLeft(), data) || find(root.getRight(), data);
	}

	public static TreeNode lcaUtil(TreeNode root,int n1,int n2){
		
		if(root == null)
			return null;
		
		if(root.getData() == n1){
			v1 = true;
			return root;
		}
		
		if(root.getData() == n2){
			v2 = true;
			return root;
		}
		
		TreeNode left = lcaUtil(root.getLeft(),n1,n2);
		TreeNode right = lcaUtil(root.getRight(),n1,n2);
		
		if(left != null && right != null)
			return root;
		else if(left != null)
			return left;
		else
			return right;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println(lca(root,4,3).getData());

	}

}
