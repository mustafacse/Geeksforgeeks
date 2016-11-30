package org.geek.mohsin.interviews.N315;

public class F1Q2 {

	public static boolean isUniqueDigits(int n){
		
		if(n >= 0 && n <= 9)
			return true;
		
		int count[] = new int[10];
		while(n > 0){
			int rem = n%10;
			n /= 10;
			++count[rem];
		}
		
		for(int i = 0;i < 10;++i)
			if(count[i] > 1)
				return false;
		return true;
	}
	
	public static void printInRange(int start,int end){
		
		for(int i = start;i <= end;++i){
			if(isUniqueDigits(i))
				System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		
		printInRange(1, 20);

	}

}
