package org.mohsin.geek.DP;

import java.util.ArrayList;
import java.util.Collections;

class Job implements Comparable<Job>{
	
	int start,finish,profit;
	
	public Job(int x,int y,int z){
		start = x;
		finish = y;
		profit = z;
	}

	@Override
	public int compareTo(Job obj) {
		if(this.finish < obj.finish)
			return -1;
		else if(this.finish > obj.finish)
			return 1;
		return 0;
	}
}

public class WeightJobScheduling {

	public static int weightSchedulingRecur(ArrayList<Job> arr){
		
		Collections.sort(arr);
		
		/*for(int i = 0;i < arr.size();++i)
			System.out.println(arr.get(i).finish);*/
		
		return recursive(arr,arr.size());
	}
	
	public static int recursive(ArrayList<Job> arr,int n){
		
		if(n == 1)
			return arr.get(0).profit;
		
		int incl = arr.get(n-1).profit;
		int i = NonConflicting(arr,n);
		if(i != -1)
			incl += recursive(arr, i+1);
		int excl = recursive(arr, n-1);
		return Integer.max(incl, excl);
	}
	
	public static int NonConflicting(ArrayList<Job> arr,int n){
		
		for(int j = n-1; j >= 0;--j){
			if(arr.get(j).finish <= arr.get(n-1).start)
				return j;
		}
		return -1;
	}
	
	public static int dp(ArrayList<Job> arr){
		
		Collections.sort(arr);
		
		int table[] = new int[arr.size()];
		
		table[0] = arr.get(0).profit;
		
		for(int i = 1;i < arr.size();++i){
			
			int incl = arr.get(i).profit;
			int l = NonConflicting(arr, i);
			if(l != -1)
				incl += table[l];
			table[i] = Integer.max(table[i-1], incl);
		}
		
		return table[arr.size()-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Job> arr = new ArrayList<>();
		
		//Job arr[] = {{3, 10, 20}, {1, 2, 50}, {6, 19, 100}, {2, 100, 200}};
		arr.add(new Job(3,10,20));
		arr.add(new Job(1,2,50));
		arr.add(new Job(6,19,100));
		arr.add(new Job(2,100,200));
		
		System.out.println(weightSchedulingRecur(arr));
		System.out.println(dp(arr));
	}

}
