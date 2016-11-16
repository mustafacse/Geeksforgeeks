package org.mohsin.geek.Tree;

public class LowestCommonAncestor {

	public static TreeNode LCA(TreeNode root, int n1, int n2) {
		if(root == null) return null;
		
		if(root.getData() > n1 && root.getData() > n2)
			return LCA(root.getLeft(),n1,n2);
		else if(root.getData() < n1 && root.getData() < n2)
			return LCA(root.getRight(),n1,n2);
		return root;
			
	}

	public static void main(String[] args) {
	
		int arr[] = {8,22,4,12,10,14};
		
		TreeNode root = new TreeNode(20);
		for(int i = 0;i < arr.length;++i){
			root = root.bstInsert(root, arr[i]);
		}

		System.out.println(LCA(root,10,14).getData());
		
	}
	
	
}
