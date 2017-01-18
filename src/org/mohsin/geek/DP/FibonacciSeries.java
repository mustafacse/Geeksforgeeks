package org.mohsin.geek.DP;



public class FibonacciSeries {

	public static int recur(int n){
		
		if(n <= 1)
			return n;
		
		return recur(n-1)+recur(n-2);
	}
	
	public static int iterative(int n){
		
		if(n <= 1)
			return n;
		
		int a = 0;
		int b = 1;
		int c = 0;
		
		for(int i = 2;i <= n;++i){
			c = a+b;
			a = b;
			b = c;
		}
		
		return b;
	}
	
	public static void power(int f[][],int n){
		
		if(n == 0 || n == 1)
			return;
		
		int m[][] = {{1,1},{1,0}};
		
		power(f,n/2);
		multiply(f,f);
		
		if(n%2 != 0)
			multiply(f,m);
	}
	
	public static void multiply(int f[][],int m[][]){
		
		int x = f[0][0]*m[0][0]+f[0][1]*m[1][0];
		int y = f[0][0]*m[0][1]+f[0][1]*m[1][1];
		int z = f[1][0]*m[0][0]+f[1][1]*m[1][0];
		int w = f[1][0]*m[0][1]+f[1][1]*m[1][1];
		
		f[0][0] = x;
		f[0][1] = y;
		f[1][0] = z;
		f[1][1] = w;
		
	}
	
	public static int optimized(int n){
		
		if(n <= 1)
			return n;
		
		int f[][] = {{1,1},{1,0}};
		power(f,n-1);
		
		return f[0][0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		System.out.println(recur(n));
		System.out.println(iterative(n));
		System.out.println(optimized(n));
	}

}
