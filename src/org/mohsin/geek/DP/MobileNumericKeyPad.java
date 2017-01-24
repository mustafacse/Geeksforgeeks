package org.mohsin.geek.DP;

public class MobileNumericKeyPad {

	private static int row[] = { 0, 0, -1, 0, 1 };
	private static int col[] = { 0, -1, 0, 1, 0 };

	public static int recurMain(char mobile[][], int n) {


		int count = 0;

		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (mobile[i][j] != '*' && mobile[i][j] != '#') {

					count += recur(mobile, i, j, n);
				}
			}
		}
		return count;
	}

	public static int recur(char mobile[][], int i, int j, int n) {

		if(n <= 0)
			return 0;
		
		if (n == 1)
			return n;

		int res = 0;

		for (int k = 0; k < 5; ++k) {
			int r = i + row[k];
			int c = j + col[k];

			if (r >= 0 && r < 4 && c >= 0 && c < 3 && mobile[r][c] != '*' && mobile[r][c] != '#') {
				res += recur(mobile, r, c, n - 1);
			}
		}
		return res;
	}

	public static int dp(char mobile[][],int n){
		
		int count[][] = new int[10][n+1];
		
		for(int i = 0;i < 10;++i){
			count[i][0] = 0;count[i][1] = 1;}
		
		for(int len = 2;len <= n;++len){
			
			for(int i = 0;i < 4;++i){
				for(int j =0;j < 3;++j){
					if(mobile[i][j] !='*' && mobile[i][j] != '#')
					{
						int num = mobile[i][j]-'0';
						count[num][len] = 0;
						
						for(int k = 0;k < 5;++k){
							int r = i+row[k];
							int c = j+col[k];
							
							if(r >= 0 && r < 4 && c >= 0 && c < 3 && mobile[r][c] != '*' && mobile[r][c] != '#'){
								int nextNum = mobile[r][c]-'0';
								count[num][len] += count[nextNum][len-1];
							}
						}
					}
				}
			}
		}
		
		int res = 0;
		for(int i = 0;i < 10;++i)
			res += count[i][n];
		return res;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char keypad[][] = {{'1','2','3'},
                 {'4','5','6'},
                 {'7','8','9'},
                 {'*','0','#'}};
		 
		 int arr[] = {1,2,3,4,5};
		 for(int i = 0;i < arr.length;++i){
			 System.out.println(recurMain(keypad, arr[i])+" "+dp(keypad, arr[i]));
		 }
	}

}
