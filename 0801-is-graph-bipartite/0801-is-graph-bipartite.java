class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            if(color[i] == 0){
                if(dfs(color,adj,i,1) == false) return false;
            }
        }
        return true;
    }

    boolean dfs(int[] color, ArrayList<ArrayList<Integer>> adj, int node, int currentColor){
        if(color[node] != 0){
            if(color[node] == currentColor){
                return true;
            }else{
                return false;
            }
        }

        color[node] = currentColor;
        for(int nbr : adj.get(node)){
            if(dfs(color,adj, nbr, -currentColor) == false) return false;
        }
        return true;
    }
}