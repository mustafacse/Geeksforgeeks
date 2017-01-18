package org.mohsin.geek.String;

public class MaximumDepthOfParenthesis {

	public static int maxDepth(String str){
		
		int currMax = 0;
		int res = 0;
		
		int i = 0;
		int len = str.length();
		
		while(i < len){
			
			if(str.charAt(i) == '('){
				++currMax;
				if(res < currMax)
					res = currMax;
			}else{
				if(str.charAt(i) == ')')
				{
					if(currMax > 0)
						--currMax;
					else
						return -1;
				}
			}
			++i;
		}
		
		if(currMax != 0)
			return -1;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "( ((X)) (((Y))) )";
		System.out.println(maxDepth(str));
	}

}
