class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            adj.get(u).add(v);
        }

        //indegree array 
        for(int i=0;i<numCourses;i++){
            for(int nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int count=0;

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            count++;

            for(int nbr : adj.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        // if count == V, that means topo sort is generated and no cycle detected or else cycle detected
        return count == numCourses; 
    }
}