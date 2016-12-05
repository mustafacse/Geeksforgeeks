package org.mohsin.geek.Array;

public class BinaryIndexedTree {

	public static void upDate(int bit[],int n,int i,int val){
		int index = i+1;
		while(index <= n){
			bit[index] += val;
			index += index & (-index); 
		}
	}
	
	public static int getSum(int bit[],int i){
		
		int sum = 0;
		int index = i+1;
		while(index > 0){
			sum += bit[index];
			index -= index & (-index);
		}
		return sum;
	}
	
	public static int[] constructBIT(int arr[]){
		
		int bit[] = new int[arr.length+1];
		
		for(int i = 0;i < arr.length;++i)
			upDate(bit, arr.length, i, arr[i]);
		
		return bit;
	}
	
	public static void main(String[] args) {
		
		int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		int bit[] = constructBIT(freq);
		
		System.out.println(getSum(bit, 5));
		freq[3] += 6;
		upDate(bit, freq.length, 3,6);
		System.out.println(getSum(bit, 5));
	}

}
