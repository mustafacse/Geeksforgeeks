package org.mohsin.geek.Tree;

import java.util.Stack;

public class LeafTraversalOfTwoBinaryTrees {

	public static boolean isSame(TreeNode root1,TreeNode root2){
		
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		s1.push(root1);
		s2.push(root2);
		
		while(!s1.empty() || !s2.empty()){
			if(s1.empty() || s2.empty())
				return false;
			
			TreeNode temp1 = s1.pop();
			while(temp1 != null && !temp1.isLeaf()){
				if(temp1.getLeft() != null)
					s1.push(temp1.getLeft());
				if(temp1.getRight() != null)
					s1.push(temp1.getRight());
				temp1 = s1.pop();
			}
			
			TreeNode temp2 = s2.pop();
			while(temp2 != null && !temp2.isLeaf()){
				if(temp2.getLeft() != null)
					s2.push(temp2.getLeft());
				if(temp2.getRight() != null)
					s2.push(temp2.getRight());
				temp2 = s2.pop();
			}
			
			if(temp1 == null && temp2 != null)
				return false;
			if(temp1 != null && temp2  == null)
				return false;
			if(temp1 != null && temp2 != null){
				if(temp1.getData() != temp2.getData())
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		root.setLeft(new TreeNode(1));
		root.setRight(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		
		TreeNode root2 = new TreeNode(2);
		root2.setLeft(new TreeNode(1));
		root2.setRight(new TreeNode(3));
		root2.getLeft().setRight(new TreeNode(5));
		root2.getRight().setLeft(new TreeNode(6));
		
		if(isSame(root, root2))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
