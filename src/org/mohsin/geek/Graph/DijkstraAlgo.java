package org.mohsin.geek.Graph;

import java.util.Arrays;

public class DijkstraAlgo {

	public static void dijkstra(int graph[][],int src){
		
		int dist[] = new int[graph.length];
		boolean spt[] = new boolean[graph.length];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		for(int i = 0;i < graph.length-1;++i){
			
			int u = find(dist,spt);
			spt[u] = true;
			
			for(int v = 0;v < graph.length;++v){
				if(graph[u][v] != 0 && !spt[v] && dist[u] != Integer.MAX_VALUE && 
						dist[u]+graph[u][v] < dist[v])
					dist[v] = dist[u]+graph[u][v];
			}
		}
		
		for(int i = 0;i < dist.length;++i)
			System.out.print(dist[i]+" ");
		
		
	}
	
	
	public static int find(int dist[],boolean spt[]){
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0;i < dist.length;++i){
			if(!spt[i] && dist[i] < min){
				min = dist[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {

		 int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                 {4, 0, 8, 0, 0, 0, 0, 11, 0},
                 {0, 8, 0, 7, 0, 4, 0, 0, 2},
                 {0, 0, 7, 0, 9, 14, 0, 0, 0},
                 {0, 0, 0, 9, 0, 10, 0, 0, 0},
                 {0, 0, 4, 14, 10, 0, 2, 0, 0},
                 {0, 0, 0, 0, 0, 2, 0, 1, 6},
                 {8, 11, 0, 0, 0, 0, 1, 0, 7},
                 {0, 0, 2, 0, 0, 0, 6, 7, 0}
                };

		 dijkstra(graph, 0);

	}

}
