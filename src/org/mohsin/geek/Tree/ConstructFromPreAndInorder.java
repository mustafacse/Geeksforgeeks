package org.mohsin.geek.Tree;

public class ConstructFromPreAndInorder {

	private static int preIndex = 0;
	
	public static TreeNode constructTree(int in[],int pre[],int start,int end){
		if(start > end || preIndex >= in.length) return null;
		
		TreeNode root = new TreeNode(pre[preIndex++]);
		int i = 0;
		for(i = start;i <= end;++i){
			if(in[i] == root.getData())
				break;
		}
		
		root.setLeft(constructTree(in, pre, start, i-1));
		root.setRight(constructTree(in, pre, i+1, end));
		
		return root;
	}
	
	public static void main(String[] args) {
		int in[] = {4,2,5,1,6,3,7};
		int pre[] = {1,2,4,5,3,6,7};
		
		TreeNode root = constructTree(in, pre, 0, in.length-1);
		root.inorder(root);

	}

}
