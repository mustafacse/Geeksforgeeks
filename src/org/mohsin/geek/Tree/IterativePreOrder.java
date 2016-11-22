/**
 * 
 */
package org.mohsin.geek.Tree;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class IterativePreOrder {

	public static void preOrder(TreeNode root){
		
		if(root == null)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		
		while(true){
			while(root != null){
				System.out.print(root.getData()+" ");
				s.push(root);
				root = root.getLeft();
			}
			
			if(s.isEmpty())
				break;
			root = s.pop();
			root = root.getRight();
		}
		System.out.println();
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
		
		preOrder(root);
		root.preorder(root);
		

	}

}
