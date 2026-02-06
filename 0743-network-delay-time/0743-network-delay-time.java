class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new int[]{v,t});
        }

        int[] res = new int[n+1];

        Arrays.fill(res,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        res[k]=0;

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int src = node[1], t = node[0];

            for(int[] nbrNode : adj.get(src)){
                int v = nbrNode[0], t1 = nbrNode[1];
                int tempTime = t1+t;
                if(tempTime < res[v]){
                    res[v] = tempTime;
                    pq.offer(new int[]{tempTime, v});
                }
            }
        }

        int minTime = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(res[i]==Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, res[i]);
        }
        return minTime;
    }
}