package org.geek.mohsin.interviews.N315;

public class F3Q4 {

	public static int noOfWays(int n,int m)
	{
		int steps[] = new int[n];
		steps[0] = 1;
		steps[1] = 1;
		
		for(int step = 2;step < n;++step)
		{
			for(int jump = 1;jump <= m && jump <= step;++jump)
				steps[step] += steps[step-jump];
		}
		return steps[n-1];
	}
	public static void main(String[] args) {
		System.out.println(noOfWays(4+1,2));
	}

}
