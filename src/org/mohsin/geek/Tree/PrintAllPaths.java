package org.mohsin.geek.Tree;

public class PrintAllPaths {

	public static void printAllPaths(TreeNode root,int paths[],int pathlen){
		if(root == null) return;
		
		paths[pathlen++] = root.getData();
		if(root.isLeaf()) printPath(paths,pathlen);
		else{
			printAllPaths(root.getLeft(),paths,pathlen);
			printAllPaths(root.getRight(),paths,pathlen);
		}
	}
	
	public static void printPath(int paths[],int pathlen){
		for(int i = 0;i < pathlen;++i){
			System.out.print(paths[i]+" ");
		}
		System.out.println("***********************");
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		int paths[] = new int[100];
		printAllPaths(root, paths, 0);

	}

}
