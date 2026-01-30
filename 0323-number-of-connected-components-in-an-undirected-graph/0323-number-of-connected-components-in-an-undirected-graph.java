class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adj, boolean[] vis, int u){
       vis[u] = true;
       for(int nbr : adj.get(u)){
            if(!vis[nbr]){
                dfs(adj, vis, nbr);
            }
       }
    }
}