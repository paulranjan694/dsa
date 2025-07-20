class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //int[] stop = new int[n];
        int[] cost = new int[n];

        List<List<int[]>> adj = constructAdj(n,flights);

        Arrays.fill(cost,Integer.MAX_VALUE);
        //Arrays.fill(stop,Integer.MAX_VALUE);

        cost[src]=0;
        //stop[src]=0;

        PriorityQueue<int[]> minheap = new PriorityQueue<>((int[] a, int[] b) -> a[2]-b[2]); // 0 -> node,1 -> cost,2 -> stop//give pref to stops

        minheap.add(new int[]{src,0,0});

        while(!minheap.isEmpty()){
            int[] tupple = minheap.poll();
            int node = tupple[0];
            int c = tupple[1];
            int st = tupple[2];
            if(st > k) continue;

            for(int[] ngrs : adj.get(node)){
                int v = ngrs[0];
                int c1 = ngrs[1];

                if(c1+c < cost[v]){
                    cost[v] = c1+c;
                    minheap.add(new int[]{v,c1+c,st+1});
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    private List<List<int[]>> constructAdj(int n, int[][] flights){
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adj.get(from).add(new int[]{to,price});
        }
        return adj;
    }
}