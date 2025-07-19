class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
           int u = prerequisites[i][1];
           int v = prerequisites[i][0];
           
           adj.get(u).add(v);
        }
        
        int[] indegree = new int[numCourses];
        for(List<Integer> list: adj){
            for(int v: list){
                indegree[v]++;
            }
        }
        
        boolean[] visited = new boolean[numCourses];
        //ArrayList<Integer> res = new ArrayList<>();
        int[] res = new int[numCourses];
        int count=0;
        
       Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< numCourses;i++){
            if(indegree[i]== 0){
                queue.add(i);
                count++;
            }
        }
        int idx=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            res[idx++]=node;
            
            for(int v: adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.add(v);
                    count++;
                }
            }
        }
       
        return count == numCourses ? res : new int[0];
    }
}