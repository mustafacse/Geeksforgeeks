/*
	APPROACH : 	   Iterate through every element of string array and check in trie whether its a prefix of
				   any present string or not.
				   Special case : We can have palidrome of even length or odd length. So if the first character doen't match 
				   we can ignore it and iterate for the next position. 
				   Case 1: If we find this string as a prefix of another string, we will add these two strings and check whether
				   they are palindrome or not. If they are palindorme, just return true.
				   Case 2: Otherwise reverse the string and insert into trie.
				   
				   
*/
package org.mohsin.geek.String;

import java.util.ArrayList;

// Trie Node
class TNode {
	boolean leafNode;  //to store whether it's a leaf or not
	ArrayList<Integer> indexes; // to store array indexes
	TNode children[];		// to store child nodes

	public TNode() {
		children = new TNode[256];
		leafNode = false;
		indexes = new ArrayList<>();
	}
}

public class CheckAnyTwoArePalindromicOrNot {

	private static ArrayList<String> data = new ArrayList<>(); //ArrayList to store strings
	
	
	//function to insert in a Trie
	
	public static void insert(TNode root, String str, int currIndex) {

		int len = str.length();

		for (int i = 0; i < len; ++i) {

			int index = str.charAt(i) - 'a';
			if (root.children[index] == null)
				root.children[index] = new TNode();
			root = root.children[index];
			root.indexes.add(currIndex);
		}
		root.leafNode = true;
	}

	
	//Function to check whether the given string is palindrome or nor
	
	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			++left;
			--right;
		}
		return true;
	}

	
	//Function to reverse a string 
	
	public static String reverseStr(String str) {

		int right = str.length() - 1;
		String rev = "";

		while (right >= 0) {
			rev += str.charAt(right);
			--right;
		}

		return rev;
	}

	
	public static boolean checkHelper(TNode root, String str, int currIndex,boolean flag) {

		int len = str.length();

		TNode header = root;

		for (int i = 0; i < len; ++i) {
			int index = str.charAt(i) - 'a';
			if (root.children[index] == null) {
				if(flag)
					insert(header, reverseStr(str), currIndex);
				return false;
			}
			root = root.children[index];
		}

		ArrayList<Integer> arr = root.indexes;
		int size = arr.size();
		for (int i = 0; i < size; ++i) {
			String temp = data.get(arr.get(i)) + str;
			if (isPalindrome(temp)) {
				System.out.println("( " + arr.get(i) + ", " + currIndex + " )");
				return true;
			}
		}

		insert(header, reverseStr(str), currIndex);
		return false;

	}

	public static boolean check(TNode root, String str, int index){
		
		int firstIndex = str.charAt(0)-'a';
		
		if(root.children[firstIndex] != null)
			return checkHelper(root, str, index,true);
		
		ArrayList<TNode> possibleNodes = new ArrayList<>();
		for(int i = 0;i < 256;++i){
			if(root.children[i] != null){
				TNode curr = root.children[i];
				if(curr.children[firstIndex] != null)
					possibleNodes.add(curr);
			}
		}
		
		int size = possibleNodes.size();
		if(size == 0){
			insert(root, reverseStr(str), index);
		}
		else{
			for(int i = 0;i < size-1;++i){
				if(checkHelper(possibleNodes.get(i), str, index,false))
					return true;
			}
			return checkHelper(possibleNodes.get(size-1), str, index,true);
		}
		return false;
	}

	public static void main(String[] args) {

		//insert some data in our arrayList
		data.add("abc");
		data.add("ab");
		data.add("ba");

		TNode root = new TNode(); //create a root for Trie
		int size = data.size();

		boolean flag = false;

		for (int index = 0; index < size; ++index) {	//iterate through the list and check for palindrome pair
			if (check(root, data.get(index), index)) {
				System.out.println("yes");
				flag = true;
				break;
			}
		}

		if (flag == false) //if no such pair founds
			System.out.println("No such pair found");
	}

}
