package org.mohsin.geek.Tree;


//Complexity : O(n)

public class TreeFromPreOrder {

	private static int preIndex = 0;
	public static TreeNode construct(int pre[], char preN[]){
		
		if(preIndex >= pre.length)  return null;
		
		TreeNode root = new TreeNode(pre[preIndex]);
		
		if(preN[preIndex++] == 'N'){
			root.setLeft(construct(pre,preN));
			root.setRight(construct(pre, preN));
		}
		
		return root;
	}
	
	public static void main(String[] args) {
	
		int pre[] = {10, 30, 20, 5, 15};
	    char preLN[] = {'N', 'N', 'L', 'L', 'L'};
	    
	    TreeNode root = construct(pre, preLN);
	    root.inorder(root);

	}

}
