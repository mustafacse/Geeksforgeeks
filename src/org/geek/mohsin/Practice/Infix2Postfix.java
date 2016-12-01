package org.geek.mohsin.Practice;

import java.util.Stack;

public class Infix2Postfix {

	public static int precedence(char ch){
		
		switch(ch){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default :
			return -1;
		}
	}
	
	public static boolean isOperator(char ch){
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
			return true;
		return false;
	}
	
	public static void convert(String str){
		
		Stack<Character> s = new Stack<>();
		int len = str.length();
		for(int i = 0;i < len;++i){
			char ch = str.charAt(i);
			if(!isOperator(ch))
				System.out.print(ch);
			else{
				while(!s.empty() && precedence(ch) <= precedence(s.peek())){
					System.out.print(s.pop());
				}
				s.push(ch);
			}
		}
		
		while(!s.empty()){
			System.out.print(s.pop());
		}
	}
	
	public static void main(String[] args) {
		
		String str = "a+b*c-d";
		convert(str);
	}

}
