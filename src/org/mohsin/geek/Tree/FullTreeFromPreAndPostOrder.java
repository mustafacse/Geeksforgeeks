/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class FullTreeFromPreAndPostOrder {

	public static int preIndex = 0;
	
	public static TreeNode buildTree(int pre[], int post[],int start,int end){
		
		if(start > end || preIndex >= pre.length)
			return null;
		
		TreeNode root = new TreeNode(pre[preIndex++]);
		
		if(start == end)
			return root;
		
		int i = start;
		for(;i <= end;++i){
			if(pre[preIndex] == post[i])
				break;
		}
		
		if(i <= end){
			root.setLeft(buildTree(pre, post, start, i));
			root.setRight(buildTree(pre, post, i+1, end));
		}
		
		return root;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
	    int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
	    
	    TreeNode root = buildTree(pre, post, 0, pre.length-1);
	    root.inorder(root);
	}

}
