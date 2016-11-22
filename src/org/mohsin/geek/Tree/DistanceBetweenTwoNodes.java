package org.mohsin.geek.Tree;

public class DistanceBetweenTwoNodes {

	private static int d1 = -1;
	private static int d2 = -1;
	private static int dist = 0;
	
	public static int findDist(TreeNode root,int n1,int n2){
		
		if(root == null)
			return -1;
		
		TreeNode lca = findDistUtil(root,n1,n2,0);
		
		if(d1 != -1 && d2 != -1)
			return dist;
		if(d1 != -1){
			return getLevel(lca,n2,0);
		}
		
		if(d2 != -1){
			return getLevel(lca,n1,0);
		}
		
		return -1;
	}
	
	public static TreeNode findDistUtil(TreeNode root,int n1,int n2,int level){
		
		if(root == null)
			return null;
		
		if(root.getData() == n1){
			d1 = level;
			return root;
		}
		
		if(root.getData() == n2){
			d2 = level;
			return root;
		}
		
		TreeNode left = findDistUtil(root.getLeft(), n1, n2, level+1);
		TreeNode right = findDistUtil(root.getRight(), n1, n2, level+1);
		
		if(left != null && right != null){
			dist = d1 + d2 - 2*level;
			return root;
		}
		
		else if(left != null)
			return left;
		else if(right != null)
			return right;
		return null;
	}
	
	public static int getLevel(TreeNode root,int data,int level){
		
		if(root == null)
			return -1;
		if(root.getData() == data)
			return level;
		int res = getLevel(root.getLeft(), data, level+1);
		if(res != -1)
			return res;
		return getLevel(root.getRight(), data, level+1);
	}
	
	public static void main(String[] args) {


		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println(findDist(root, 4, 1));

	}

}
