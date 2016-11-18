/**
 * 
 */
package org.mohsin.geek.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Mohsin
 *
 */
public class MaximumInWindows {

	public static void getMaxInWindow(int arr[],int k){
		
		Deque<Integer> q = new LinkedList<>();
		
		int i;
		for(i = 0;i < k;++i){
			while(!q.isEmpty() && arr[q.getLast()] <= arr[i])
				q.removeLast();
			q.addLast(i);
		}
		
		for(;i < arr.length;++i){
			System.out.println(arr[q.getFirst()]);
			
			while(!q.isEmpty() && i-k >= q.getFirst())
				q.removeFirst();
			
			while(!q.isEmpty() && arr[q.getLast()] <= arr[i])
				q.removeLast();
			q.addLast(i);
		}
		System.out.println(arr[q.getFirst()]);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] =  {12, 1, 78, 90, 57, 89, 56};
		getMaxInWindow(arr, 3);
	}

}
