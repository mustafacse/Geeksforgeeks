package org.mohsin.geek.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IsReachable {

	public static boolean isReachable(Graph g,int u,int v){
		
		Queue<Integer> q = new LinkedList<>();
		q.add(u);
		boolean visited[] = new boolean[g.getV()];
		
		visited[u] = true;
		while(!q.isEmpty()){
			int curr = q.remove();
		
			LinkedList<Integer> arr = g.getNodes(curr);
			Iterator<Integer> itr = arr.iterator();
			while(itr.hasNext()){
				int temp = itr.next();
				if(temp == v)
					return true;
				if(!visited[temp]){
					q.add(temp);
					visited[temp] = true;
				}
			}
		}
		
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
		
		if(isReachable(g, 1, 3))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
