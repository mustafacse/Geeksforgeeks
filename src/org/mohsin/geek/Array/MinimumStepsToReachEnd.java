package org.mohsin.geek.Array;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class MinimumStepsToReachEnd {

	public static int minSteps(int arr[]){
		
		int dist[] = new int[arr.length];
		boolean visited[] = new boolean[arr.length];
		
		@SuppressWarnings("unchecked")
		Vector<Integer> graph[] = new Vector[10];
		for(int i = 0;i < 10;++i)
			graph[i] = new Vector<Integer>();
		
		for(int i = 0;i < arr.length;++i)
			graph[arr[i]].addElement(i);
		
		dist[0] = 0;
		visited[0] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()){
			
			int index = q.remove();
			
			int size = graph[arr[index]].size();
			for(int i = 0;i < size;++i){
				int next = graph[arr[index]].elementAt(i);
				if(!visited[next]){
					dist[next] = dist[index]+1;
					visited[next] = true;
					q.add(next);
				}
			}
			
			graph[arr[index]].clear();
			
			if(index-1 >= 0 && !visited[index-1]){
				dist[index-1] = dist[index]+1;
				visited[index-1] = true;
				q.add(index-1);
			}
			
			if(index+1 < arr.length && !visited[index+1]){
				dist[index+1] = dist[index]+1;
				visited[index+1] = true;
				q.add(index+1);
			}
		}
		
		return dist[arr.length-1];
	}
	
	
	public static void main(String[] args) {
		
		 int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 5,
                 4, 3, 6, 0, 1, 2, 3, 4, 5, 7};
		 
		 System.out.println(minSteps(arr));

	}

}
