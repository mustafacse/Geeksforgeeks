package org.mohsin.geek.Tree;

public class LeastGreaterElementFromRight {

	private static TreeNode succ = null;
	
	public static TreeNode insert(TreeNode root,int data){
		
		if(root == null)
			return new TreeNode(data);
		if(root.getData() > data){
			succ = root;
			root.setLeft(insert(root.getLeft(),data));
		}else
			root.setRight(insert(root.getRight(),data));
		return root;
	}
	
	public static void nextGreater(int arr[]){
		
		TreeNode root = null;
		for(int i = arr.length-1;i >= 0;--i){
			succ = null;
			root = insert(root,arr[i]);
			if(succ == null)
				arr[i] = -1;
			else
				arr[i] = succ.getData();
		}
	}
	
	public static void main(String[] args) {
		
		int arr[] = { 8, 58, 71, 18, 31, 32, 63, 92,
                43, 3, 91, 93, 25, 80, 28 };
		
		nextGreater(arr);
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(arr[i]+" ");

	}

}
