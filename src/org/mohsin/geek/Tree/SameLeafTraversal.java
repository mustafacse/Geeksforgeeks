package org.mohsin.geek.Tree;

import java.util.Stack;

public class SameLeafTraversal {

	public static boolean isSame(TreeNode a,TreeNode b){
		
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		s1.push(a);
		s2.push(b);
		
		while(!s1.empty() || !s2.empty()){
			
			if(s1.empty() || s2.empty())
				return false;
			
			TreeNode temp1 = s1.pop();
			while(temp1!= null && temp1.isLeaf() == false){
				if(temp1.getLeft() != null)
					s1.push(temp1.getLeft());
				if(temp1.getRight() != null)
					s1.push(temp1.getRight());
				temp1 = s1.pop();
			}
			
			TreeNode temp2 = s2.pop();
			while(temp2 != null && temp2.isLeaf() == false){
				if(temp2.getLeft() != null)
					s2.push(temp2.getLeft());
				if(temp2.getRight() != null)
					s2.push(temp2.getRight());
				temp2 = s2.pop();
			}
			
			if(temp1 == null && temp2 != null)
				return false;
			if(temp1 != null && temp2 == null)
				return false;
			
			if(temp1!= null && temp2 != null){
				if(temp1.getData() != temp2.getData())
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		
		TreeNode root1 = new TreeNode(1);
		root1.setLeft(new TreeNode(2));
		root1.setRight(new TreeNode(3));
		root1.getLeft().setLeft(new TreeNode(4));
		
		if(isSame(root, root1))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
