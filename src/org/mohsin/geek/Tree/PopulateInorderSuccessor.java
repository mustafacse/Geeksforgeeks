package org.mohsin.geek.Tree;

class SuccNode{
	int data;
	SuccNode left,right;
	SuccNode next;
	
	public SuccNode(int x)
	{
		data = x;
		left = right = next = null;
	}
	
}

public class PopulateInorderSuccessor {

	public static void populate(SuccNode root,SuccNode next){
		if(root == null)
			return;
		
		populate(root.right, next);
		root.next = next;
		next = root;
		populate(root.left, next);
	}
	
	public static void main(String[] args) {
		SuccNode root = new SuccNode(1);
		root.left = new SuccNode(2);
		root.right = new SuccNode(3);
		
		populate(root, null);
		
		System.out.println(root.left.next.data);
	}

}
