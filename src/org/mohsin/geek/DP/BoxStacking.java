package org.mohsin.geek.DP;

import java.util.ArrayList;
import java.util.Collections;

class Box implements Comparable<Box>{
	
	int h,w,d;
	
	public Box(int x,int y,int z){
		h = x;
		w = y;
		d = z;
	}

	@Override
	public int compareTo(Box obj) {
		
		if(obj.w*obj.d < this.w*this.d)
			return -1;
		if(obj.w*obj.d > this.w*this.d)
			return 1;
		return 0;
	}
}

public class BoxStacking {

	public static int dp(ArrayList<Box> arr){
		
		ArrayList<Box> rotations = new ArrayList<>();
		
		int size = arr.size();
		
		for(int i = 0;i < size;++i){
			
			Box curr = arr.get(i);
			
			rotations.add(curr);
			
			Box first = new Box(curr.w,Integer.min(curr.d, curr.h),Integer.max(curr.d, curr.h));
			rotations.add(first);
			
			Box second = new Box(curr.d,Integer.min(curr.h, curr.w),Integer.max(curr.h, curr.w));
			rotations.add(second);
		}
		
		int n = rotations.size();
		
		
		Collections.sort(rotations);
		
		/*for(int i = 0;i < n;++i){
			System.out.println(rotations.get(i).d*rotations.get(i).w);
		}*/
		
		int msh[] = new int[n];
		
		for(int i = 0;i < n;++i)
			msh[i] = rotations.get(i).h;
		
		for(int i = 1;i < n;++i){
			for(int j = 0;j < i;++j){
				if(rotations.get(j).w > rotations.get(i).w
						&& rotations.get(j).d > rotations.get(i).d
						&& msh[i] < msh[j]+rotations.get(i).h){
					msh[i] = msh[j]+rotations.get(i).h;
				}
			}
		}
		
		int max = msh[0];
		
		for(int i = 1;i < n;++i){
			if(msh[i] > max)
				max = msh[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  arr[][] = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
		
		ArrayList<Box> boxes = new ArrayList<>();
		for(int i = 0;i < arr.length;++i){
			boxes.add(new Box(arr[i][0],arr[i][1],arr[i][2]));
		}
		
		System.out.println(dp(boxes));
	}

}
