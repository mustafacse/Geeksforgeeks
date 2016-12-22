package org.mohsin.geek.Tree;

public class PairInDifferentBSTs {

	private static TreeNode prev = null;
	
	public static void bst2Dll(TreeNode root){
		
		if(root == null)
			return;
		bst2Dll(root.getRight());
		
		root.setRight(prev);
		if(prev != null)
			prev.setLeft(root);
		prev = root;
		
		bst2Dll(root.getLeft());
	}
	
	public static void findPairs(TreeNode root1,TreeNode root2,int key){
		
		if(root1 == null)
			return;
		if(root2 == null)
			return;
		
		bst2Dll(root1);
		
		prev = null;
		
		bst2Dll(root2);
		
		while(root1.getLeft() != null)
			root1 = root1.getLeft();
		
		while(root2.getRight() != null)
			root2  = root2.getRight();
		
		while(root1 != null && root2 != null){
			int sum = root1.getData()+root2.getData();
			if(sum == key){
				System.out.println("( "+root1.getData()+", "+root2.getData()+")");
				root1 = root1.getRight();
				root2 = root2.getLeft();
			}else if(sum < key)
				root1 = root1.getRight();
			else
				root2 = root2.getLeft();
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root1 = new TreeNode(8);
		root1.setLeft(new TreeNode(3));
		root1.setRight(new TreeNode(10));
		root1.getLeft().setLeft(new TreeNode(1));
		root1.getLeft().setRight(new TreeNode(6));
		root1.getRight().setRight(new TreeNode(14));
		root1.getRight().getRight().setLeft(new TreeNode(13));
		root1.getLeft().getRight().setLeft(new TreeNode(5));
		root1.getLeft().getRight().setRight(new TreeNode(7));
		
		
		TreeNode root2 = new TreeNode(5);
		root2.setLeft(new TreeNode(2));
		root2.setRight(new TreeNode(18));
		root2.getLeft().setLeft(new TreeNode(1));
		root2.getLeft().setRight(new TreeNode(3));
		root2.getLeft().getRight().setRight(new TreeNode(4));
		
		findPairs(root1, root2, 10);

	}

}
