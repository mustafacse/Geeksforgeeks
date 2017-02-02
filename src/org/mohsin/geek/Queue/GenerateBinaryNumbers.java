package org.mohsin.geek.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

	public static void generate(int n){
		
		if(n <= 0)
			return ;
		Queue<String> q = new LinkedList<>();
		q.add("1");
		while(n > 0){
			String curr = q.remove();
			System.out.println(curr);
			
			String first = curr+"0";
			String second = curr+"1";
			
			q.add(first);
			q.add(second);
			--n;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		generate(n);
	}

}
