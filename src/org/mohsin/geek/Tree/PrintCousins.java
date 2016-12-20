package org.mohsin.geek.Tree;

public class PrintCousins {

	public static int getLevel(TreeNode root,TreeNode node,int level){
		
		if(root == null)
			return -1;
		if(root == node)
			return level;
		int downLevel = getLevel(root.getLeft(), node, level+1);
		if(downLevel != -1)
			return downLevel;
		return getLevel(root.getRight(), node, level+1);
	}
	
	public static void printLevel(TreeNode root,TreeNode node,int level){
		
		if(root == null || level < 2)
			return;
		if(level == 2){
			if(root.getLeft() == node || root.getRight() == node)
				return ;
			if(root.getLeft() != null)
				System.out.print(root.getLeft().getData()+" ");
			if(root.getRight()!= null)
				System.out.print(root.getRight().getData()+" ");
		}
		else if(level > 2){
			printLevel(root.getLeft(), node, level-1);
			printLevel(root.getRight(), node, level-1);
		}
	}
	
	public static void printCousins(TreeNode root,TreeNode node){
		
		int level = getLevel(root, node, 1);
		printLevel(root, node, level);
	}
	
	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		a.setLeft(new TreeNode(2));
		a.setRight(new TreeNode(3));
		a.getLeft().setLeft(new TreeNode(6));
		a.getLeft().setRight(new TreeNode(7));
		a.getRight().setLeft(new TreeNode(4));
		a.getRight().setRight(new TreeNode(5));
		
		printCousins(a,a.getLeft().getLeft());
		
	}

}
