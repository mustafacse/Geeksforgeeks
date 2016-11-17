/**
 * 
 */
package org.mohsin.geek.Stack;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class NextGreaterElement {

	public static void NGE(int arr[]){
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(arr[0]);
		
		for(int i = 1;i < arr.length;++i){
			if(!s.empty()){
				int curr = s.pop();
				while(curr < arr[i]){
					System.out.println(curr+" -> "+arr[i]);
					if(s.empty())
						break;
					curr = s.pop();
				}
				
				if(curr > arr[i])
					s.push(curr);
			}
			
			s.push(arr[i]);
		}
		
		while(!s.empty()){
			System.out.println(s.pop()+" -> -1");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {4,5,2,25};
		NGE(arr);

	}

}
