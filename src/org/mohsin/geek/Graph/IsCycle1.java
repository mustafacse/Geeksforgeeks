package org.mohsin.geek.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class IsCycle1 {

	public static boolean isCycle(Graph g){
		
		int v = g.getV();
		boolean visited[] = new boolean[v];
		boolean recurStk[] = new boolean[v];
		
		for(int i = 0;i < v;++i){
			if(!visited[i]){
				if(isCycleUtil(g,i,visited,recurStk))
					return true;
			}
		}
		return false;
	}
	
	public static boolean isCycleUtil(Graph g,int v,boolean visited[],boolean recurStk[]){
		
		visited[v] = true;
		recurStk[v] = true;
		
		LinkedList<Integer> arr = g.getNodes(v);
		Iterator<Integer> itr = arr.iterator();
		while(itr.hasNext()){
			int u = itr.next();
			if(!visited[u] && isCycleUtil(g, u, visited, recurStk))
				return true;
			else if(recurStk[u])
				return true;
		}
		
		recurStk[v] = false;
		return false;
	}
	
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		if(isCycle(g))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
