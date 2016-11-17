/**
 * 
 */
package org.mohsin.geek.Stack;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class ReverseStack {

	public static void reverseRecur(Stack<Integer> s){
		if(s.empty()) return;
		
		int top = s.pop();
		reverseRecur(s);
		insertAtLast(s,top);
	}
	
	public static void insertAtLast(Stack<Integer> s,int item){
		if(s.empty())
			s.push(item);
		else{
			int top = s.pop();
			insertAtLast(s, item);
			s.push(top);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		for(int i = 1;i < 7;++i){
			s.push(i);
		}
		
		reverseRecur(s);
		System.out.println(s.peek());
	}

}
