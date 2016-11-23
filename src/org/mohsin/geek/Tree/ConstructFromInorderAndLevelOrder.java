package org.mohsin.geek.Tree;

public class ConstructFromInorderAndLevelOrder {

	public static TreeNode construct(int in[],int level[],int start,int end){
		
		if(start > end)
			return null;
		if(start == end)
			return new TreeNode(in[start]);
		
		TreeNode root = null;
		
		boolean found = false;
		int index = 0;
		for(int i = 0;i < level.length;++i){
			int data = level[i];
			for(int j = start;j <= end;++j){
				if(data == in[j]){
					root = new TreeNode(data);
					index = j;
					found = true;
					break;
				}
			}
			
			if(found)
				break;
		}
		
		root.setLeft(construct(in, level, start, index-1));
		root.setRight(construct(in, level, index+1, end));
		
		return root;
	}
	
	public static void main(String[] args) {
		
		 int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
	     int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
	     
	     TreeNode root = construct(in, level, 0, in.length-1);
	     root.levelOrder(root);

	}

}
