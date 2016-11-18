package org.geek.mohsin.interviews.N301;

public class R3Q1 {

	public static int subString(String str){
		
		int currLen = 1;
		int maxLen = 1;
		int len = str.length();
		int visited[] = new int[256];
		
		for(int i = 0;i < 256;++i)
			visited[i] = -1;
		
		visited[str.charAt(0)] = 0;
		
		for(int i = 1;i < len;++i){
			
			int prevIndex = visited[str.charAt(i)];
			
			if(prevIndex == -1 || i - currLen > prevIndex)
				currLen++;
			else{
				if(currLen > maxLen)
					maxLen = currLen;
				
				currLen = i-prevIndex;
			}
			
			visited[str.charAt(i)] = i;
		}
		if(currLen > maxLen)
			maxLen = currLen;
		
		return maxLen;
		
	}
	
	public static void main(String[] args) {
		
		String str = "GEEKSFORGEEKS";
		System.out.println(subString(str));

	}

}
