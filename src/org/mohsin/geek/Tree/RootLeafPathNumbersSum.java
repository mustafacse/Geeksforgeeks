package org.mohsin.geek.Tree;

public class RootLeafPathNumbersSum {

	public static int sum(TreeNode root,int val){
		
		if(root == null)
			return 0;
		val = val*10 + root.getData();
		if(root.isLeaf())
			return val;
		return sum(root.getLeft(),val)+sum(root.getRight(),val);
		
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println(sum(root,0));

	}

}
