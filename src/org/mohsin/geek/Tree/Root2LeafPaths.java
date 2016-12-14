package org.mohsin.geek.Tree;

import java.util.HashMap;
import java.util.Stack;

public class Root2LeafPaths {

	public static void printPaths(TreeNode root,HashMap<TreeNode,TreeNode> hm){
		
		Stack<TreeNode> s = new Stack<>();
		
		while(root != null){
			s.push(root);
			root = hm.get(root);
		}
		
		while(!s.empty()){
			System.out.print(s.pop().getData()+" ");
		}
		
		System.out.println();
	}
	
	public static void iterative(TreeNode root){
		
		if(root == null)
			return;
		
		HashMap<TreeNode,TreeNode> hm = new HashMap<>();
		
		Stack<TreeNode> s = new Stack<>();
		
		TreeNode parent = null;
		
		while(true){
			while(root != null){
				hm.put(root, parent);
				s.push(root);
				parent = root;
				root = root.getLeft();
			}
			
			if(s.empty())
				break;
			
			root = s.pop();
			if(root.isLeaf())
				printPaths(root, hm);
			
			parent = root;
			root = root.getRight();
			
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		iterative(root);

	}

}
