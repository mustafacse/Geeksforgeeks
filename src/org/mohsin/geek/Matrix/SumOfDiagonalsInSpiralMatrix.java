package org.mohsin.geek.Matrix;

public class SumOfDiagonalsInSpiralMatrix {

	public static int getSum(int n){
		
		if(n == 1)
			return 1;
		
		return (4*n*n-6*n+6)+getSum(n-2);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(getSum(n));
	}

}
