class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            topo.add(u);
            for(int nbr : adj.get(u)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }
        int[] res = new int[topo.size()];
        for(int i=0;i<res.length;i++){
            res[i] = topo.get(i);
        }
        return topo.size() == numCourses? res : new int[0];
    }
}