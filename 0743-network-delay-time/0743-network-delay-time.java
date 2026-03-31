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
            int[] temp = pq.poll();

            int u = temp[1];
            int t = temp[0];

            for(int[] nbrs : adj.get(u)){
                int v = nbrs[0];
                int t1 = nbrs[1];
                int newt = t+t1;

                if(newt < res[v]){
                    res[v] = newt;
                    pq.offer(new int[]{newt,v});
                }
            }
        }

        int minTime = Integer.MIN_VALUE;

        for(int r=1;r<res.length;r++){
            minTime = Math.max(minTime, res[r]);
        }
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}