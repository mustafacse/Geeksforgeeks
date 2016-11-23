package org.mohsin.geek.Tree;

public class CheckForSubTree {

	private static int index = 0;
	public static void storeInorder(TreeNode root,char arr[]){
		
		if(root == null)
			return;
		storeInorder(root.getLeft(), arr);
		arr[index++] = (char) (root.getData()+'0');
		storeInorder(root.getRight(), arr);
	}
	
	public static void storePreorder(TreeNode root,char arr[]){
		
		if(root == null)
			return ;
		arr[index++] = (char) (root.getData()+'0');
		storePreorder(root.getLeft(), arr);
		storePreorder(root.getRight(), arr);
	}
	
	public static boolean check(TreeNode a,TreeNode b){
		
		if(b == null)
			return true;
		if(a == null)
			return false;
		
		int n1 = a.countNodes(a);
		int n2 = b.countNodes(b);
		char inA[] = new char[n1];
		char inB[] = new char[n2];
		
		storeInorder(a, inA);
		index = 0;
		storeInorder(b, inB);
		
		String str1 = new String(inA);
		String str2 = new String(inB);
		
		System.out.println(str1+" "+str2);
		if(str1.contains(str2) == false)
			return false;
		
		index = 0;
		storePreorder(a,inA);
		index = 0;
		storePreorder(b, inB);
		
		str1 = new String(inA);
		str2 = new String(inB);
		System.out.println(str1+" "+str2);
		if(str1.contains(str2) == false)
			return false;
		
		return true;
		
		
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		TreeNode root2 = new TreeNode(7);
		
		if(check(root, root2))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
