package org.mohsin.geek.Matrix;

public class TicToeGame {

	private static int win[][] =  {{0, 1, 2}, // Check first row.
            {3, 4, 5}, // Check second Row
            {6, 7, 8}, // Check third Row
            {0, 3, 6}, // Check first column
            {1, 4, 7}, // Check second Column
            {2, 5, 8}, // Check third Column
            {0, 4, 8}, // Check first Diagonal
            {2, 4, 6}}; // Check second Diagonal

	
	public static boolean isWin(char game[],char ch){
		
		for(int i = 0;i < 8;++i){
			if(game[win[i][0]] == ch && game[win[i][1]] == ch && game[win[i][2]] == ch)
				return true;
		}
		return false;
	}
	
	public static boolean isValid(char game[]){
		
		int xCount = 0, oCount = 0;
		
		for(int i = 0;i < game.length;++i){
			if(game[i] == 'O')
				++oCount;
			else
				++xCount;
		}
		
		if(xCount == oCount || xCount == oCount+1){
			if(isWin(game,'O')){
				if(isWin(game,'X'))
					return false;
				return xCount == oCount;
			}
			if(isWin(game,'X') && xCount != oCount+1)
				return false;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		 char board[] = {'X', 'X', 'O',
                 'O', 'O', 'X',
                 'X', 'O', 'X'};
		 
		 if(isValid(board))
			 System.out.println("Yes valid");
		 else
			 System.out.println("Not valid");

	}

}
