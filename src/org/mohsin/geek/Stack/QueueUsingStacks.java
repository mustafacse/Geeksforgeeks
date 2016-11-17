package org.mohsin.geek.Stack;

import java.util.Stack;

public class QueueUsingStacks {

	private static Stack<Integer> s1 = new Stack<>();
	private static Stack<Integer> s2 = new Stack<>();
	
	public void enqueue(int data)
	{
		s1.push(data);
	}
	
	public int dequeue(){
		if(s1.empty() && s2.empty()) return -1;
		if(!s2.empty()) return s2.pop();
		while(!s1.empty()){
			s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public static void main(String[] args) {
		
		QueueUsingStacks q = new QueueUsingStacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println(q.dequeue());

	}

}
