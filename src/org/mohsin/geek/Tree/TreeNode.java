package org.mohsin.geek.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getData() + " ");
		inorder(root.getRight());
	}

	public void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		preorder(root.getLeft());
		preorder(root.getRight());
	}

	public void postorder(TreeNode root) {
		if (root == null)
			return;
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(root.getData() + " ");

	}

	public void levelOrder(TreeNode root){
		if(root == null) return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.remove();
			System.out.print(temp.getData()+" ");
			if(temp.getLeft() != null)
				queue.add(temp.getLeft());
			if(temp.getRight() != null)
				queue.add(temp.getRight());
		}
		System.out.println("*************************");
	}
	
	public void spiralOrder(TreeNode root){
		if(root == null) return;
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		s1.push(root);
		
		while(!s1.empty() || !s2.empty()){
			
			while(!s1.empty()){
				TreeNode temp = s1.pop();
				System.out.print(temp.getData()+" ");
				if(temp.getRight() != null)
					s2.push(temp.getRight());
				if(temp.getLeft() != null)
					s2.push(temp.getLeft());
			}
			
			while(!s2.empty()){
				TreeNode temp = s2.pop();
				System.out.print(temp.getData()+" ");
				if(temp.getLeft() != null)
					s1.push(temp.getLeft());
				if(temp.getRight() != null)
					s1.push(temp.getRight());
			}
		}
		
		System.out.println("*******************************");
	}
	
	public boolean isLeaf() {
		if (this.left == null && this.right == null)
			return true;

		return false;
	}

	public TreeNode bstInsert(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		if (root.getData() < data)
			root.setRight(bstInsert(root.getRight(), data));
		else
			root.setLeft(bstInsert(root.getLeft(), data));
		return root;
	}
	
	public int countLeaf(TreeNode root){
		if(root == null) return 0;
		if(root.isLeaf()) return 1;
		return countLeaf(root.getLeft())+countLeaf(root.getRight());
	}
	
	public int getHeight(TreeNode root){
		
		if(root == null) 
			return 0;
		
		int left = getHeight(root.getLeft());
		int right = getHeight(root.getRight());
		
		return Math.max(left, right) + 1;
	}
	
}
