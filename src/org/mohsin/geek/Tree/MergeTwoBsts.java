package org.mohsin.geek.Tree;

public class MergeTwoBsts {

	private static TreeNode prev = null;
	private static TreeNode head = null;
	
	
	public static TreeNode merge(TreeNode a,TreeNode b){
		if(a == null)
			return b;
		if(b == null)
			return a;
		if(a.getData() <= b.getData()){
			a.setRight(merge(a.getRight(), b));
			a.getRight().setLeft(a);
			a.setLeft(null);
			return a;
		}else{
			b.setRight(merge(a, b.getRight()));
			b.getRight().setLeft(b);
			b.setLeft(null);
			return b;
		}
	}
	
	public static void bst2dll(TreeNode root){
		if(root == null)
			return ;
		bst2dll(root.getRight());
		root.setRight(prev);
		if(prev != null)
			prev.setLeft(root);
		prev = root;
		bst2dll(root.getLeft());
	}
	
	public static TreeNode dll2bst(int n){
		if(n <= 0)
			return null;
		
		TreeNode left = dll2bst(n/2);
		
		TreeNode root = new TreeNode(head.getData());
		head = head.getRight();
		root.setLeft(left);
		root.setRight(dll2bst(n-n/2-1));
		return root;
			
	}
	
	public static TreeNode getLeft(TreeNode root){
		if(root == null)
			return null;
		
		while(root.getLeft() != null)
			root = root.getLeft();
		return root;
		
	}
	
	public static int countNodes(TreeNode head){
		
		TreeNode root = head;
		if(head == null)
			return 0;
		int count = 0;
		while(root != null){
			root = root.getRight();
			++count;
		}
		return count;
	}
	
	public static void printList(TreeNode root){
		TreeNode curr = root;
		while(curr != null){
			System.out.print(curr.getData()+" ");
			curr = curr.getRight();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(100);
		root.setLeft(new TreeNode(50));
		root.setRight(new TreeNode(300));
		root.getLeft().setLeft(new TreeNode(20));
		root.getLeft().setRight(new TreeNode(70));
		
		TreeNode root2 = new TreeNode(80);
		root2.setLeft(new TreeNode(40));
		root2.setRight(new TreeNode(120));
		
		
		bst2dll(root);
		root = getLeft(root);
		prev = null;
		bst2dll(root2);
		root2 = getLeft(root2);

		printList(root);
		printList(root2);
		
		head = merge(root, root2);
		printList(head);
		root = dll2bst(countNodes(head));
		root.inorder(root);
		
	}

}
