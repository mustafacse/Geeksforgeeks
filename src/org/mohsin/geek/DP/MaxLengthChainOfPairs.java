package org.mohsin.geek.DP;

import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair>{

	int a,b;
	
	public Pair(int x,int y){
		a = x;
		b = y;
	}
	
	@Override
	public int compareTo(Pair obj) {
		if(obj.a > obj.b)
			return -1;
		if(obj.a < obj.b)
			return 1;
		return 0;
	}
	
}

public class MaxLengthChainOfPairs {

	public static int maxChain(ArrayList<Pair> arr){
		
		int LC[] = new int[arr.size()];
		
		for(int i = 0;i < arr.size();++i)
			LC[i] = 1;
		
		for(int i = 1;i < arr.size();++i){
			for(int j = 0;j < i;++j){
				if(arr.get(i).a > arr.get(j).b && LC[i] < LC[j]+1)
					LC[i] = LC[j]+1;
			}
		}
		
		int max = LC[0];
		for(int i = 1;i < LC.length;++i){
			if(LC[i] > max)
				max = LC[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pair> arr =  new ArrayList<>();
		Pair res[] = { new Pair(5, 24), new Pair(15, 25),
                new Pair(27, 40), new Pair(50, 60) };
		
		for(int i = 0;i < res.length;++i)
			arr.add(res[i]);
		
		Collections.sort(arr);
		
		System.out.println(maxChain(arr));
	}

}

