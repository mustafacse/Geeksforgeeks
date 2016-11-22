package org.mohsin.geek.Matrix;

public class MagicSquare {

	public static void magicSquare(int n){
		
		int mat[][] = new int[n][n];
		
		int i = n/2;
		int j = (n-1);
		
		int total = n*n;
		
		for(int num = 1;num <= total;){
			if(i == -1 && j == n){
				i = 0;
				j = n-2;
			}else{
				if(i == -1)
					i = n-1;
				if(j == n)
					j = 0;
			}
			
			if(mat[i][j] != 0){
				j -= 2;
				++i;
				continue;
			}
			mat[i][j] = num++;
			--i;
			++j;
		}
		
		System.out.println("magic sum = "+(n*(n*n+1)/2));
		for(int k = 0;k < n;++k){
			for(int l = 0;l < n;++l){
				System.out.print(mat[k][l]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		magicSquare(3);

	}

}
