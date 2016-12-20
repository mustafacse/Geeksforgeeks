package org.mohsin.geek.List;

import org.mohsin.geek.Tree.TreeNode;

public class ConvertBinaryTree2DLL {

	public static TreeNode concatanate(TreeNode left,TreeNode right){
		
		if(left == null)
			return right;
		if(right == null)
			return left;
		
		TreeNode leftLast = left.getLeft();
		TreeNode rightLast = right.getLeft();
		
		leftLast.setRight(right);
		right.setLeft(leftLast);
		
		rightLast.setRight(left);
		left.setLeft(rightLast);
		
		return left;
	}
	
	public static TreeNode BT2DLL(TreeNode root){
		
		if(root == null)
			return null;
		
		TreeNode left = BT2DLL(root.getLeft());
		TreeNode right = BT2DLL(root.getRight());
		
		root.setLeft(root);
		root.setRight(root);
		
		return concatanate(concatanate(left, root),right);
	}
	
	public static void traverse(TreeNode root){
		
		if(root == null)
			return;
		
		TreeNode curr = root;
		while(curr.getRight() != root){
			System.out.print(curr.getData()+" ");
			curr = curr.getRight();
		}
		
		System.out.println(curr.getData());
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		TreeNode dll = BT2DLL(root);
		traverse(dll);

	}

}
