package org.mohsin.geek.Array;

import java.util.Stack;

public class NextSmallerOfNextGreater {

	/**
	 * Next greater and smaller.
	 *
	 * @param arr the arr
	 * @param next the next
	 * @param ch the ch
	 */
	public static void nextGreaterAndSmaller(int arr[],int next[],char ch){
		
		Stack<Integer> s = new Stack<>();
		
		for(int i = arr.length-1;i >= 0;--i){
			
			while(!s.empty() && (ch == 'G' ? arr[s.peek()] <= arr[i] : arr[s.peek()] >= arr[i]))
				s.pop();
			
			if(!s.empty())
				next[i] = s.peek();
			else
				next[i] = -1;
			s.push(i);
		}
	}
	
	public static void mainFun(int arr[]){
		
		int NG[] = new int[arr.length];
		int RS[] = new int[arr.length];
		
		nextGreaterAndSmaller(arr, NG, 'G');
		nextGreaterAndSmaller(arr, RS, 'S');
		
		for(int i = 0;i < arr.length;++i){
			
			if(NG[i] != -1 && RS[NG[i]] != -1)
				System.out.println(arr[RS[NG[i]]]);
			else
				System.out.println("-1");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 1, 9, 2, 5, 1, 7};
		mainFun(arr);
	}

}
