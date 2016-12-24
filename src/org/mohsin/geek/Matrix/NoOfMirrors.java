package org.mohsin.geek.Matrix;

public class NoOfMirrors {

	public static int mirrors(char mat[][]){
		
		int n = mat.length;
		
		int horozontal[] = new int[n];
		int vertical[] = new int[n];
		
		for(int i = 0;i < n;++i){
			
			for(int j = n-1;j >= 0;--j){
				if(mat[i][j] == 'B')
					continue;
				horozontal[i] = j;
				break;
			}
		}
		
		for(int j = 0;j < n;++j){
			for(int i = n-1;i >= 0;--i){
				if(mat[i][j] == 'B')
					continue;
				vertical[j] = i;
				break;
			}
		}
		
		int res = 0;
		for(int i = 0;i < n;++i){
			for(int j = 0;j < n;++j){
				if(i > vertical[j] && j > horozontal[i])
					++res;
			}
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		
		
	}

}
