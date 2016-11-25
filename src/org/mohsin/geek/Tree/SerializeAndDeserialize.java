package org.mohsin.geek.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SerializeAndDeserialize {

	private static BufferedReader reader = null;
	private static PrintWriter writer = null;
	
	public static void serialize(TreeNode root){
		/*if(root == null){
			writer.println("-1");
			return;
		}
		
		writer.println(root.getData()+"");
		serialize(root.getLeft());
		serialize(root.getRight());*/
		
		if(root == null)
			return;
		writer.println(root.getData()+"");
		serialize(root.getLeft());
		serialize(root.getRight());
		writer.println(")");
		
	}
	
	public static TreeNode deserialize() throws IOException{
		
		String curr = reader.readLine();
		/*if(curr == null || curr.equals("-1"))
			return null;*/
		
		if(curr == null || curr.equals(")"))
			return null;
		
		TreeNode root = new TreeNode(Integer.parseInt(curr));
		root.setLeft(deserialize());
		root.setRight(deserialize());
		return root;
	}
	
	public static void main(String[] args) throws IOException {
		
		reader = new BufferedReader(new FileReader("D:\\GFG\\Geeksforgeeks\\IOFiles\\Serialize1.in"));;
		writer = new PrintWriter("D:\\GFG\\Geeksforgeeks\\IOFiles\\Serialize1.in");
		
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		serialize(root);
		writer.close();
		TreeNode res = deserialize();
		res.inorder(res);
		System.out.println();
		root.inorder(root);
		reader.close();
		

	}

}
