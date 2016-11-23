package org.mohsin.geek.Tree;

public class ReverseAlternateLevels {

	public static void reverse(TreeNode a,TreeNode b,int level){
		
		if(a == null || b == null)
			return ;
		
		if(level%2 == 0)
		{
			int data = a.getData();
			a.setData(b.getData());
			b.setData(data);
		}
		
		reverse(a.getLeft(), b.getRight(), level+1);
		reverse(a.getRight(), b.getLeft(), level+1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		reverse(root.getLeft(), root.getRight(), 0);
		
		root.levelOrder(root);

	}

}
