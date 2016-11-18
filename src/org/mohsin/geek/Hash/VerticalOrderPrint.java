package org.mohsin.geek.Hash;

import java.util.HashMap;
import java.util.LinkedList;

import org.mohsin.geek.Tree.TreeNode;

public class VerticalOrderPrint {

	public static void printVertical(TreeNode root){
		
		if(root == null) return;
		
		HashMap<Integer,LinkedList<Integer>> hm = new HashMap<>();
		
		printVerticalUtil(root,hm,0);
		
		if(!hm.isEmpty())
			System.out.println(hm.entrySet());
		else
			System.out.println("empty");
	}
	
	public static void printVerticalUtil(TreeNode root, HashMap<Integer,LinkedList<Integer>> hm,int hd){
		
		if(root == null) return;
		
		if(hm.get(hd) == null){
			LinkedList<Integer> arr = new LinkedList<>();
			arr.add(root.getData());
			hm.put(hd, arr);
		}else{
			LinkedList<Integer> arr = hm.get(hd);
			arr.add(root.getData());
			hm.put(hd, arr);
		}
		
		printVerticalUtil(root.getLeft(), hm, hd-1);
		printVerticalUtil(root.getRight(), hm, hd+1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.setLeft(new TreeNode(7));
		root.setRight(new TreeNode(2));
		root.getLeft().setLeft(new TreeNode(3));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(30));
		
		printVertical(root);

	}

}
