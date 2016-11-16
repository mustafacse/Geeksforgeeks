package org.mohsin.geek.Tree;

public class Root2LeafPathSum {

	public static boolean hasSum(TreeNode root,int sum){
		if(root == null){
			return (sum == 0);
		}
		
		sum = sum-root.getData();
		if(sum == 0 && root.isLeaf())
			return true;
		return hasSum(root.getLeft(), sum) || hasSum(root.getRight(), sum);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		if(hasSum(root,50))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
