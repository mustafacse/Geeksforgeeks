package org.geek.mohsin.interviews.N305;

public class R1Q2 {

	public static void merge(int a[],int b[]){
		for(int i = a.length-1;i >= 0;--i){
			int j = b.length-1;
			int last = b[j];
			for(;j >= 0 && b[j] > a[i];--j){
				if(j != b.length-1){
					b[j+1] = b[j];
				}
			}
			if(j != b.length-1){
				b[j+1] = a[i];
				a[i] = last;
			}
		}
	}
	public static void main(String[] args) {
		int ar1[] = {1, 5, 9, 10, 15, 20};
	    int ar2[] = {2, 3, 8, 13};
	    merge(ar2,ar1);
	    for(int i = 0;i < ar1.length;++i)
	    	System.out.print(ar1[i]+" ");
	    for(int j = 0;j < ar2.length;++j)
	    	System.out.print(ar2[j]+" ");

	}

}
