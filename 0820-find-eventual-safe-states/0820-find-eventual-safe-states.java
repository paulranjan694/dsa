class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int indegree[] = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int v = graph[i][j];

                adj.get(v).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            safeNodes.add(node);

            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.add(nbr);
            }
        }


        Collections.sort(safeNodes);
        return safeNodes;
    }
}