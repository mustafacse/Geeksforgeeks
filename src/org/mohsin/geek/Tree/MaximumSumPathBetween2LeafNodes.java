package org.mohsin.geek.Tree;

class Res{
	int val;
}

public class MaximumSumPathBetween2LeafNodes {

	public static int sumPath(TreeNode root,Res res){
		
		if(root == null)
			return 0;
		if(root.isLeaf())
			return root.getData();
		
		int ls = sumPath(root.getLeft(), res);
		int rs = sumPath(root.getRight(), res);
		
		if(root.getLeft() != null && root.getRight() != null){
			res.val = Math.max(res.val, ls+rs+root.getData());
			return Math.max(ls, rs)+root.getData();
		}
		else
			return root.getLeft() == null ? rs+root.getData() : ls+root.getData();
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		sumPath(root, res);
		System.out.println(res.val);
	}

}
