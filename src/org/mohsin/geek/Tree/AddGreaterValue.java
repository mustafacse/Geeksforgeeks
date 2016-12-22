package org.mohsin.geek.Tree;

public class AddGreaterValue {

	private static int sum = 0;
	
	public static void addGreater(TreeNode root){
		
		if(root == null)
			return;
		addGreater(root.getRight());
		sum = root.getData()+sum;
		root.setData(sum);
		addGreater(root.getLeft());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(50);
		root.setLeft(new TreeNode(30));
		root.setRight(new TreeNode(70));
		root.getLeft().setLeft(new TreeNode(20));
		root.getLeft().setRight(new TreeNode(40));
		root.getRight().setLeft(new TreeNode(60));
		root.getRight().setRight(new TreeNode(80));
		
		addGreater(root);
		root.inorder(root);
	}

}
