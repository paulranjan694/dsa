class Solution {
    private static final int MOD =  1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        int[] count = new int[n];
        long[] times = new long[n];

        List<List<int[]>> adj = constructAdj(n,roads);

        Arrays.fill(times,Long.MAX_VALUE);

        times[0]=0;
        count[0]=1;

        PriorityQueue<long[]> minheap = new PriorityQueue<>((long[] a, long[] b) -> Long.compare(a[1],b[1])); // 0 -> node,1 -> time

        minheap.add(new long[]{0,0});

        while(!minheap.isEmpty()){
            long[] pair = minheap.poll();
            int node = (int)pair[0];
            long time = pair[1];
      
            if (time > times[node]) continue;

            for(int[] ngrs : adj.get(node)){
                int v = ngrs[0];
                int t = ngrs[1];

                long newTime = t + time;
               
                if(times[v] > newTime){
                    times[v] = newTime;
                    minheap.add(new long[]{v,newTime});
                    count[v]=count[node];
                }else if(times[v] == newTime){
                    count[v]=(count[v]+count[node]) % MOD;
                }
            }
        }
        return count[n-1] % MOD;
    }

    private List<List<int[]>> constructAdj(int n, int[][] roads){
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
        }
        return adj;
    }
}