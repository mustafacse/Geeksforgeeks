package org.mohsin.geek.Tree;

public class LongestConsecutivePath {

	public static int LCP(TreeNode root,int prevVal,int prevLen){
		
		if(root == null){
			return prevLen;
		}
		
		int currVal = root.getData();
		if(currVal == prevVal+1){
			return Math.max(LCP(root.getLeft(), currVal, prevLen+1), LCP(root.getRight(), currVal, prevLen+1));
		}
		
		int newPathLen = Math.max(LCP(root.getLeft(), currVal, 1), LCP(root.getRight(), currVal, 1));
		return Math.max(prevLen, newPathLen);
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		System.out.println(LCP(root, root.getData()-1, 0));

	}

}
