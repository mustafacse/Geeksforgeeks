package org.mohsin.geek.String;

import org.mohsin.geek.Tree.TreeNode;

public class FirstNonRepeatingCharacter {

	private static TreeNode head = null,tail = null;
	
	public static void insertNode(TreeNode temp){
		
		if(head == null)
			head = tail = temp;
		else{
			tail.setRight(temp);
			temp.setLeft(tail);
			tail = temp;
		}
	}
	
	public static void removeNode(TreeNode temp){
		
		if(temp == head)
			head = head.getRight();
		if(temp == tail)
			tail = tail.getLeft();
		if(temp.getRight() != null)
			temp.getRight().setLeft(temp.getLeft());
		if(temp.getLeft() != null)
			temp.getLeft().setRight(temp.getRight());
	}
	
	public static void nonrepeatingChar(String str){
		
		TreeNode arr[] = new TreeNode[256];
		boolean repeated[] = new boolean[256];
		
		int len = str.length();
		for(int i = 0;i < len;++i){
			char ch = str.charAt(i);
			if(!repeated[ch]){
				if(arr[ch] == null){
					TreeNode temp = new TreeNode(ch);
					insertNode(temp);
					arr[ch] = temp;
				}else{
					repeated[ch] = true;
					TreeNode temp = arr[ch];
					removeNode(temp);
				}
			}
			System.out.println((char)head.getData());
		}
	}
	
	
	public static void main(String[] args) {
		
		String str = "geeksforgeeksandgeeksquizfor";
		nonrepeatingChar(str);

	}

}
