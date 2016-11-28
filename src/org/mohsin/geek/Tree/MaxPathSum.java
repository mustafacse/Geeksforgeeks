/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class MaxPathSum {

	private static int res = 0;
	
	public static int maxSum(TreeNode root){
		
		if(root == null) return 0;
		
		int left = maxSum(root.getLeft());
		int right = maxSum(root.getRight());
		
		int subTree = Math.max(Math.max(left, right)+root.getData(), root.getData());
		int rootMax = Math.max(subTree,left+right+root.getData());
		
		res = Math.max(res, rootMax);
		return subTree;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		maxSum(root);
		System.out.println(res);

	}

}
