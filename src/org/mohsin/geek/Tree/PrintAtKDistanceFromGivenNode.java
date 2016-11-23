package org.mohsin.geek.Tree;

public class PrintAtKDistanceFromGivenNode {

	public static void printKDown(TreeNode root,int k){
		
		if(root == null || k < 0)
			return;
		
		if(k == 0){
			System.out.println(root.getData());
			return;
		}
		
		printKDown(root.getLeft(), k-1);
		printKDown(root.getRight(), k-1);
	}
	
	public static int printKDistanceNode(TreeNode root,int data,int k){
		
		if(root == null)
			return -1;
		
		if(root.getData() == data){
			printKDown(root, k);
			return 0;
		}
		
		int left = printKDistanceNode(root.getLeft(), data, k);
		if(left != -1){
			if(left+1 == k)
				System.out.println(root.getData());
			else
				printKDown(root.getRight(),k-left-2);
			
			return left+1;
		}
		
		int right = printKDistanceNode(root.getRight(), data, k);
		if(right != -1){
			if(right+1 == k)
				System.out.println(root.getData());
			else
				printKDown(root.getLeft(), k-right-2);
			return right+1;
		}
		
		return -1;
		
	}
	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		printKDistanceNode(root, 2, 2);

	}

}
