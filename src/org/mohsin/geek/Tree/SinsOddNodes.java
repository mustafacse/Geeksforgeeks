package org.mohsin.geek.Tree;

public class SinsOddNodes {

	public static void sink(TreeNode root){
		
		if(root == null)
			return;
		
		if(root.getLeft() != null && root.getLeft().getData()%2 == 0){
			
			int temp = root.getData();
			root.setData(root.getLeft().getData());;
			root.getLeft().setData(temp);
			sink(root.getLeft());
		}else if(root.getRight() != null && root.getRight().getData() %2 == 0){
			
			int temp = root.getData();
			root.setData(root.getRight().getData());
			root.getRight().setData(temp);
			sink(root.getRight());
		}
	}
	
	public static void sinkNodes(TreeNode root){
		
		if(root == null || root.isLeaf())
			return;
		
		sinkNodes(root.getLeft());
		sinkNodes(root.getRight());
		
		if(root.getData() % 2 != 0)
			sink(root);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		root.levelOrder(root)
		;
		sinkNodes(root);
		
		root.levelOrder(root);

	}

}
