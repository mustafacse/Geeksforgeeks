package org.mohsin.geek.Array;

public class SegmentTree {

	public static int constructSegmentTree(int arr[],int seg[],int si,int se,int index){
		
		if(si == se){
			seg[index] = arr[si];
			return arr[si];
		}

		int mid = (si+(se-si)/2);
		seg[index] = constructSegmentTree(arr, seg, si, mid, index*2+1)+constructSegmentTree(arr, seg, mid+1, se, 2*index+2);
		return seg[index];
	}
	
	public static void update(int arr[],int seg[],int i,int val){
		
		if(i < 0 || i >= arr.length)
			return;
		
		int diff = val-arr[i];
		arr[i] = val;
		updateUtil(seg,0,arr.length-1,i,0,diff);
	}
	
	public static void updateUtil(int seg[],int si,int se,int index,int idx,int diff){
		
		if(si > index || se < index)
			return;
		
		seg[idx] += diff;
		if(si != se){
		int mid = (si+(se-si)/2);
		
		updateUtil(seg, si, mid, index, 2*idx+1, diff);
		updateUtil(seg, mid+1, se, index, 2*idx+2, diff);
		}
	}
	
	public static int getSum(int seg[],int si,int se,int qs,int qe,int index){
		
		if(qs <= si && qe >= se)
			return seg[index];
		if(qs > se || si > qe )
			return 0;
		int mid = (si+(se-si)/2);
		return getSum(seg, si, mid, qs, qe, index*2+1)+getSum(seg, mid+1, se, qs, qe, index*2+2);
		
	}
	
	
}
