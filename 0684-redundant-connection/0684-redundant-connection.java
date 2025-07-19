class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = edges.length+1;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
           int u = edges[i][0];
           int v = edges[i][1];
           
           adj.get(u).add(v);
           adj.get(v).add(u);

            boolean[] visited = new boolean[V];
            if(dfs(adj,visited,u,-1)){
                return edges[i];
            } 
            
         
        }

        return null;
    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int u, int parent){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                if(dfs(adj,visited,v,u)){
                    return true;
                }
            }else if(v!=parent){
                return true;
            }
        }
        return false;
    }
}