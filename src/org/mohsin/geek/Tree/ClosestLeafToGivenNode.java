package org.mohsin.geek.Tree;

public class ClosestLeafToGivenNode {

	private static int minDist = 0;
	
	public static void findDownLeaf(TreeNode root,int level){
		
		if(root == null)
			return;
		if(root.isLeaf()){
			if(level < minDist)
				minDist = level;
			return;
		}
		
		findDownLeaf(root.getLeft(),level+1);
		findDownLeaf(root.getRight(), level+1);
	}
	
	public static int findThroughParents(TreeNode root,int data){
		
		if(root == null) return -1;
		if(root.getData() == data)
			return 0;
		int left = findThroughParents(root.getLeft(), data);
		if(left != -1){
			findDownLeaf(root.getRight(), left+2);
			return left+1;
		}
		
		int right = findThroughParents(root.getRight(), data);
		if(right != -1){
			findDownLeaf(root.getLeft(), right+2);
			return right+1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		
		
		findDownLeaf(root.getRight(), 0);
		findThroughParents(root,3);
		System.out.println(minDist);

	}

}
