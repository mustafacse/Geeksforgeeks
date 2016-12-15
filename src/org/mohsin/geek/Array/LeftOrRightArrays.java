package org.mohsin.geek.Array;

public class LeftOrRightArrays {

	public static boolean isPossible(int arr[]){
		
		boolean visited[] = new boolean[arr.length];
		
		for(int i = 0;i < arr.length;++i){
			if(arr[i] < arr.length){
				if(visited[arr[i]] == false)
					visited[arr[i]] = true;
				else
					visited[arr.length - 1 - arr[i]] = true;
			}
		}
		
		for(int i = 0;i < arr.length;++i)
			if(!visited[i])
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {2, 1, 5, 2, 1, 5};
		if(isPossible(arr))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
