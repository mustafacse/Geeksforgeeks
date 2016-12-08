package org.mohsin.geek.Matrix;

public class InPlaceTranspose {

	public static void transpose(int graph[], int row, int col) {

		int size = (row * col) - 1;
		boolean hash[] = new boolean[row * col];
		hash[0] = hash[size] = true;

		int i = 1;
		while (i < size) {
			int t = graph[i];
			int cycleBegin = i;
			do {
				int next = (i * row) % size;
				int temp = t;
				t = graph[next];
				graph[next] = temp;
				hash[i] = true;
				i = next;
			} while (i != cycleBegin);

			for (i = 1; i < size && hash[i]; ++i)
				;
		}
	}

	public static void printMatrix(int a[], int r, int c) {

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				System.out.print(a[i * c + j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int r = 5, c = 6;
		int a[] = new int[r * c];

		for (int i = 0; i < r * c; ++i)
			a[i] = i + 1;

		printMatrix(a, r, c);
		transpose(a, r, c);
		printMatrix(a, c, r);

	}

}
