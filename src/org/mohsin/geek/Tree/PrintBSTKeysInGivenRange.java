package org.mohsin.geek.Tree;

public class PrintBSTKeysInGivenRange {

	public static void print(TreeNode root,int k1,int k2){
		if(root == null)
			return;
		
		if(root.getData() >= k1 && root.getData() <= k2)
			System.out.println(root.getData());
		if(root.getData() > k1)
			print(root.getLeft(),k1,k2);
		if(root.getData() < k2)
			print(root.getRight(),k1,k2);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(30);
		int arr[] = {20,8,22,5,14};
		for(int i = 0;i < arr.length;++i)
			root.bstInsert(root, arr[i]);
		
		print(root,5,14);

	}

}
