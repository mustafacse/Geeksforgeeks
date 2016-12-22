package org.mohsin.geek.Tree;

import java.util.Stack;

public class FindPair {

	public static boolean findPair(TreeNode root,int sum){
		
		if(root == null)
			return false;
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		int val1 = 0,val2 = 0;
		boolean done1 = false;
		boolean done2 = false;
		
		TreeNode curr1 = root,curr2 = root;
		
		while(true){
			
			while(!done1){
				if(curr1 != null){
					s1.push(curr1);
					curr1 = curr1.getLeft();
				}else{
					if(s1.empty())
						done1 = true;
					else{
						curr1 = s1.pop();
						val1 = curr1.getData();
						curr1 = curr1.getRight();
						done1 = true;
					}
				}
			}
			
			while(!done2){
				if(curr2 != null){
					s2.push(curr2);
					curr2 = curr2.getRight();
				}else{
					if(s2.empty())
						done2 = true;
					else{
						curr2 = s2.pop();
						val2 = curr2.getData();
						curr2 = curr2.getLeft();
						done2 = true;
					}
				}
			}
			
			if(val1 != val2 && val1+val2 == sum)
				return true;
			else if(val1+val2 > sum)
				done2 = false;
			else if(val1+val2 < sum)
				done1 = false;
			if(val1 >= val2)
				return false;
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
		
		if(findPair(root, 20))
			System.out.println("yes");
		else
			System.out.println("no");

	}

}
