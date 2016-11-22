/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class BoundaryTraversal {

	public static void boundaryTraversal(TreeNode root){
		
		if(root == null) return;
		
		System.out.println(root.getData());
		printLeft(root.getLeft());
		printLeaf(root.getLeft());
		printLeaf(root.getRight());
		printRight(root.getRight());
	}
	
	public static void printLeft(TreeNode root){
		
		if(root == null) return;
		
		if(root.getLeft() != null){
			System.out.println(root.getData());
			printLeft(root.getLeft());
		}
		else if(root.getRight() != null){
			System.out.println(root.getData());
			printLeft(root.getRight());
		}
	}
	
	public static void printRight(TreeNode root){
		
		if(root == null) return;
		
		if(root.getRight() != null){
			printRight(root.getRight());
			System.out.println(root.getData());
		}
		else if(root.getLeft() != null){
			printRight(root.getLeft());
			System.out.println(root.getData());
		}
	}
	
	public static void printLeaf(TreeNode root){
		if(root == null) return;
		
		if(root.isLeaf())
			System.out.println(root.getData());
		printLeaf(root.getLeft());
		printLeaf(root.getRight());
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
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		boundaryTraversal(root);
	}

}
