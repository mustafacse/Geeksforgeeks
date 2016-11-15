package org.mohsin.geek.Tree;

public class TreeNode {

	private int data;
	private TreeNode left;
	private TreeNode right;
	public TreeNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void inorder(TreeNode root)
	{
		if(root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getData()+" ");
		inorder(root.getRight());
	}
	
	public void preorder(TreeNode root)
	{
		if(root == null)
			return;
		System.out.print(root.getData()+" ");
		preorder(root.getLeft());
		preorder(root.getRight());
	}
	
	public void postorder(TreeNode root){
		if(root == null)
			return;
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(root.getData()+" ");
		
	}
}
