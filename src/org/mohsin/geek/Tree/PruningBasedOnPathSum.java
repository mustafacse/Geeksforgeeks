/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class PruningBasedOnPathSum {

	public static TreeNode prune(TreeNode root,int sum){
		if(root == null)
			return null;
		
		root.setLeft(prune(root.getLeft(), sum-root.getData()));
		root.setRight(prune(root.getRight(), sum-root.getData()));
		
		if(root.isLeaf())
		{
			if(root.getData() < sum)
				return null;
		}
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		root = prune(root, 9);
		root.inorder(root);

	}

}
