class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];

        int ans=0;

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,visited,isConnected);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int node, int[] visited, int[][] isConnected){
        visited[node] = 1;
        for(int i =0;i < isConnected.length;i++){
            if(node != i && isConnected[node][i]==1 && visited[i]==0){
                dfs(i,visited,isConnected);
            }
        }
    }
}