package org.mohsin.geek.Tree;

public class TripletOfZero {

	private static TreeNode head = null,tail = null;
	
	public static void convert2Dll(TreeNode root){
		
		if(root == null)
			return;
		
		if(root.getLeft() != null)
			convert2Dll(root.getLeft());
		
		root.setLeft(tail);
		if(tail != null)
			tail.setRight(root);
		else
			head = root;
		
		tail = root;
		if(root.getRight() != null)
			convert2Dll(root.getRight());
	}
	
	public static boolean isPresent(TreeNode head,TreeNode tail,int sum){
		
		while(head != tail){
			int curr = head.getData()+tail.getData();
			if(sum == curr)
				return true;
			if(sum > curr)
				head = head.getRight();
			else
				tail = tail.getLeft();
		}
		return false;
	}
	
	public static boolean triplet(TreeNode root){
		
		if(root == null)
			return false;
		
		convert2Dll(root);
		
		while(head.getRight() != tail && head.getData() < 0){
			
			if(isPresent(root.getRight(), tail, root.getData()*-1))
				return true;
			head = head.getRight();
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));

		if(triplet(root))
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
