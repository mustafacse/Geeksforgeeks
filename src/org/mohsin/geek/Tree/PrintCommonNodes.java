package org.mohsin.geek.Tree;

import java.util.Stack;

public class PrintCommonNodes {

	public static void printNodes(TreeNode root1,TreeNode root2){
		
		if(root1 == null || root2 == null)
			return;
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		while(true){
			if(root1 != null){
				s1.push(root1);
				root1 = root1.getLeft();
			}
			else if(root2 != null){
				s2.push(root2);
				root2 = root2.getLeft();
			}
			else if(!s1.empty() && !s2.empty()){
				root1 = s1.peek();
				root2 = s2.peek();
				if(root1.getData() == root2.getData()){
					System.out.println(root1.getData());
					s1.pop();
					s2.pop();
					root1 = root1.getRight();
					root2 = root2.getRight();
				}else if(root1.getData() < root2.getData()){
					s1.pop();
					root1 = root1.getRight();
					root2 = null;
				}else{
					s2.pop();
					root1 = null;
					root2 = root2.getRight();
				}
			}else{
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(5));
		root.setRight(new TreeNode(50));
		root.getLeft().setLeft(new TreeNode(1));
		root.getRight().setLeft(new TreeNode(40));
		root.getRight().setRight(new TreeNode(100));
		
		TreeNode root2 = new TreeNode(10);
		root2.setLeft(new TreeNode(5));
		root2.setRight(new TreeNode(50));
		root2.getLeft().setLeft(new TreeNode(1));
		root2.getRight().setLeft(new TreeNode(40));
		root2.getRight().setRight(new TreeNode(100));
		
		printNodes(root, root2);
		

	}

}
