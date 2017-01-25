package org.mohsin.geek.DP;

public class UglyNumber {

	public static int maxDivide(int a,int b){
		
		while(a%b == 0)
			a /= b;
		return a;
	}
	
	public static int uglyNum(int n){
		
		int i = 1;
		int count = 1;
		
		while(count < n){
			++i;
			if(isugly(i))
				++count;
		}
		
		return i;
	}
	
	public static boolean isugly(int n){
		
		n = maxDivide(n, 2);
		n = maxDivide(n, 3);
		n = maxDivide(n, 5);
		
		
		return n == 1;
	}
	
	public static int dp(int n){
		
		int ugly[] = new int[n];
		int nextMulOf2 = 2;
		int nextMulOf3 = 3;
		int nextMulOf5 = 5;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		ugly[0] = 1;
		int nextUgly = 0;
		
		for(int i = 1;i < n;++i){
			
			nextUgly = Integer.min(nextMulOf2, Integer.min(nextMulOf3, nextMulOf5));
			ugly[i] = nextUgly;
			
			if(nextUgly == nextMulOf2){
				i2++;
				nextMulOf2 = ugly[i2]*2;
				
			}if(nextUgly == nextMulOf3){
				i3++;
				nextMulOf3 = ugly[i3]*3;
				
			}
			if(nextUgly == nextMulOf5){
				i5++;
				nextMulOf5 = ugly[i5]*5;
		
			}
		}
		
		return nextUgly;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 150;
		System.out.println(uglyNum(n));
		System.out.println(dp(n));
	}

}
