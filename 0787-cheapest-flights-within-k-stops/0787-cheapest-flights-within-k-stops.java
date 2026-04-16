class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int s = flight[0];
            int d = flight[1];
            int cost = flight[2];

            adj.get(s).add(new int[]{d,cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.add(new int[]{0,0,src});

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src]=0;

        while(!pq.isEmpty()){
            int[] tupple = pq.poll();
            int stop = tupple[0];
            int cost = tupple[1];
            int node = tupple[2];

            if(stop > k) continue;

            for(int[] ngbr : adj.get(node)){
                int v = ngbr[0];
                int c = ngbr[1];

                if(cost + c < costs[v]){
                    costs[v] = cost+c;
                    pq.add(new int[]{stop+1,cost+c,v});
                }
            }

        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];

    }
}