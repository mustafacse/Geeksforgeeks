package org.mohsin.geek.Array;

class AugNode{
	private int data;
	private AugNode left;
	private AugNode right;
	private int size;
	private int height;
	public AugNode(int data) {
		super();
		this.data = data;
		this.height = 1;
		this.size = 1;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public AugNode getLeft() {
		return left;
	}
	public void setLeft(AugNode left) {
		this.left = left;
	}
	public AugNode getRight() {
		return right;
	}
	public void setRight(AugNode right) {
		this.right = right;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
public class CountSmallerOnright {

	private static int res[] = new int[100];
	
	public static int max(int a,int b){
		return a > b ? a : b;
	}
	
	public static int size(AugNode root){
		if(root == null)
			return 0;
		return root.getSize();
	}
	
	public static int height(AugNode root){
		if(root == null)
			return 0;
		return root.getHeight();
	}
	public static AugNode insert(AugNode root,AugNode newNode,int index){
		
		if(root == null){
			return newNode;
		}
		
		if(root.getData() > newNode.getData())
			root.setLeft(insert(root.getLeft(),newNode,index));
		else{
			root.setRight(insert(root.getRight(),newNode,index));
			res[index] += size(root.getLeft())+1;
		}
		
		root.setHeight(max(height(root.getLeft()),height(root.getRight()))+1);
		root.setSize(size(root.getLeft())+size(root.getRight())+1);
		
		int balance = getBalance(root);
		if(balance < -1 && root.getRight().getData() < newNode.getData())
			return leftRotate(root);
		if(balance > 1 && root.getLeft().getData() > newNode.getData())
			return rightRotate(root);
		if(balance > 1 && root.getLeft().getData() < newNode.getData()){
			root.setLeft(leftRotate(root.getLeft()));
			return rightRotate(root);
		}
		if(balance < -1 && root.getRight().getData() >newNode.getData()){
			root.setRight(rightRotate(root.getRight()));
			return leftRotate(root);
		}
		return root;
	}
	
	public static int getBalance(AugNode root){
		if(root == null)
			return 0;
		return height(root.getLeft()) - height(root.getRight());
	}
	
	public static AugNode leftRotate(AugNode X){
		AugNode Y = X.getRight();
		AugNode T2 = Y.getLeft();
		
		Y.setLeft(X);
		X.setRight(T2);
		
		X.setHeight(max(height(X.getLeft()),height(X.getRight()))+1);
		Y.setHeight(max(height(Y.getLeft()),height(Y.getRight()))+1);
		
		X.setSize(size(X.getLeft())+size(X.getRight())+1);
		Y.setSize(size(Y.getLeft())+size(Y.getRight())+1);
		
		return Y;
	}
	
	public static AugNode rightRotate(AugNode Y){
		AugNode X = Y.getLeft();
		AugNode T2 = X.getRight();
		
		X.setRight(Y);
		Y.setLeft(T2);
		
		Y.setHeight(max(height(Y.getLeft()),height(Y.getRight()))+1);
		X.setHeight(max(height(X.getLeft()),height(X.getRight()))+1);
		
		Y.setSize(size(Y.getLeft())+size(Y.getRight())+1);
		X.setSize(size(X.getLeft())+size(X.getRight())+1);
		
		
		return Y;
	}
	
	public static void countSmaller(int arr[]){
		AugNode root = null;
		for(int i = arr.length-1;i >= 0;--i){
			root = insert(root,new AugNode(arr[i]), i);
		}
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(res[i]+" ");
	}
	public static void main(String[] args) {
		int arr[] = {10, 6, 15, 20, 30, 5, 7};
		countSmaller(arr);

	}

}
