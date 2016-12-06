package org.mohsin.geek.Graph;

public class IsHamiltonianCycle {

	private static int V = 5;
	
	public static boolean isSafe(int graph[][],int path[],int v,int pos){
		
		if(graph[path[pos-1]][v] == 0)
			return false;
		
		for(int i = 0;i < pos;++i)
			if(path[i] == v)
				return false;
		
		return true;
	}
	
	public static boolean isHamiltonian(int graph[][],int path[],int pos){
		
		if(pos == V){
			if(graph[path[pos-1]][path[0]] == 1)
				return true;
			return false;
		}
		
		for(int i = 1;i < V;++i){
			if(isSafe(graph, path, i, pos)){
				path[pos] = i;
				if(isHamiltonian(graph, path, pos+1))
					return true;
				path[pos] = -1;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		 int graph1[][] = {{0, 1, 0, 1, 0},
                 {1, 0, 1, 1, 1},
                 {0, 1, 0, 0, 1},
                 {1, 1, 0, 0, 1},
                 {0, 1, 1, 1, 0},
                };

		 int path[] = new int[V];
		 path[0] = 0;
		 if(isHamiltonian(graph1, path, 1)){
			 for(int i = 0;i < V;++i)
				 System.out.print(path[i]+" ");
			 System.out.println(path[0]);
		 }
		 else
			 System.out.println("NO cycle");
	}

}
