/**
 * 
 */
package org.mohsin.geek.Tree;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class IterativePostOrder {

	public static void postOrder(TreeNode root){
		
		if(root == null)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		
		while(true){
			
			while(root != null){
				if(root.getRight() != null){
					s.push(root.getRight());
				}
				s.push(root);
				root = root.getLeft();
			}
			
			if(s.empty()) break;
			
			root = s.pop();
			if(!s.empty() && root.getRight() == s.peek()){
				s.pop();
				s.push(root);
				root = root.getRight();
			}else{
				System.out.print(root.getData()+" ");
				root = null;
			}
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
		
		postOrder(root);
		root.postorder(root);

	}

}
