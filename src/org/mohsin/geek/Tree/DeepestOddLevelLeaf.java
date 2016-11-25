/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class DeepestOddLevelLeaf {

	public static int findDeepest(TreeNode root,int level){
		
		if(root == null)
			return 0;
		if(root.isLeaf() && level%2 == 1)
			return level;
		return Math.max(findDeepest(root.getLeft(), level+1),findDeepest(root.getRight(), level+1));
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
		root.getRight().getRight().setRight(new TreeNode(8));
		
		System.out.println(findDeepest(root, 0));

	}

}
