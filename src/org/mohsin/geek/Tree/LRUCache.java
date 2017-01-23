package org.mohsin.geek.Tree;

import java.util.HashMap;

public class LRUCache {

	private static int size = 0;
	private static int count = 0;
	private static TreeNode front = null,rear = null;
	private static HashMap<Integer,TreeNode> hm = new HashMap<>();
	
	public static void referencePage(int page){
		
		if(hm.get(page) == null){
			insert(page);
		}else{
			
			TreeNode curr = hm.get(page);
			if(curr != front){
				if(curr == rear){
					rear = curr.getLeft();
					rear.setRight(null);
					
					curr.setRight(front);
					front.setLeft(curr);
					curr.setLeft(null);
					front = curr;
				}else{
					TreeNode temp = front;
					while(temp.getRight() != curr)
						temp = temp.getRight();
					temp.setRight(curr.getRight());
					curr.getRight().setLeft(temp);
					
					curr.setRight(front);
					front.setLeft(curr);
					curr.setLeft(null);
					front = curr;
				}
			}
		}
		
	}
	
	public static void insert(int page){
		
		if(front == null){
			front = rear = new TreeNode(page);
			++count;
		}else{
			if(count == size)
				delete();
			++count;
			TreeNode newNode = new TreeNode(page);
			newNode.setRight(front);
			front.setLeft(newNode);
			front = newNode;
		}
	}
	
	public static void delete(){
		
		--count;
		
		rear = rear.getLeft();
		rear.setRight(null);
	}
	
	public static void printState(){
		
		TreeNode curr = front;
		
		while(curr != rear){
			System.out.println(curr.getData());
			curr = curr.getRight();
		}
		System.out.println(curr.getData());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		size = 4;
		int arr[] = {1,2,3,1,4,5};
		
		for(int i = 0;i < arr.length;++i){
			referencePage(arr[i]);
		}
		
		printState();
		
	}

}
