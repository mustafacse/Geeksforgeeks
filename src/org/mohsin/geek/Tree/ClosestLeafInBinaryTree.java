package org.mohsin.geek.Tree;

public class ClosestLeafInBinaryTree {

	
	public static int closestDownLeaf(TreeNode root){
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.isLeaf())
			return 0;
		return 1+Math.min(closestDownLeaf(root.getLeft()),closestDownLeaf(root.getRight()));
	}
	
	public static int closestLeaf(TreeNode root,int k,TreeNode parents[],int index){
		
		if(root == null)
			return Integer.MAX_VALUE;
		
		if(root.getData() == k){
			
			int res = closestDownLeaf(root);
			for(int i = index-1;i >= 0;--i)
				res = Math.min(res, index-i+closestDownLeaf(parents[i]));
			return res;
		}
		
		parents[index] = root;
		return Math.min(closestLeaf(root.getLeft(), k, parents, index+1), closestLeaf(root.getRight(), k, parents, index+1));
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		TreeNode parents[] = new TreeNode[100];
		System.out.println(closestLeaf(root, 1, parents, 0));
	}

}
