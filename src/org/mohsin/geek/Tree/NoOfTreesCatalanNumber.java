package org.mohsin.geek.Tree;

import java.util.Vector;

public class NoOfTreesCatalanNumber {

	public static Vector<TreeNode> construct(int in[],int start,int end){
		
		Vector<TreeNode> arr = new Vector<>();
		if(start > end){
			arr.add(null);
			return arr;
		}
		
		for(int i = start;i <= end;++i){
			Vector<TreeNode> left = construct(in, start, i-1);
			Vector<TreeNode> right = construct(in,i+1,end);
			
			int len1 = left.size();
			int len2 = right.size();
			for(int j = 0;j < len1;++j){
				for(int k = 0;k < len2;++k){
					TreeNode root = new TreeNode(in[i]);
					root.setLeft(left.get(j));
					root.setRight(right.get(k));
					arr.add(root);
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {4,5,7};
		Vector<TreeNode> trees = construct(arr, 0, arr.length-1);
		
		int len = trees.size();
		for(int i = 0;i < len;++i)
		{
			trees.get(i).preorder(trees.get(i));
			System.out.println();
			
		}

	}

}
