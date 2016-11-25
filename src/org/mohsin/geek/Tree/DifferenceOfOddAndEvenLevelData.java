/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class DifferenceOfOddAndEvenLevelData {

	public static int diff(TreeNode root){
		
		if(root == null)
			return 0;
		return root.getData() - (diff(root.getLeft())+diff(root.getRight()));
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
		
		System.out.println(diff(root));

	}

}
