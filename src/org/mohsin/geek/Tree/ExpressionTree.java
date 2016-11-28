/**
 * 
 */
package org.mohsin.geek.Tree;

import java.util.Stack;

/**
 * @author mohsin
 *
 */

class Enode{
	char data;
	Enode left,right;
	
	public Enode(char ch){
		data = ch;
	}
}

public class ExpressionTree {

	public static boolean isOperator(char ch){
		
		if(ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '^' || ch == '%')
			return true;
		return false;
	}
	
	public static Enode construct(String postOrder){
		
		Stack<Enode> s = new Stack<>();
		
		int len = postOrder.length();
		for(int i = 0;i < len;++i){
			char ch = postOrder.charAt(i);
			if(!isOperator(ch)){
				Enode curr = new Enode(ch);
				s.push(curr);
			}else{
				
				Enode root = new Enode(ch);
				root.right = s.pop();
				root.left = s.pop();
				s.push(root);
			}
		}
		
		return s.pop();
	}
	
	public static void inorder(Enode root){
		
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String postOrder = "ab+ef*g*-";
		Enode root = construct(postOrder);
		inorder(root);

	}

}
