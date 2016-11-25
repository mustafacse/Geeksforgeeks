/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class LeftView {

	private static int max = 0;
	
	public static void printLeft(TreeNode root,int level){
		
		if(root == null)
			return;
		if(max < level){
			System.out.println(root.getData());
			max = level;
		}
		printLeft(root.getLeft(), level+1);
		printLeft(root.getRight(), level+1);
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
		
		printLeft(root, 1);

	}

}
