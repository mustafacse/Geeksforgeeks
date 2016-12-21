package org.mohsin.geek.Tree;

import java.util.HashMap;

public class PathOfDifferentLength {

	
	public static void paths(TreeNode root,HashMap<Integer,Integer> hm,int pathLen){
		
		if(root == null) return;
		
		if(root.isLeaf()){
			if(hm.get(pathLen) == null)
				hm.put(pathLen, 1);
			else{
				int prevVal = hm.get(pathLen);
				hm.put(pathLen, prevVal+1);
			}
			return;
		}
		
		paths(root.getLeft(), hm, pathLen+1);
		paths(root.getRight(), hm, pathLen+1);
	}
	
	public static void sameLenPaths(TreeNode root){
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		paths(root,hm,0);
		
		if(hm.isEmpty() == false){
			System.out.println(hm.entrySet());
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		sameLenPaths(root);
	}

}
