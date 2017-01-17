package org.mohsin.geek.DP;

public class WordWrap {

	public static int lineCut(int l[],int n,int m){
		
		int extras[][] = new int[n+1][n+1];
		int lc[][] = new int[n+1][n+1];
		int c[] = new int[n+1];
		int p[] = new int[n+1];
		
		for(int i = 1;i <= n;++i){
			
			extras[i][i] = m-l[i-1];
			for(int j = i+1;j <= n;++j){
				extras[i][j] = extras[i][j-1]-l[j-1]-1;
			}
		}
		
		for(int i = 1;i <= n;++i){
			for(int j = 1;j <= n;++j){
				if(extras[i][j] < 0)
					lc[i][j] = Integer.MAX_VALUE;
				else if(extras[i][j] >=0 && j == n)
					lc[i][j] = 0;
				else
					lc[i][j] = extras[i][j]*extras[i][j];
			}
		}
		
		c[0] = 0;
		for(int j = 1;j <= n;++j){
			c[j] = Integer.MAX_VALUE;
			for(int i = 1;i <= j;++i){
				if(c[i-1] != Integer.MAX_VALUE && lc[i][j] != Integer.MAX_VALUE && (c[i-1]+lc[i][j] < c[j])){
					c[j] = c[i-1]+lc[i][j];
					p[j] = i;
				}
			}
		}
		
		return print(p,n);
	}
	
	public static int print(int p[],int n){
		int k = 0;
		
		if(p[n] == 1)
			k = 1;
		else
			k = print(p,p[n]-1)+1;
		System.out.println(" Line no "+k+" from word "+p[n]+" to word "+n);
		return k;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int l[] = {3, 2, 2, 5};
		int m = 6;
		int n = l.length;
		lineCut(l, n, m);
	}

}
