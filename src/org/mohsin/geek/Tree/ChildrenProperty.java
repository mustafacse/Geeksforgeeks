package org.mohsin.geek.Tree;

public class ChildrenProperty {

	public static boolean childrenSumProp(TreeNode root){
		if(root == null || root.isLeaf())
			return true;
		if(root.getData() != (root.getLeft().getData()+root.getRight().getData()))
			return false;
		return childrenSumProp(root.getLeft()) && childrenSumProp(root.getRight());
	}
	
	public static void convertTree(TreeNode root){
		if(root == null || root.isLeaf())
			return;
		
		convertTree(root.getLeft());
		convertTree(root.getRight());
		
		TreeNode left = root.getLeft();
		TreeNode right = root.getRight();
		int leftData = 0,rightData = 0;
		
		if(left != null)
			leftData = left.getData();
		if(right != null)
			rightData = right.getData();
		
		int diff = root.getData() - (leftData+rightData);
		if(diff < 0)
			root.setData(root.getData()-diff);
		else if(diff > 0)
			increment(root,diff);
	}
	
	public static void increment(TreeNode root,int diff){
		if(root.getLeft() != null){
			root.getLeft().setData(root.getLeft().getData()+diff);
			increment(root.getLeft(),diff);
		}
		else if(root.getRight() != null){
			root.getRight().setData(root.getRight().getData()+diff);
			increment(root.getRight(),diff);
		}
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.setLeft(new TreeNode(7));
		root.setRight(new TreeNode(2));
		root.getLeft().setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(30));
		
		root.levelOrder(root);
		convertTree(root);
		if(childrenSumProp(root))
		root.levelOrder(root);
	}

}
