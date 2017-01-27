package org.mohsin.geek.Matrix;

import java.util.Stack;

public class MaxAreaRactangle {

	/* Complete the function given below */
		public static int ractangleArea(int arr[]) {

			int n = arr.length;
			int i = 0;

			Stack<Integer> s = new Stack<>();
			int maxArea = 0;
			while (i < n) {
				if (s.empty() || arr[s.peek()] <= arr[i])
					s.push(i++);
				else {
					int top = s.peek();
					s.pop();
					int area = arr[top] * (s.empty() == true ? i : i - s.peek() - 1);
					maxArea = Integer.max(maxArea, area);
				}
			}

			while (!s.empty()) {
				int top = s.peek();
				s.pop();
				int area = arr[top] * (s.empty() == true ? i : i - s.peek() - 1);
				maxArea = Integer.max(maxArea, area);
			}
			return maxArea;
		}

		public static void maxArea(int a[][], int m, int n) {

			int arr[] = new int[n];
			int maxArea = 0;
			for(int i = 0;i < n;++i)
				arr[i] = a[0][i];
			maxArea = ractangleArea(arr);
			for (int i = 1; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (a[i][j] == 1) a[i][j] += a[i - 1][j];
				}
				for(int k = 0;k < n;++k)
					arr[k] = a[i][k];
				maxArea = Integer.max(maxArea,ractangleArea(arr));
			}
			System.out.println(maxArea);
		}

	public static void main(String[] args) {
		
		int mat1[][] ={{ 0, 1, 1, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1,},
				{1, 1, 0, 0}};
		maxArea(mat1,mat1.length,mat1[0].length);

	}

}
