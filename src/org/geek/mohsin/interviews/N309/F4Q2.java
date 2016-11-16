package org.geek.mohsin.interviews.N309;


public class F4Q2 {

	public static int noOfDecodings(char str[]){
		int count[] = new int[str.length+1];
		count[0] = 1;
		count[1] = 1;
		for(int i = 2;i <= str.length;++i){
			if(str[i-1] > '0')
				count[i] += count[i-1];
			if(str[i-2] < '2' || (str[i-2] == '2' && str[i-1] < '7'))
				count[i] += count[i-2];
		}
		return count[str.length];
	}
	
	public static void main(String[] args) {
		char str[] = {'1','2','3','4'};
		System.out.println(noOfDecodings(str));

	}

}
