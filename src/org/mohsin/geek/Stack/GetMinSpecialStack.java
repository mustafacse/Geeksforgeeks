/**
 * 
 */
package org.mohsin.geek.Stack;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class GetMinSpecialStack {

	private static Stack<Integer> s = new Stack<>();
	private static Stack<Integer> aux = new Stack<>();
	
	public static void insert(int data)
	{
		if(s.empty()){
			s.push(data);
			aux.push(data);
		}else{
			s.push(data);
			if(data <= aux.peek())
				aux.push(data);
		}
	}
	
	public static void delete(){
		if(s.empty())
			return;
		
		int top = s.pop();
		if(aux.peek() == top)
			aux.pop();
		System.out.println(top+" popped");
	}
	
	public static void getMin(){
		System.out.println("Min = "+aux.peek());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		insert(10);
		insert(20);
		insert(30);
		
		getMin();
		insert(5);
		getMin();
		delete();
		getMin();

	}

}
