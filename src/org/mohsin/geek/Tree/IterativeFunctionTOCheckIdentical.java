package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeFunctionTOCheckIdentical {

	public static boolean isIdenttical(TreeNode a,TreeNode b)
	{
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		
		q1.add(a);
		q2.add(b);
		
		while(!q1.isEmpty() && !q2.isEmpty()){
			a = q1.remove();
			b = q2.remove();
			
			if(a.getData() != b.getData())
				return false;
			
			if(a.getLeft() != null && b.getLeft() != null){
				q1.add(a.getLeft());
				q2.add(b.getLeft());
			}
			else if(a.getLeft() != null || b.getLeft() != null)
				return false;
			if(a.getRight() != null && b.getRight() != null)
			{
				q1.add(a.getRight());
				q2.add(b.getRight());
			}
			else if(a.getRight() != null || b.getRight() != null)
				return false;
		}
		
		if(!q1.isEmpty() || !q2.isEmpty())
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		a.setLeft(new TreeNode(2));
		a.setRight(new TreeNode(3));
		a.getRight().setLeft(new TreeNode(4));
		a.getRight().setRight(new TreeNode(5));
		
		
		TreeNode b = new TreeNode(1);
		b.setLeft(new TreeNode(2));
		b.setRight(new TreeNode(3));
		b.getRight().setLeft(new TreeNode(4));
		b.getRight().setRight(new TreeNode(5));
		
		if(isIdenttical(a, b))
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
