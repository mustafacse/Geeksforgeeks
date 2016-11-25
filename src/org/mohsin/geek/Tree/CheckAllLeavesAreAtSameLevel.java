/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class CheckAllLeavesAreAtSameLevel {

	private static int leafLevel = 0;
	public static boolean check(TreeNode root, int level){
		
		if(root == null)
			return true;
		if(root.isLeaf()){
			if(leafLevel == 0){
				leafLevel = level;
				return true;
			}
			else
				return leafLevel == level;
		}
		return check(root.getLeft(), level+1) && check(root.getRight(), level+1);
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
		
		if(check(root, 0))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
