package org.mohsin.geek.Matrix;

public class MobileNumericKeyPad {

	private static int rMove[] = { 0, -1, 0, 0, 1 };
	private static int cMove[] = { 0, 0, -1, 1, 0 };

	public static int count(char keyPad[][], int n) {

		int total = 0;

		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (keyPad[i][j] != '*' && keyPad[i][j] != '#')
					total += countUtil(keyPad, i, j, n);
			}
		}

		return total;
	}

	public static int countUtil(char keyPad[][], int i, int j, int n) {

		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		int total = 0;

		for (int move = 0; move < 5; ++move) {
			int row = i + rMove[move];
			int col = j + cMove[move];

			if (row >= 0 && row < 4 && col >= 0 && col < 3 && keyPad[row][col] != '*' && keyPad[row][col] != '#') {
				total += countUtil(keyPad, row, col, n - 1);
			}
		}

		return total;
	}

	public static int optimisedDP(char keyPad[][],int n){
		
		if(n <= 0)
			return 0;
		if(n == 1)
			return 10;
		
		int count[][] = new int[10][n+1];
		
		for(int i = 0;i < 10;++i){
			count[i][0] = 0;
			count[i][1] = 1;
		}
		
		for(int k = 2;k <= n;++k){
			for(int i = 0;i < 4;++i){
				for(int j = 0;j < 3;++j){
					if(keyPad[i][j] != '*' && keyPad[i][j] != '#'){
						
						int num = keyPad[i][j] - '0';
						count[num][k] = 0;
						
						for(int move = 0;move < 5;++move){
							int row = i+rMove[move];
							int col = j+cMove[move];
							if(row >= 0 && row < 4 && col >= 0 && col < 3 && 
									keyPad[row][col] != '*' && keyPad[row][col] != '#'){
								int nextNum = keyPad[row][col] - '0';
								count[num][k] += count[nextNum][k-1];
							}
								
						}
					}
				}
			}
		}
		
		int total = 0;
		for(int i = 0;i < 10;++i){
			total += count[i][n];
		}
		return total;
	}
	
	public static void main(String[] args) {

		char keyPad[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };

		for (int i = 1; i <= 5; ++i)
			System.out.println(count(keyPad, i)+" "+optimisedDP(keyPad, i));
	}

}
