/**
 * 
 */
package org.geek.mohsin.interviews.N315;

import org.mohsin.geek.Tree.TreeNode;

/**
 * @author mohsin
 *
 */
public class F3Q1 {

	private static TreeNode prev = null;
	
	public static boolean isBst(TreeNode root){
		
		if(root == null)
			return true;
		if(!isBst(root.getLeft()))
			return false;
		if(prev != null && prev.getData() > root.getData())
			return false;
		prev = root;
		return isBst(root.getRight());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6};
		TreeNode root = new TreeNode(arr[0]);
		for(int i = 1;i < arr.length;++i)
			root.bstInsert(root, arr[i]);
		if(isBst(root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
