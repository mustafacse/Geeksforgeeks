package org.mohsin.geek.String;

import java.util.Arrays;

import org.mohsin.geek.List.ListNode;

/*
 *
 * 
 * Approach : 1. Iterate through every string in given array and sort it.
 * 			  2. After sorting insert it into Trie and add index at leaf Node head.
 * 			  3. Traverse trie and whenever there is a leaf, iterate through the list of index and print
 *               the strings.
 */


// Trie Class

class Anagramnode{
	
	boolean isLeaf;                              //to store leaf information
	Anagramnode children[];						 // to store child node
	ListNode head;                              // to store indexes of strings
	
	public Anagramnode(){
		isLeaf = false;
		children = new Anagramnode[256];
		head = null;
	}
}


public class PrintAllAngramsTogether {

	//function to insert into trie
	
	public static void insert(Anagramnode root,char str[],int val){
		
		Arrays.sort(str);            // sort the string before insertion
		
		for(int i = 0;i < str.length;++i){
			int index = str[i]-'a';
			if(root.children[index] == null)  //if current node is not present, create a new one.
				root.children[index] = new Anagramnode();
			root = root.children[index];
		}
		
		root.isLeaf = true;              //mark it as leaf node
		if(root.head == null){
			root.head = new ListNode(val);           // if head is null, initialize it and add index
		}else{
			ListNode newNode = new ListNode(val);    // add index in the existing list
			newNode.setNext(root.head);
			root.head = newNode;
		}
	}
	
	//function to iterate through trie and print all anagrams together
	
	public static void print(Anagramnode root,String str[]){
		
		if(root == null)
			return;
		
		//if its a leaf node iterate through list of index and print it.
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
