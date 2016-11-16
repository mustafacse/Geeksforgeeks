package org.geek.mohsin.interviews.N309;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int top;
	int bottom;
	
	public Node(){
		
	}
	public Node(int top,int bottom)
	{
		this.top = top;
		this.bottom = bottom;
	}
}

class TNode{
	Node data;
	TNode left;
	TNode right;
	
	public TNode(Node data)
	{
		this.data = data;
		this.left = this.right = null;
	}
}

public class F3Q2 {

	public static void meanHeapify(Node arr[],int index)
	{
		int smallest = index;
		int left = index*2+1;
		int right = index*2+2;
		
		if(left < arr.length && arr[left].bottom < arr[smallest].bottom)
			smallest = left;
		if(right < arr.length && arr[right].bottom < arr[smallest].bottom)
			smallest = right;
		if(smallest != index){
			Node temp = arr[index];
			arr[index] = arr[smallest];
			arr[smallest] = temp;
			meanHeapify(arr,smallest);
		}
	}
	
	public static void buildMeanHeap(Node arr[])
	{
		for(int i = (arr.length-2)/2;i >= 0;--i)
			meanHeapify(arr,i);
	}
	
	public static TNode constructBst(TNode root,TNode newNode)
	{
		if(root == null) return newNode;
		if(root.data.top > newNode.data.top)
			root.left = constructBst(root.left, newNode);
		else
			root.right = constructBst(root.right, newNode);
		return root;
	}
	
	public static void inorder(TNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.data.top+" "+root.data.bottom);
		inorder(root.right);
	}
	
	public static void levelOrder(TNode root)
	{
		if(root == null) return;
		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			root = queue.remove();
			if(root == null){
				if(!queue.isEmpty())
					queue.add(null);
				System.out.println("*************");
			}
			else{
				System.out.print(root.data.top+" "+root.data.bottom+" ");
				if(root.left != null)
					queue.add(root.left);
				if(root.right != null)
					queue.add(root.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Node arr[] = new Node[5];
		for(int i = 0;i < 5;++i)
			arr[i] = new Node();
		arr[0].top = 10;
		arr[0].bottom = 5;
		arr[1].top = 15;
		arr[1].bottom = 10;
		arr[2].top = 12;
		arr[2].bottom = 3;
		arr[3].top = 11;
		arr[3].bottom = 9;
		arr[4].top = 25;
		arr[4].bottom = 8;
		
		buildMeanHeap(arr);
		
		TNode root = new TNode(arr[0]);
		for(int i = 1;i < arr.length;++i){
			root = constructBst(root,new TNode(arr[i]));
		}
		
		//inorder(root);
		levelOrder(root);
	}

}
