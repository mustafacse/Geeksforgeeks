package org.mohsin.geek.Tree;

public class Root2LeafPathWithGivenSeq {

	public static boolean isAvail(TreeNode root,int arr[],int index){
		
		if(root == null && arr.length == 0)
			return  true;
		if(root.isLeaf() && index+1 == arr.length  && root.getData() == arr[index])
			return true;
		return index < arr.length && root.getData() == arr[index] &&(
				isAvail(root.getLeft(), arr, index+1) || isAvail(root.getRight(), arr, index+1));
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		int arr[] = {10,11,13};
		if(isAvail(root, arr, 0))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
