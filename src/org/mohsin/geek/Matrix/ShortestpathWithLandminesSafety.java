package org.mohsin.geek.Matrix;

public class ShortestpathWithLandminesSafety {

	private static int minDist = Integer.MAX_VALUE;
	private static int row[] = { 0, -1, 0, 1 };
	private static int col[] = { -1, 0, 1, 0 };

	public static void markUnSafe(int mat[][]) {

		for (int i = 0; i < mat.length; ++i) {
			for (int j = 0; j < mat[0].length; ++j) {
				if (mat[i][j] == 0) {
					for (int k = 0; k < 4; ++k)
						if (isvalid(i + row[k], j + col[k], mat.length, mat[0].length))
							mat[i + row[k]][j + col[k]] = -1;
				}
			}
		}
		
		for (int i = 0; i < mat.length; ++i) {
			for (int j = 0; j < mat[0].length; ++j) {
				if (mat[i][j] == -1) {
					mat[i][j] = 0;
				}
			}
		}
	}

	public static int shortestPath(int mat[][]) {

		boolean visited[][] = new boolean[mat.length][mat[0].length];

		markUnSafe(mat);
		for (int i = 0; i < mat.length; ++i) {

			if (mat[i][0] == 1) {
				for (int m = 0; m < mat.length; ++m)
					for (int n = 0; n < mat[0].length; ++n)
						visited[m][n] = false;
				findShortestRecur(mat, visited, i, 0, 0);

				if (minDist == mat[0].length - 1)
					break;
			}
		}

		return minDist;
	}

	public static boolean isvalid(int i, int j, int row, int col) {

		if (i < 0 || i >= row || j < 0 || j >= col)
			return false;
		return true;
	}

	public static boolean isSafe(int i, int j, int mat[][], boolean visited[][]) {

		if (mat[i][j] == 1 && !visited[i][j])
			return true;
		return false;
	}

	public static void findShortestRecur(int mat[][], boolean visited[][], int i, int j, int dist) {

		if (dist > minDist)
			return;

		if (j == mat[0].length - 1) {
			if (minDist > dist)
				minDist = dist;
			return;
		}

		visited[i][j] = true;

		for (int k = 0; k < 4; ++k) {

			if (isvalid(i + row[k], j + col[k], mat.length, mat[0].length)
					&& isSafe(i + row[k], j + col[k], mat, visited))
				findShortestRecur(mat, visited, i + row[k], j + col[k], dist + 1);
		}

		visited[i][j] = false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

		System.out.println(shortestPath(mat));
	}

}
