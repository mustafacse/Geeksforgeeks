package org.mohsin.geek.Tree;

class TernaryNode{
	int data;
	TernaryNode left,right,middle;
	
	public TernaryNode(int data) {
		
		this.data = data;
		this.left = this.right = this.middle = null;
	}
}

public class TernaryTree2DLL {

	private static TernaryNode head = null;
	private static TernaryNode tail = null;
	
	public static void push(TernaryNode root){
		
		if(head == null)
			head = tail = root;
		else{
			tail.right = root;
			root.left = tail;
			tail = tail.right;
		}
	}
	
	public static void convert(TernaryNode root)
	{
		if(root == null)
			return;
		 
		TernaryNode left = root.left;
		TernaryNode right = root.right;
		TernaryNode middle = root.middle;
		
		 push(root);
		 convert(left);
		 convert(middle);
		 convert(right);
		
	}
	public static void main(String[] args) {
		
		TernaryNode root = new TernaryNode(30);
		 
		    root.left = new TernaryNode(5);
		    root.middle = new TernaryNode(11);
		    root.right = new TernaryNode(63);
		 
		    root.left.left = new TernaryNode(1);
		    root.left.middle = new TernaryNode(4);
		    root.left.right = new TernaryNode(8);
		 
		    root.middle.left = new TernaryNode(6);
		    root.middle.middle = new TernaryNode(7);
		    root.middle.right = new TernaryNode(15);
		 
		    root.right.left = new TernaryNode(31);
		    root.right.middle = new TernaryNode(55);
		    root.right.right = new TernaryNode(65);
		    
		    convert(root);
		    
		    TernaryNode curr = head;
		    while(curr != null){
		    	System.out.print(curr.data+" ");
		    	curr = curr.right;
		    }

	}

}
