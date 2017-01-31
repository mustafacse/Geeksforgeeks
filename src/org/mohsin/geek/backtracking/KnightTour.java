package org.mohsin.geek.backtracking;

public class KnightTour {

	private static int N = 0;
	private static int row[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int col[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static boolean isValid(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= N)
			return false;
		return true;
	}

	public static boolean knightsTour(int mat[][], int i, int j, int move) {

		if (move == N * N)
			return true;

		for (int k = 0; k < 8; ++k) {
			int r = i + row[k];
			int c = j + col[k];
			if (isValid(r, c) && mat[r][c] == -1) {
				mat[r][c] = move;
				if (knightsTour(mat, r, c, move + 1))
					return true;
				mat[r][c] = -1;
			}
		}
		return false;
	}

	public static void mainFun(int N) {
		int mat[][] = new int[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				mat[i][j] = -1;
			}
		}
		mat[0][0] = 0;
		knightsTour(mat, 0, 0, 1);

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 8;
		mainFun(N);
	}

}
