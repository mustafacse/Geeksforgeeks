package org.mohsin.geek.Tree;

public class ConstructTreePostAndInorder {

	private static int postIndex = 0;
	
	public static TreeNode construct(int in[],int post[],int start,int end){
		
		if(start > end || postIndex < 0)
			return null;
		
		TreeNode root = new TreeNode(post[postIndex--]);
		if(start == end)
			return root;
		
		int i = start;
		for(;i <= end;++i){
			if(in[i] == root.getData())
				break;
		}
		
		root.setRight(construct(in, post, i+1, end));
		root.setLeft(construct(in, post, start, i-1));
		
		
		return root;
	}
	
	
	public static void main(String[] args) {
		
		int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
	    int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
	    
	    postIndex = post.length-1;
	    
	    TreeNode root = construct(in, post, 0, in.length-1);
	    root.inorder(root);
	}

}
