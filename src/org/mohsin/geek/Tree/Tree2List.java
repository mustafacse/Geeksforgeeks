/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class Tree2List {

	private static TreeNode next = null;
	
	public static void convert1(TreeNode root){
		
		if(root == null)
			return;
		
		convert1(root.getRight());
		root.setRight(next);
		if(next != null)
			next.setLeft(root);
		next = root;
		convert1(root.getLeft());
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
		//root.getRight().setRight(new TreeNode(7));
		
		convert1(root);
		while(root.getLeft() != null)
			root = root.getLeft();
		
		while(root != null){
			System.out.println(root.getData());
			root = root.getRight();
		}
	}

}
