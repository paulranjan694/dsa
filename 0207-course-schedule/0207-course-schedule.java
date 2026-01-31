class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] preq : prerequisites){
            int u = preq[1];
            int v = preq[0];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                    count++;
                }
            }
        }

        return count == numCourses;
    }
}