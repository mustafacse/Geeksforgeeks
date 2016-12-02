package org.mohsin.geek.String;

public class RemoveSpecificSubStr {

	public static String remove(String str){
		
		int len = str.length();
		int i = 0;
		
		StringBuilder res = new StringBuilder();
		
		while(i < len){
			char ch = str.charAt(i);
			if(ch != 'b' && ch != 'a')
				res.append(ch);
			else{
				if(ch == 'a' && (i+1 == len || i+1 < len && str.charAt(i+1) != 'c'))
					res.append(ch);
				else if(ch == 'a')
					++i;
			}
			++i;
		}
		return new String(res);
	}
	
	public static void main(String[] args) {
	
		String str[] = {"ad","acbac","aaac","react","aa","ababaac"};
		for(int i = 0;i < str.length;++i){
			System.out.println(remove(str[i]));
		}

	}

}
