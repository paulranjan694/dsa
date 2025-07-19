class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v,w});
        }

        int[] timeTaken = new int[n+1];
        Arrays.fill(timeTaken,Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((int[] a, int[] b) -> a[1]-b[1]);
        timeTaken[k] = 0;
        minHeap.add(new int[]{k,0});

        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();

            int node = pair[0];
            int d = pair[1];

            for(int[] nbgr : adj.get(node)){
                int v = nbgr[0];
                int dist = nbgr[1];

                int tDist = d + dist;
                if(timeTaken[v] > tDist){
                    timeTaken[v] = tDist;
                    minHeap.add(new int[]{v,tDist});
                }
            }

        }

        int minTime = Integer.MIN_VALUE;
        for(int i = 1; i < timeTaken.length;i++){
            //System.out.println("i -> "+ i+ " time -> "+ timeTaken[i]);
            minTime = Math.max(minTime, timeTaken[i]);
        }
        
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}