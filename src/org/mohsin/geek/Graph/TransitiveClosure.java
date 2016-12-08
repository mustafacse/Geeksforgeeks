package org.mohsin.geek.Graph;

public class TransitiveClosure {

	public static void closure(int graph[][]){
		
		int v = graph.length;
		int res[][] = new int[v][v];
		
		for(int i = 0;i < v;++i){
			for(int j = 0;j < v;++j){
				res[i][j] = graph[i][j];
			}
		}
		
		for(int k = 0;k < v;++k){
			for(int i = 0;i < v;++i){
				for(int j = 0;j < v;++j){
					if(res[i][j] == 1 || (graph[i][k] == 1 && graph[k][j] == 1))
						res[i][j] = 1;
					else
						res[i][j] = 0;
				}
			}
		}
		
		for(int i = 0;i < v;++i){
			for(int j = 0;j < v;++j){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		  int graph[][] = { {1, 1, 0, 1},
                  {0, 1, 1, 0},
                  {0, 0, 1, 1},
                  {0, 0, 0, 1}
                };

		  closure(graph);
	}

}
