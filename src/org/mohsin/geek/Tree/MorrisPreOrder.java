/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class MorrisPreOrder {

	public static void preOrder(TreeNode root){
		
		if(root == null)
			return;
		
		TreeNode curr = root;
		while(curr != null){
			
			if(curr.getLeft() == null){
				System.out.print(curr.getData()+" ");
				curr = curr.getRight();
			}
			else{
				
				TreeNode prev = curr.getLeft();
				while(prev.getRight() != null && prev.getRight() != curr )
					prev = prev.getRight();
				
				if(prev.getRight() == null){
					prev.setRight(curr);
					System.out.print(curr.getData()+" ");
					curr = curr.getLeft();
				}else
				{
					prev.setRight(null);
					curr = curr.getRight();
				}
			}
		}
		System.out.println();
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
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		preOrder(root);
		root.preorder(root);

	}

}
