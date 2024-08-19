class Solution {
    // public int findCircleNum(int[][] isConnected) {
    //     int n = isConnected.length;
    //     boolean[] visited = new boolean[n];
    //     int countProv = 0;
    //     for(int i=0;i<n;i++){
    //         if(!visited[i]){
    //             countProv++;
    //             dfs(isConnected, visited, i);
    //         }
    //     }
    //     return countProv;
    // }

    // private void dfs(int[][] isConnected, boolean[] visited, Integer node){
    //     visited[node]=true;
    //     for(int i=0;i<isConnected.length;i++){
    //         if(isConnected[node][i] == 1 && !visited[i]){
    //             dfs(isConnected, visited, i);
    //         }
    //     }
    // }


    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int countProv = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                countProv++;
                dfs(adjList,visited, i);
            }
        }
        return countProv;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Integer node){
        visited[node]=true;
        for(int it : adjList.get(node)){
            if(!visited[it]){
                   dfs(adjList,visited, it);
            }
        }
    }
}