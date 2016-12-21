package org.mohsin.geek.Tree;

public class RangeUpdateAndSumBIT {

	public static void update(int bit[],int n,int index,int val){
		
		index += 1;
		while(index <= n){
			bit[index] += val;
			index += index & (-index);
		}
	}
	
	public static int getSum(int bit[],int n,int index){
		
		index += 1;
		int sum = 0;
		while(index > 0){
			sum += bit[index];
			index -= index & (-index);
		}
		return sum;
	}
	
	public static int[] constructBIT(int arr[]){
		
		int bit[] = new int[arr.length+1];
		
		for(int i = 0;i < arr.length;++i)
			update(bit, arr.length, i, arr[i]);
		
		return bit;
	}
	
	public static void updateRange(int bit[],int n,int l,int r,int val){
		
		update(bit, n, l, val);
		
		update(bit, n, r+1, -val);
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {0, 0, 0, 0, 0};
	 
	    int BITree[] = constructBIT(arr);
	 
	    // Add 2 to all the element from [2,4]
	    int l = 2, r = 4, val = 2;
	    updateRange(BITree,  arr.length, l, r, val);
	 
	    // Find the element at Index 4
	    int index = 4;
	    System.out.println(getSum(BITree, arr.length, index));
	 
	    // Add 2 to all the element from [0,3]
	    l = 0;
	    r = 3;
	    val = 4;
	    updateRange(BITree,arr.length, l, r,  val);
	 
	    // Find the element at Index 3
	    index = 3;
	    System.out.println(getSum(BITree, arr.length, index));

	}

}
