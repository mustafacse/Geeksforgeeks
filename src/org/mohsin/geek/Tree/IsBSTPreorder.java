/**
 * 
 */
package org.mohsin.geek.Tree;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class IsBSTPreorder {

	public static boolean check(int pre[]){
		
		Stack<Integer> s = new Stack<>();
		
		int root = Integer.MIN_VALUE;
		for(int i = 0;i < pre.length;++i){
			
			if(pre[i] < root)
				return false;
			
			while(!s.empty() && s.peek() < pre[i]){
				root = s.pop();
			}
			
			s.push(pre[i]);
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int pre[] = {2,4,3};
		
		if(check(pre))
			System.out.println("YES");
		else
			System.out.println("NO");
			

	}

}
