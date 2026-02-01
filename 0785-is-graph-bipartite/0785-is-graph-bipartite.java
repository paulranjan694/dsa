class Solution {
    int n;
    public boolean isBipartite(int[][] graph) {
        n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(bfs(graph, color, i, 1) == false){
                    return false;
                }
            }
        }

        return true; 
    }

    private boolean bfs(int[][] graph, int[] color, int node, int currCol){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = currCol;

        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : graph[u]){
                if(color[v] == color[u]){
                    return false;
                }else if(color[v] == -1){
                    color[v] = 1 - color[u];
                    q.offer(v);
                }
            }
        }
        return true;
    }
}