package org.mohsin.geek.String;

import java.util.Arrays;

import org.mohsin.geek.List.ListNode;

class Anagramnode{
	
	boolean isLeaf;
	Anagramnode children[];
	ListNode head;
	
	public Anagramnode(){
		isLeaf = false;
		children = new Anagramnode[256];
		head = null;
	}
}


public class PrintAllAngramsTogether {

	public static void insert(Anagramnode root,char str[],int val){
		
		Arrays.sort(str);
		
		for(int i = 0;i < str.length;++i){
			int index = str[i]-'a';
			if(root.children[index] == null)
				root.children[index] = new Anagramnode();
			root = root.children[index];
		}
		
		root.isLeaf = true;
		if(root.head == null){
			root.head = new ListNode(val);
		}else{
			ListNode newNode = new ListNode(val);
			newNode.setNext(root.head);
			root.head = newNode;
		}
	}
	
	public static void print(Anagramnode root,String str[]){
		
		if(root == null)
			return;
		
		if(root.isLeaf){
			ListNode curr = root.head;
			while(curr != null){
				System.out.print(str[curr.getData()]+", ");
				curr = curr.getNext();
			}
			System.out.println();
			return;
		}
		
		for(int i = 0;i < 256;++i)
			if(root.children[i] != null)
				print(root.children[i], str);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"cat", "dog", "tac", "god", "act", "gdo"};
		
		Anagramnode root = new Anagramnode();
		for(int i = str.length-1;i >= 0;--i)
			insert(root,str[i].toCharArray(),i);
		
		print(root, str);
	}

}
