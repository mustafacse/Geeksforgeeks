package org.mohsin.geek.Tree;

class Height{
	int h;
}

public class Diameter {

	public static int diameter(TreeNode root,Height h){
		if(root == null){
			h.h = 0;
			return 0;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		int lDiameter = diameter(root.getLeft(),lh);
		int rDiameter = diameter(root.getRight(), rh);
		
		h.h = Math.max(lh.h, rh.h)+1;
		int max =  Math.max(lh.h+rh.h+1,Math.max(lDiameter, rDiameter));
		
		return max;
	}
	
	
	public static int getDepth(TreeNode root){
		if(root == null) return 0;
		
		int l = getDepth(root.getLeft());
		int r = getDepth(root.getRight());
		
		return l > r ? l+1 : r+1;
	}
	
	public static boolean isHeightBalanced(TreeNode root,Height ht)
	{
		if(root == null)
		{
			ht.h  = 0;
			return true;
		}
		
		Height l = new Height();
		Height r = new Height();
		
		boolean left = isHeightBalanced(root.getLeft(),l);
		boolean right = isHeightBalanced(root.getRight(),r);
		
		ht.h = Math.max(l.h, r.h);
		if((l.h-r.h) >= 2 || (r.h - l.h >= 2))
			return false;
		else
			return left && right;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getLeft().getLeft().setLeft(new TreeNode(6));
		root.getLeft().getRight().setRight(new TreeNode(7));
		
		System.out.println(diameter(root,new Height()));
		/*if(isHeightBalanced(root,new Height()))
			System.out.println("YES");
		else
			System.out.println("NO");*/
		
	}

}
