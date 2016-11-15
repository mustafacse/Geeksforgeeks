package org.mohsin.geek.Tree;


public class Tree2CircularDoubly {

	
	public static TreeNode tree2List(TreeNode root)
	{
		if(root == null) return root;
		
		TreeNode left = tree2List(root.getLeft());
		TreeNode right = tree2List(root.getRight());
		
		root.setLeft(root);
		root.setRight(root);
		
		left = append(left,root);
		left = append(left,right);
		
		return left;
	}
	
	public static TreeNode append(TreeNode a,TreeNode b)
	{
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		TreeNode aLeft = a.getLeft();
		TreeNode bLeft = b.getLeft();
		
		join(aLeft,b);
		join(bLeft,a);
		
		return a;
	}
	
	public static void join(TreeNode a,TreeNode b)
	{
		a.setRight(b);
		b.setLeft(a);
	}
	
	public static void printList(TreeNode head)
	{
		TreeNode curr = head;
		while(head.getRight() != curr)
		{
			System.out.print(head.getData()+" ");
			head = head.getRight();
		}
		System.out.print(head.getData()+" ");
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		root.inorder(root);
		System.out.println("List is : ");
		TreeNode list = tree2List(root);
		printList(list);
	}

}
