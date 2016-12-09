package org.mohsin.geek.Matrix;

public class FloodFill {

	public static void fill(int mat[][], int x, int y, int prevC, int newC) {

		if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
			return;

		if (mat[x][y] != prevC)
			return;

		mat[x][y] = newC;
		fill(mat, x + 1, y, prevC, newC);
		fill(mat, x, y + 1, prevC, newC);
		fill(mat, x - 1, y, prevC, newC);
		fill(mat, x, y - 1, prevC, newC);
	}

	public static void printMatrix(int mat[][]) {

		for (int i = 0; i < mat.length; ++i) {
			for (int j = 0; j < mat[0].length; ++j)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		int x = 4, y = 4, newC = 3;
		int prevC = screen[x][y];
		fill(screen, x, y, prevC, newC);
		printMatrix(screen);
		
	}

}
