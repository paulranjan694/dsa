class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[n];
        int count = 0;
        for(int i=0; i<n;i++){
            if(visited[i]==0){
                count++;
                dfs(adj,visited,i);
            }
        }
        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj,int[] visited, int node){
        visited[node] = 1;
        for(int nbr : adj.get(node)){
            if(visited[nbr] == 0){
                dfs(adj,visited,nbr);
            }
        }
    }
}