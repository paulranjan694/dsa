class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int countProv = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                countProv++;
                dfs(isConnected, visited, i);
            }
        }
        return countProv;
    }

    private void dfs(int[][] isConnected, boolean[] visited, Integer node){
        visited[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(isConnected, visited, i);
            }
        }
    }
}