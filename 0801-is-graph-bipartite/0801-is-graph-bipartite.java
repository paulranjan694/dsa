class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
		
		// ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // for(int i=0;i<=n;i++){
        //     adj.add(new ArrayList<Integer>());
        // }

        // for(Vector<Integer> list : edges){
        //     int u = list.get(0);
        //     int v = list.get(1);

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }

		for(int i=0;i<n;i++){
			if(color[i] == 0){
				if(dfs(graph,color,i,1) == false) return false;
			}
		}
		return true;
    }

    private boolean dfs(int[][] adj, int[] color, int node, int currColor){
		if(color[node] != 0){
			if(color[node] == currColor){
				return true;
			}else{
				return false;
			}
		}

		color[node] = currColor;
		for(int nbr : adj[node]){
			if(dfs(adj,color,nbr,-currColor) == false) return false;
		}
		return true;
	}
}