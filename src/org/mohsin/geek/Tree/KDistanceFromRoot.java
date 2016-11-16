package org.mohsin.geek.Tree;

public class KDistanceFromRoot {

	public static void printNodesAtKDist(TreeNode root,int k){
		if(root == null) return ;
		
		if(k == 0){
			System.out.print(root.getData()+" ");
		}
		printNodesAtKDist(root.getLeft(), k-1);
		printNodesAtKDist(root.getRight(), k-1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		printNodesAtKDist(root, 2);

	}

}
