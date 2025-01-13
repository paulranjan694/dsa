class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            //Arraylist<Integer> al = new Arraylist<Integer>();
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,visited,adj);
                ans++;
            }else{
                visited[i]=1;
            }
        }
        return ans;
    }

    private void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        ArrayList<Integer> list = adj.get(node);
        for(int nghbr : list){
            if(visited[nghbr] != 1){
                dfs(nghbr,visited,adj);
            }
        }
    }
}