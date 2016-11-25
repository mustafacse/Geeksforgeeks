/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class Isomorphism {

	public static boolean isIsomorphic(TreeNode a,TreeNode b){
		
		if(a == null && b == null)
			return true;
		
		if(a == null || b == null)
			return false;
		
		if(a.getData() != b.getData())
			return false;
		
		return (isIsomorphic(a.getLeft(), b.getLeft()) && isIsomorphic(a.getRight(), b.getRight()))||
				(isIsomorphic(a.getRight(), b.getLeft()) && isIsomorphic(a.getLeft(), b.getRight()));
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
		
		TreeNode root1 = new TreeNode(1);
		root1.setLeft(new TreeNode(2));
		root1.setRight(new TreeNode(3));
		root1.getLeft().setLeft(new TreeNode(4));
		root1.getLeft().setRight(new TreeNode(5));
		root1.getRight().setLeft(new TreeNode(6));
		root1.getRight().setRight(new TreeNode(7));
		
		if(isIsomorphic(root, root1))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
