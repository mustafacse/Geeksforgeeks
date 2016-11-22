package org.mohsin.geek.Tree;

public class ExtractLeaf2DLL {

	private static TreeNode head = null;
	
	public static TreeNode extract(TreeNode root){
		
		if(root == null)
			return null;
		
		if(root.isLeaf()){
			root.setRight(head);
			if(head != null)
				head.setLeft(root);
			head = root;
			return null;
		}
		
		root.setRight(extract(root.getRight()));
		root.setLeft(extract(root.getLeft()));
		
		return root;
	}
	
	
	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		root.inorder(root);
		System.out.println("After extraction of leaves : ");
		root = extract(root);
		root.inorder(root);
		System.out.println(" DLL is :");
		TreeNode curr = head;
		while(curr != null){
			System.out.print(curr.getData()+" ");
			curr = curr.getRight();
		}

	}

}
