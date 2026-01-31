class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count=0;
        for(int u=0;u<n;u++){
            if(!visited[u]){
                dfs(isConnected, visited,u);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int u){
        visited[u]=true;

        for(int v=0;v<n;v++){
            if(!visited[v] && isConnected[u][v] == 1){
                dfs(isConnected, visited, v);
            }
        }
    }
}