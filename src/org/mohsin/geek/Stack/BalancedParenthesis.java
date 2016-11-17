/**
 * 
 */
package org.mohsin.geek.Stack;

import java.util.Stack;

/**
 * @author mohsin
 *
 */
public class BalancedParenthesis {

	public static boolean isBalanced(String str) {
		if (str.isEmpty())
			return true;

		Stack<Character> s = new Stack<>();
		int len = str.length();
		for (int i = 0; i < len; ++i) {
			char ch = str.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[')
				s.push(ch);
			else {
				if (s.empty())
					return false;
				char top = s.pop();
				switch (ch) {
				case '}':
					if (top != '{')
						return false;
					break;
				case ']':
					if (top != '[')
						return false;
					break;
				case ')':
					if (top != '(')
						return false;
				}
			}
		}
		if (s.empty())
			return true;
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "{()[]";
		if (isBalanced(str))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
