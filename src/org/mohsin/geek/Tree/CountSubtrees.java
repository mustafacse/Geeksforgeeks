package org.mohsin.geek.Tree;

public class CountSubtrees {

	private static int count = 0;
	
	public static boolean count(TreeNode root,int k1,int k2){
		
		if(root == null)
			return true;
		
		boolean left = root.getLeft() == null ? true : count(root.getLeft(),k1,k2);
		boolean right = root.getRight() == null ? true : count(root.getRight(),k1,k2);
		
		if(left && right && root.getData() <= k2 && root.getData() >= k1){
			++count;
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		

		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(5));
		root.setRight(new TreeNode(50));
		root.getLeft().setLeft(new TreeNode(1));
		root.getRight().setLeft(new TreeNode(40));
		root.getRight().setRight(new TreeNode(100));
		
		int k1 = 1,k2 = 45;
		count(root,k1,k2);
		System.out.println(count);

	}

}
