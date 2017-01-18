package org.mohsin.geek.String;

public class IsGrammerCorrectlyFollowed {

	public static boolean isCorrect(String str){
		
		int len = str.length();
		
		if(len == 0)
			return true;
		if(str.charAt(0) < 'A' || str.charAt(0) > 'Z')
			return false;
		if(str.charAt(len-1) != '.')
			return false;
		
		char prev = str.charAt(0);
		
		for(int i = 1;i < len;++i){
			
			char curr = str.charAt(i);
			
			if(curr >= 'A' && curr <= 'Z' && prev >= 'A' && prev <= 'Z')   //no consecutive Uppercase
				return false;
			if(curr >= 'A' && curr <= 'Z' && prev >= 'a' && prev <= 'z')   // Lowercase can't be followed with uppercase
					return false;
			if(prev == ' ' && curr == ' ')   //no consecutive spaces
				return false;
			if(curr == '.' && i+1 < len)	// '.' means it must be end of string
				return false;
			prev = curr;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = { "I love cinema.", "The vertex is S.",
                "I am single.", "My name is KG.",
                "I lovE cinema.", "GeeksQuiz. is a quiz site.",
                "I love Geeksquiz and Geeksforgeeks.",
                "  You are my friend.", "I love cinema" };
		
		for(int i = 0;i < arr.length;++i){
			if(isCorrect(arr[i]))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

}
