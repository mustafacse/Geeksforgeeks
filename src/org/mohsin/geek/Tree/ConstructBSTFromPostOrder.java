package org.mohsin.geek.Tree;

public class ConstructBSTFromPostOrder {

	private static int postIndex = 0;
	
	public static TreeNode buildBST(int post[],int min,int max,int key){
		
		if(postIndex < 0)
			return null;
		
		TreeNode root = null;
		if(key > min && key < max){
			root = new TreeNode(key);
			--postIndex;
			if(postIndex > 0){
				root.setRight(buildBST(post, key, max, post[postIndex]));
				root.setLeft(buildBST(post, min, key, post[postIndex]));
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		int post[] = {1, 7, 5, 50, 40, 10};
		
		postIndex = post.length-1;
		TreeNode root = buildBST(post, Integer.MIN_VALUE, Integer.MAX_VALUE, post[post.length-1]);
		root.inorder(root);
	}

}
