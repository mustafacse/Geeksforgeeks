/**
 * 
 */
package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mohsin
 *
 */
public class CompleteTree {

	
	public static boolean recurSolution(TreeNode root,int n,int index){
		
		if(root == null)
			return true;
		
		if(index >= n)
			return false;
		
		return recurSolution(root.getLeft(), n, 2*index+1) && recurSolution(root.getRight(), n, 2*index+2);
	}
	
	public static boolean isComplete(TreeNode root){
		
		if(root == null){
			return true;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		boolean flag = false;
		
		while(!q.isEmpty()){
			root = q.remove();
			if(root.getLeft() != null){
				if(flag)
					return false;
				q.add(root.getLeft());
			}else{
				flag = true;
			}
			if(root.getRight() != null){
				if(flag)
					return false;
				q.add(root.getRight());
			}else{
				flag = true;
			}
		}
		
		return true;
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
		
		if(isComplete(root))
			System.out.println("YES");
		else
			System.out.println("NO");
		
		int n = root.countNodes(root);
		if(recurSolution(root,n,0))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
