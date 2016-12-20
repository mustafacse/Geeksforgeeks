package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ExtremeOfEachlevelInAlternateOrder {

	public static void levelOrder(TreeNode root){
		
		if(root == null)
			return;
		
		boolean flag = false;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		
		while(!q.isEmpty()){
			
			int n = q.size();
			int nodeCount = n;
			
			while(n-- > 0){
				root = q.remove();
				if(root.getLeft() != null)
					q.add(root.getLeft());
				if(root.getRight() != null)
					q.add(root.getRight());
				
				if(flag && n == nodeCount-1)
					System.out.print(root.getData()+" ");
				if(!flag && n == 0)
					System.out.print(root.getData()+" ");
			}
			flag = !flag;
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		a.setLeft(new TreeNode(2));
		a.setRight(new TreeNode(3));
		a.getLeft().setLeft(new TreeNode(6));
		a.getLeft().setRight(new TreeNode(7));
		a.getRight().setLeft(new TreeNode(4));
		a.getRight().setRight(new TreeNode(5));
		
		levelOrder(a);

	}

}
