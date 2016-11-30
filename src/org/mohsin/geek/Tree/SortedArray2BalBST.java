package org.mohsin.geek.Tree;

public class SortedArray2BalBST {

	public static TreeNode build(int arr[],int start,int end){
		
		if(start > end)
			return null;
		int mid = (start+(end-start)/2);
		TreeNode root = new TreeNode(arr[mid]);
		root.setLeft(build(arr, start, mid-1));
		root.setRight(build(arr, mid+1, end));
		return root;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6};
		TreeNode root = build(arr, 0, arr.length-1);
		System.out.println(root.getHeight(root));

	}

}
