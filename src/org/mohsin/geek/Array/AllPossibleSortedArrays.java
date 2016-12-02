package org.mohsin.geek.Array;

public class AllPossibleSortedArrays {

	public static void generate(int a[],int b[],int c[],int i,int j,int len,boolean flag){
		
		if(flag){
			if(len >= 1)
				printArr(c,len);
			for(int k = i;k < a.length;++k){
				if(len == 0)
				{
					c[len] = a[k];
					generate(a,b,c,k+1,j,len+1,!flag);
				}else{
					if(c[len-1] < a[k]){
						c[len] = a[k];
						generate(a, b, c, k+1, j, len+1, !flag);
					}
				}
			}
		}
		else{
			for(int k = j;k < b.length;++k){
				if(c[len-1] < b[k]){
					c[len] = b[k];
					generate(a,b,c,i,k+1,len+1,!flag);
				}
			}
		}
	}
	
	public static void printArr(int arr[],int len){
		for(int i = 0;i < len;++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int A[] = {10, 15, 25};
	    int B[] = {5, 20, 30};
	    int C[] = new int[A.length+B.length];
	    
	    generate(A, B, C, 0, 0, 0, true);

	}

}
